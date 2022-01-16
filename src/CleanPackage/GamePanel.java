package CleanPackage;

import CleanPackage.Trash.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Objects;


/**
 * Główna obszar graficzny gry
 * Klasa dziedzicząca po klasie JPanel
 *
 * @author Bartosz Nysztal
 */
public class GamePanel extends JPanel {

    /**
     * Szerokość pola graficznego gry
     */
    public int sWidth;
    /**
     * Obiekt reprezentujący status gry
     */
    public int sHeight;
    public Pause pause;
    public Menu menu;
    /**
     * Czcionki stosowane w pasku Menu
     */
    public Font menuFont;
    /**
     * Czcionki stosowane jako alert w polu gry
     */
    public Font alertFont;

    /**
     * Obiekt pierwszego planu
     */
    private final Character character;
    private final Wall[][] wall;
    private final Dumbster[] dumbster;
    private final TrashBanana trashBanana;
    private final TrashGlassBottle trashGlassBottle;
    private final TrashNewspaper trashNewspaper;
    private final TrashApple trashApple;
    private final TrashEgg trashEgg;
    private final TrashCap trashCap;
    private final TrashCardboard trashCardboard;
    private final TrashMilk trashMilk;
    private final TrashSmoke trashSmoke;
    private final TrashDiaper trashDiaper;
    private final TrashCan trashCan;
    private final TrashJar trashJar;
    public static Map map;

    /**
     * Konstruktor klasy pola graficznego gry.
     * Ustawienia początkowe oraz ładowanie zasobów
     * Ponadto dodanie obsługi zdarzeń w polu graficznym gry
     *
     * @param width  Szerokość pola graficznego gry
     * @param height Wysokość pola graficznego gry
     */
    public GamePanel(int width, int height) {
        menuFont = new Font("Dialog", Font.BOLD, 36);
        alertFont = new Font("Dialog", Font.BOLD, 21);
        setFocusable(true);
        requestFocusInWindow();
        this.sWidth = width;
        this.sHeight = height;

        map = new Map();
        pause = new Pause(14 * 80, 15 * 64);
        menu = new Menu(15 * 80, 15 * 64);
        trashBanana = new TrashBanana("Banan");
        trashGlassBottle = new TrashGlassBottle("Szklana butelka");
        trashNewspaper = new TrashNewspaper("Gazeta");
        trashApple = new TrashApple("Ogryzek");
        trashEgg = new TrashEgg("Skorupka jajka");
        trashCap = new TrashCap("Kapsel");
        trashCardboard = new TrashCardboard("Karton");
        trashMilk = new TrashMilk("Karton po mleku");
        trashSmoke = new TrashSmoke("Pet");
        trashDiaper = new TrashDiaper("Pielucha");
        trashCan = new TrashCan("Puszka");
        trashJar = new TrashJar("Sloik");
        dumbster = new Dumbster[5];
        dumbster[0] = new Dumbster("green");
        dumbster[1] = new Dumbster("black");
        dumbster[2] = new Dumbster("blue");
        dumbster[3] = new Dumbster("yellow");
        dumbster[4] = new Dumbster("brown");
        character = new Character(5 * 80, 6 * 64);
        wall = new Wall[16][15];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 15; j++) {
                wall[i][j] = new Wall();
            }
        }


        restartGame();

        /* Dodaj obsługę zdarzeń - wciśnięcie strzałki*/
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == 39) {
                    character.moveRight();
                } else if (ke.getKeyCode() == 37) {
                    character.moveLeft();
                } else if (ke.getKeyCode() == 38) {
                    character.moveUp();
                } else if (ke.getKeyCode() == 40) {
                    character.moveDown();
                }
                repaint();
            }
        });

        /* Dodaj obsługę zdarzeń - wciśnięcie przycisku myszki*/
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (Data.menu && me.getX() > 470 && me.getX() < 720 && me.getY() > 585 && me.getY() < 620) {
                    System.exit(1);
                }
                if (Data.menu && me.getX() > 470 && me.getX() < 685 && me.getY() > 485 && me.getY() < 520) {
                    Data.level = 1;
                    Data.menu = false;
                    restartGame();
                }
                if (Data.menu && me.getX() > 470 && me.getX() < 835 && me.getY() > 385 && me.getY() < 420) {
                    if (Data.level == 1) {
                        Data.level = 2;
                        Data.menu = false;
                    } else if (Data.level == 2) {
                        Data.level = 1;
                        Data.menu = false;
                    }
                    restartGame();
                }
                if (Data.endGamePoints == 6 && me.getX() > 470 && me.getX() < 720 && me.getY() > 665 && me.getY() < 700) {
                    Data.level = 1;
                    restartGame();
                }
                if (Data.endGamePoints == 6 && me.getX() > 470 && me.getX() < 720 && me.getY() > 615 && me.getY() < 650) {
                    if (Data.level == 1) {
                        Data.level = 2;
                    } else if (Data.level == 2) {
                        Data.level = 1;
                    }
                    restartGame();
                }

                if (me.getX() < pause.getX() + 80 && me.getX() > pause.getX()
                        && me.getY() < pause.getY() + 64 && me.getY() > pause.getY()) {
                    pause.pauseGame();
                    if (Data.pause) {
                        Data.stopTime = System.currentTimeMillis();
                    } else {
                        Data.pauseTime = System.currentTimeMillis();
                        Data.timePaused = Data.timePaused + (Data.pauseTime - Data.stopTime);
                    }
                }
                if (me.getX() < menu.getX() + 80 && me.getX() > menu.getX()
                        && me.getY() < menu.getY() + 64 && me.getY() > menu.getY()) {
                    menu.gameMenu();
                }
                if (me.getX() < trashBanana.getX() + 80 && me.getX() > trashBanana.getX()
                        && me.getY() < trashBanana.getY() + 64 && me.getY() > trashBanana.getY()
                        && character.getY() > trashBanana.getY() - 65 && character.getY() < trashBanana.getY() + 65
                        && character.getX() > trashBanana.getX() - 81 && character.getX() < trashBanana.getX() + 81) {
                    trashBanana.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashGlassBottle.getX() + 80 && me.getX() > trashGlassBottle.getX()
                        && me.getY() < trashGlassBottle.getY() + 64 && me.getY() > trashGlassBottle.getY()
                        && character.getY() > trashGlassBottle.getY() - 65 && character.getY() < trashGlassBottle.getY() + 65
                        && character.getX() > trashGlassBottle.getX() - 81 && character.getX() < trashGlassBottle.getX() + 81) {
                    trashGlassBottle.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashNewspaper.getX() + 80 && me.getX() > trashNewspaper.getX()
                        && me.getY() < trashNewspaper.getY() + 64 && me.getY() > trashNewspaper.getY()
                        && character.getY() > trashNewspaper.getY() - 65 && character.getY() < trashNewspaper.getY() + 65
                        && character.getX() > trashNewspaper.getX() - 81 && character.getX() < trashNewspaper.getX() + 81) {
                    trashNewspaper.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashApple.getX() + 80 && me.getX() > trashApple.getX()
                        && me.getY() < trashApple.getY() + 64 && me.getY() > trashApple.getY()
                        && character.getY() > trashApple.getY() - 65 && character.getY() < trashApple.getY() + 65
                        && character.getX() > trashApple.getX() - 81 && character.getX() < trashApple.getX() + 81) {
                    trashApple.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashEgg.getX() + 80 && me.getX() > trashEgg.getX()
                        && me.getY() < trashEgg.getY() + 64 && me.getY() > trashEgg.getY()
                        && character.getY() > trashEgg.getY() - 65 && character.getY() < trashEgg.getY() + 65
                        && character.getX() > trashEgg.getX() - 81 && character.getX() < trashEgg.getX() + 81) {
                    trashEgg.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashCap.getX() + 80 && me.getX() > trashCap.getX()
                        && me.getY() < trashCap.getY() + 64 && me.getY() > trashCap.getY()
                        && character.getY() > trashCap.getY() - 65 && character.getY() < trashCap.getY() + 65
                        && character.getX() > trashCap.getX() - 81 && character.getX() < trashCap.getX() + 81) {
                    trashCap.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashCardboard.getX() + 80 && me.getX() > trashCardboard.getX()
                        && me.getY() < trashCardboard.getY() + 64 && me.getY() > trashCardboard.getY()
                        && character.getY() > trashCardboard.getY() - 65 && character.getY() < trashCardboard.getY() + 65
                        && character.getX() > trashCardboard.getX() - 81 && character.getX() < trashCardboard.getX() + 81) {
                    trashCardboard.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashMilk.getX() + 80 && me.getX() > trashMilk.getX()
                        && me.getY() < trashMilk.getY() + 64 && me.getY() > trashMilk.getY()
                        && character.getY() > trashMilk.getY() - 65 && character.getY() < trashMilk.getY() + 65
                        && character.getX() > trashMilk.getX() - 81 && character.getX() < trashMilk.getX() + 81) {
                    trashMilk.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashSmoke.getX() + 80 && me.getX() > trashSmoke.getX()
                        && me.getY() < trashSmoke.getY() + 64 && me.getY() > trashSmoke.getY()
                        && character.getY() > trashSmoke.getY() - 65 && character.getY() < trashSmoke.getY() + 65
                        && character.getX() > trashSmoke.getX() - 81 && character.getX() < trashSmoke.getX() + 81) {
                    trashSmoke.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashDiaper.getX() + 80 && me.getX() > trashDiaper.getX()
                        && me.getY() < trashDiaper.getY() + 64 && me.getY() > trashDiaper.getY()
                        && character.getY() > trashDiaper.getY() - 65 && character.getY() < trashDiaper.getY() + 65
                        && character.getX() > trashDiaper.getX() - 81 && character.getX() < trashDiaper.getX() + 81) {
                    trashDiaper.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashCan.getX() + 80 && me.getX() > trashCan.getX()
                        && me.getY() < trashCan.getY() + 64 && me.getY() > trashCan.getY()
                        && character.getY() > trashCan.getY() - 65 && character.getY() < trashCan.getY() + 65
                        && character.getX() > trashCan.getX() - 81 && character.getX() < trashCan.getX() + 81) {
                    trashCan.moveToEquipment(5 * 80, 15 * 64);
                }
                if (me.getX() < trashJar.getX() + 80 && me.getX() > trashJar.getX()
                        && me.getY() < trashJar.getY() + 64 && me.getY() > trashJar.getY()
                        && character.getY() > trashJar.getY() - 65 && character.getY() < trashJar.getY() + 65
                        && character.getX() > trashJar.getX() - 81 && character.getX() < trashJar.getX() + 81) {
                    trashJar.moveToEquipment(5 * 80, 15 * 64);
                }


                for (int i = 0; i < 5; i++) {
                    if (me.getX() < trashGlassBottle.getX() + 80 && me.getX() > trashGlassBottle.getX()
                            && me.getY() < trashGlassBottle.getY() + 64 && me.getY() > trashGlassBottle.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashGlassBottle.getX() || 6 * 80 == trashGlassBottle.getX() || 7 * 80 == trashGlassBottle.getX()
                            || 8 * 80 == trashGlassBottle.getX() || 9 * 80 == trashGlassBottle.getX() || 10 * 80 == trashGlassBottle.getX()
                            || 11 * 80 == trashGlassBottle.getX()) && trashGlassBottle.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "green")) {
                            trashGlassBottle.moveToEquipment(0, 0);
                            trashGlassBottle.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashGlassBottle.throwAway(0, 0);
                            trashGlassBottle.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < trashBanana.getX() + 80 && me.getX() > trashBanana.getX()
                            && me.getY() < trashBanana.getY() + 64 && me.getY() > trashBanana.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashBanana.getX() || 6 * 80 == trashBanana.getX() || 7 * 80 == trashBanana.getX()
                            || 8 * 80 == trashBanana.getX() || 9 * 80 == trashBanana.getX() || 10 * 80 == trashBanana.getX()
                            || 11 * 80 == trashBanana.getX()) && trashBanana.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "brown")) {
                            trashBanana.moveToEquipment(0, 0);
                            trashBanana.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashBanana.throwAway(0, 0);
                            trashBanana.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < trashCardboard.getX() + 80 && me.getX() > trashCardboard.getX()
                            && me.getY() < trashCardboard.getY() + 64 && me.getY() > trashCardboard.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashCardboard.getX() || 6 * 80 == trashCardboard.getX() || 7 * 80 == trashCardboard.getX()
                            || 8 * 80 == trashCardboard.getX() || 9 * 80 == trashCardboard.getX() || 10 * 80 == trashCardboard.getX()
                            || 11 * 80 == trashCardboard.getX()) && trashCardboard.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "blue")) {
                            trashCardboard.moveToEquipment(0, 0);
                            trashCardboard.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashCardboard.throwAway(0, 0);
                            trashCardboard.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < trashMilk.getX() + 80 && me.getX() > trashMilk.getX()
                            && me.getY() < trashMilk.getY() + 64 && me.getY() > trashMilk.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashMilk.getX() || 6 * 80 == trashMilk.getX() || 7 * 80 == trashMilk.getX()
                            || 8 * 80 == trashMilk.getX() || 9 * 80 == trashMilk.getX() || 10 * 80 == trashMilk.getX()
                            || 11 * 80 == trashMilk.getX()) && trashMilk.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "yellow")) {
                            trashMilk.moveToEquipment(0, 0);
                            trashMilk.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashMilk.throwAway(0, 0);
                            trashMilk.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < trashSmoke.getX() + 80 && me.getX() > trashSmoke.getX()
                            && me.getY() < trashSmoke.getY() + 64 && me.getY() > trashSmoke.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashSmoke.getX() || 6 * 80 == trashSmoke.getX() || 7 * 80 == trashSmoke.getX()
                            || 8 * 80 == trashSmoke.getX() || 9 * 80 == trashSmoke.getX() || 10 * 80 == trashSmoke.getX()
                            || 11 * 80 == trashSmoke.getX()) && trashSmoke.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "black")) {
                            trashSmoke.moveToEquipment(0, 0);
                            trashSmoke.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashSmoke.throwAway(0, 0);
                            trashSmoke.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < trashDiaper.getX() + 80 && me.getX() > trashDiaper.getX()
                            && me.getY() < trashDiaper.getY() + 64 && me.getY() > trashDiaper.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashDiaper.getX() || 6 * 80 == trashDiaper.getX() || 7 * 80 == trashDiaper.getX()
                            || 8 * 80 == trashDiaper.getX() || 9 * 80 == trashDiaper.getX() || 10 * 80 == trashDiaper.getX()
                            || 11 * 80 == trashDiaper.getX()) && trashDiaper.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "black")) {
                            trashDiaper.moveToEquipment(0, 0);
                            trashDiaper.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashDiaper.throwAway(0, 0);
                            trashDiaper.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < trashCan.getX() + 80 && me.getX() > trashCan.getX()
                            && me.getY() < trashCan.getY() + 64 && me.getY() > trashCan.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashCan.getX() || 6 * 80 == trashCan.getX() || 7 * 80 == trashCan.getX()
                            || 8 * 80 == trashCan.getX() || 9 * 80 == trashCan.getX() || 10 * 80 == trashCan.getX()
                            || 11 * 80 == trashCan.getX()) && trashCan.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "yellow")) {
                            trashCan.moveToEquipment(0, 0);
                            trashCan.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashCan.throwAway(0, 0);
                            trashCan.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < trashJar.getX() + 80 && me.getX() > trashJar.getX()
                            && me.getY() < trashJar.getY() + 64 && me.getY() > trashJar.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashJar.getX() || 6 * 80 == trashJar.getX() || 7 * 80 == trashJar.getX()
                            || 8 * 80 == trashJar.getX() || 9 * 80 == trashJar.getX() || 10 * 80 == trashJar.getX()
                            || 11 * 80 == trashJar.getX()) && trashJar.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "green")) {
                            trashJar.moveToEquipment(0, 0);
                            trashJar.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashJar.throwAway(0, 0);
                            trashJar.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < trashNewspaper.getX() + 80 && me.getX() > trashNewspaper.getX()
                            && me.getY() < trashNewspaper.getY() + 64 && me.getY() > trashNewspaper.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashNewspaper.getX() || 6 * 80 == trashNewspaper.getX() || 7 * 80 == trashNewspaper.getX()
                            || 8 * 80 == trashNewspaper.getX() || 9 * 80 == trashNewspaper.getX() || 10 * 80 == trashNewspaper.getX()
                            || 11 * 80 == trashNewspaper.getX()) && trashNewspaper.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "blue")) {
                            trashNewspaper.moveToEquipment(0, 0);
                            trashNewspaper.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashNewspaper.throwAway(0, 0);
                            trashNewspaper.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < trashApple.getX() + 80 && me.getX() > trashApple.getX()
                            && me.getY() < trashApple.getY() + 64 && me.getY() > trashApple.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashApple.getX() || 6 * 80 == trashApple.getX() || 7 * 80 == trashApple.getX()
                            || 8 * 80 == trashApple.getX() || 9 * 80 == trashApple.getX() || 10 * 80 == trashApple.getX()
                            || 11 * 80 == trashApple.getX()) && trashApple.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "brown")) {
                            trashApple.moveToEquipment(0, 0);
                            trashApple.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashApple.throwAway(0, 0);
                            trashApple.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < trashEgg.getX() + 80 && me.getX() > trashEgg.getX()
                            && me.getY() < trashEgg.getY() + 64 && me.getY() > trashEgg.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashEgg.getX() || 6 * 80 == trashEgg.getX() || 7 * 80 == trashEgg.getX()
                            || 8 * 80 == trashEgg.getX() || 9 * 80 == trashEgg.getX() || 10 * 80 == trashEgg.getX()
                            || 11 * 80 == trashEgg.getX()) && trashEgg.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "brown")) {
                            trashEgg.moveToEquipment(0, 0);
                            trashEgg.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashEgg.throwAway(0, 0);
                            trashEgg.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }

                    if (me.getX() < trashCap.getX() + 80 && me.getX() > trashCap.getX()
                            && me.getY() < trashCap.getY() + 64 && me.getY() > trashCap.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashCap.getX() || 6 * 80 == trashCap.getX() || 7 * 80 == trashCap.getX()
                            || 8 * 80 == trashCap.getX() || 9 * 80 == trashCap.getX() || 10 * 80 == trashCap.getX()
                            || 11 * 80 == trashCap.getX()) && trashCap.getY() == 15 * 64) {
                        if (Objects.equals(dumbster[i].color, "yellow")) {
                            trashCap.moveToEquipment(0, 0);
                            trashCap.goodOrBad=true;
                            Data.endGamePoints++;
                            Data.points++;
                        } else {
                            trashCap.throwAway(0, 0);
                            trashCap.goodOrBad=false;
                            Data.endGamePoints++;
                        }
                    }
                }
                repaint();
            }
        });
    }

    /**
     * Nadpisz metodę odpowiedzialną za odrysowanie panelu - własne wypełnienie
     * pola graficznego gry, zgodnie z wybraną treścią.
     *
     * @param gs
     */
    @Override
    protected void paintComponent(Graphics gs) {
        Graphics2D g = (Graphics2D) gs;
        //Ustaw tryb lepszej jakości grafiki (wygładzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tło i  inne elementy
        g.drawImage(Data.bgImage, 0, 0, null);
        g.drawImage(Data.trashBananaImage, trashBanana.getX(), trashBanana.getY(), null);
        g.drawImage(Data.trashGlassBottleImage, trashGlassBottle.getX(), trashGlassBottle.getY(), null);
        g.drawImage(Data.pauseImage, pause.getX(), pause.getY(), null);
        g.drawImage(Data.menuImage, menu.getX(), menu.getY(), null);
        for (int i = 0; i < 5; i++) {
            if (Objects.equals(dumbster[i].color, "black")) {
                g.drawImage(Data.blackDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            } else if (Objects.equals(dumbster[i].color, "green")) {
                g.drawImage(Data.greenDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            } else if (Objects.equals(dumbster[i].color, "yellow")) {
                g.drawImage(Data.yellowDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            } else if (Objects.equals(dumbster[i].color, "blue")) {
                g.drawImage(Data.blueDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            } else if (Objects.equals(dumbster[i].color, "brown")) {
                g.drawImage(Data.brownDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            }
        }
        g.drawImage(Data.trashBananaImage, trashBanana.getX(), trashBanana.getY(), null);
        g.drawImage(Data.trashGlassBottleImage, trashGlassBottle.getX(), trashGlassBottle.getY(), null);
        g.drawImage(Data.trashNewspaperImage, trashNewspaper.getX(), trashNewspaper.getY(), null);
        g.drawImage(Data.trashAppleImage, trashApple.getX(), trashApple.getY(), null);
        g.drawImage(Data.trashEggImage, trashEgg.getX(), trashEgg.getY(), null);
        g.drawImage(Data.trashCapImage, trashCap.getX(), trashCap.getY(), null);
        g.drawImage(Data.trashCardboardImage, trashCardboard.getX(), trashCardboard.getY(), null);
        g.drawImage(Data.trashMilkImage, trashMilk.getX(), trashMilk.getY(), null);
        g.drawImage(Data.trashSmokeImage, trashSmoke.getX(), trashSmoke.getY(), null);
        g.drawImage(Data.trashDiaperImage, trashDiaper.getX(), trashDiaper.getY(), null);
        g.drawImage(Data.trashCanImage, trashCan.getX(), trashCan.getY(), null);
        g.drawImage(Data.trashJarImage, trashJar.getX(), trashJar.getY(), null);

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 15; j++) {
                g.drawImage(Data.wallImage, wall[i][j].getX(), wall[i][j].getY(), null);
            }
        }
        g.drawImage(Data.characterImage, character.getX(), character.getY(), null);


        if (Data.pause) {
            g.setColor(new Color(50, 30, 0));
            g.fillRect(300, 300, 680, 424);
            g.setColor(Color.RED);
            g.setFont(menuFont);
            g.drawString("GRA WSTRZYMANA", 470, 520);
        } else if (Data.menu) {
            g.setColor(new Color(50, 30, 0));
            g.fillRect(300, 300, 680, 424);
            g.setColor(Color.red);
            g.setFont(menuFont);
            g.drawString("NASTEPNY POZIOM", 470, 420);
            g.drawString("NOWA GRA", 470, 520);
            g.drawString("KONIEC GRY", 470, 620);
        }
        if (Data.endGamePoints == 6) {
            DecimalFormat df = new DecimalFormat("##.##");
            long thisTime = System.currentTimeMillis();
            Data.time = ((thisTime - Data.startTime) - Data.timePaused) / 1000.0;
            g.setColor(new Color(50, 30, 0));
            g.fillRect(300, 300, 680, 424);
            g.setColor(Color.red);
            g.setFont(menuFont);
            g.drawString("WYGRANA !!! czas: " + df.format(Data.time) + "s", 400, 350);

            if(Data.level==1) {
                g.setFont(alertFont);
                g.setColor(Color.white);
                g.drawString(trashNewspaper.goodNews(), 400, 380);
                g.drawString(trashCardboard.goodNews(), 400, 410);
                g.drawString(trashCan.goodNews(), 400, 440);
                g.drawString(trashBanana.goodNews(), 400, 470);
                g.drawString(trashGlassBottle.goodNews(), 400, 500);
                g.drawString(trashJar.goodNews(), 400, 530);
                g.setColor(Color.red);
                g.setFont(menuFont);
            }else {
                g.setFont(alertFont);
                g.setColor(Color.white);
                g.drawString(trashApple.goodNews(), 400, 380);
                g.drawString(trashSmoke.goodNews(), 400, 410);
                g.drawString(trashDiaper.goodNews(), 400, 440);
                g.drawString(trashEgg.goodNews(), 400, 470);
                g.drawString(trashMilk.goodNews(), 400, 500);
                g.drawString(trashCap.goodNews(), 400, 530);
                g.setColor(Color.red);
                g.setFont(menuFont);
            }

            g.drawString("WYNIK: " + Data.points, 400, 600);
            g.drawString("NASTEPNY POZIOM", 400, 650);
            g.drawString("GRAJ OD NOWA", 400, 700);
        }
    }

    public void restartGame() {
        Data.reset();

        trashNewspaper.putXY(0, 0);
        trashCardboard.putXY(0, 0);
        trashCan.putXY(0, 0);
        trashBanana.putXY(0, 0);
        trashGlassBottle.putXY(0, 0);
        trashJar.putXY(0, 0);
        trashApple.putXY(0, 0);
        trashSmoke.putXY(0, 0);
        trashDiaper.putXY(0, 0);
        trashEgg.putXY(0, 0);
        trashMilk.putXY(0, 0);
        trashCap.putXY(0, 0);

        if (Data.level == 1) {
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 15; j++) {
                    wall[i][j].putXY(0, 0);
                    map.toEmpty(i * 80, j * 64);
                    if (wall[0][0].table2[i][j]) {
                        wall[i][j].putXY(i * 80, j * 64);
                    }
                }
            }
            dumbster[0].putXY(80, 64);
            dumbster[1].putXY(14 * 80, 13 * 64);
            dumbster[2].putXY(80, 13 * 64);
            dumbster[3].putXY(14 * 80, 64);
            dumbster[4].putXY(5 * 80, 7 * 64);
            trashNewspaper.randomAppear();
            trashCardboard.randomAppear();
            trashCan.randomAppear();
            trashBanana.randomAppear();
            trashGlassBottle.randomAppear();
            trashJar.randomAppear();
        } else if (Data.level == 2) {

            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 15; j++) {
                    wall[i][j].putXY(0, 0);
                    map.toEmpty(i * 80, j * 64);
                    if (wall[0][0].table1[i][j]) {
                        wall[i][j].putXY(i * 80, j * 64);
                    }
                }
            }
            dumbster[0].putXY(2 * 80, 7 * 64);
            dumbster[1].putXY(12 * 80, 3 * 64);
            dumbster[2].putXY(13 * 80, 7 * 64);
            dumbster[3].putXY(4 * 80, 13 * 64);
            dumbster[4].putXY(8 * 80, 7 * 64);
            trashApple.randomAppear();
            trashSmoke.randomAppear();
            trashDiaper.randomAppear();
            trashEgg.randomAppear();
            trashMilk.randomAppear();
            trashCap.randomAppear();
        }
        for (int i = 0; i < 16; i++) {
            map.toEmptyEquipment(i * 80);
        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                map.toEmptyEquipment(i * 80);
                map.toEmpty(0, 0);
            }
        }
        character.putXY(5 * 80, 6 * 64);
        Data.startTime = System.currentTimeMillis();
    }
}