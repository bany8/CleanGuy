package CleanPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


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
     * Wysokość pola graficznego gry
     */
    public int sHeight;
    public Pause pause;
    public Menu menu;

    public KeyAdapter keyAdapter;
    /**
     * Obiekt pierwszego planu
     */
    private Character character;
    private Wall[][] wall;
    private Dumbster[] dumbster;
    private TrashBanana trashBanana;
    private TrashGlassBottle trashGlassBottle;
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
        setFocusable(true);
        requestFocusInWindow();
        this.sWidth = width;
        this.sHeight = height;

        map = new Map();
        pause = new Pause(14 * 80, 15 * 64);
        menu = new Menu(15 * 80, 15 * 64);
        trashBanana = new TrashBanana(4 * 80, 1 * 64);
        trashGlassBottle = new TrashGlassBottle(10 * 80, 9 * 64);
        dumbster = new Dumbster[5];
        dumbster[0] = new Dumbster(1 * 80, 1 * 64, "green");
        dumbster[1] = new Dumbster(14 * 80, 1 * 64, "black");
        dumbster[2] = new Dumbster(5 * 80, 7 * 64, "blue");
        dumbster[3] = new Dumbster(1 * 80, 13 * 64, "yellow");
        dumbster[4] = new Dumbster(14 * 80, 13 * 64, "brown");
        character = new Character(5 * 80, 6 * 64);
        wall = new Wall[16][15];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 15; j++) {
                wall[i][j] = new Wall(0, 0);
            }
        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 15; j++) {
                if (wall[0][0].table[i][j]) {
                    wall[i][j].putXY(i * 80, j * 64);
                }
            }
        }


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
                if (me.getX() < trashGlassBottle.getX() + 80 && me.getX() > trashGlassBottle.getX()
                        && me.getY() < trashGlassBottle.getY() + 64 && me.getY() > trashGlassBottle.getY()
                        && character.getY() > trashGlassBottle.getY() - 65 && character.getY() < trashGlassBottle.getY() + 65
                        && character.getX() > trashGlassBottle.getX() - 81 && character.getX() < trashGlassBottle.getX() + 81) {
                    trashGlassBottle.moveToEquipment(5 * 80, 15 * 64);
                }
                for (int i = 0; i < 5; i++) {
                    if (me.getX() < trashGlassBottle.getX() + 80 && me.getX() > trashGlassBottle.getX()
                            && me.getY() < trashGlassBottle.getY() + 64 && me.getY() > trashGlassBottle.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81) {
                        if (dumbster[i].color == "yellow") {
                            trashGlassBottle.moveToEquipment(0, 0);
                            System.out.print("git");
                            Data.endGame++;
                        } else {
                            trashGlassBottle.throwAway(0, 0);
                            System.out.print("nie git");
                            Data.endGame++;
                        }
                    }
                    if (me.getX() < trashBanana.getX() + 80 && me.getX() > trashBanana.getX()
                            && me.getY() < trashBanana.getY() + 64 && me.getY() > trashBanana.getY()
                            && character.getY() > dumbster[i].getY() - 65 && character.getY() < dumbster[i].getY() + 65
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81) {
                        if (dumbster[i].color == "brown") {
                            trashBanana.moveToEquipment(0, 0);
                        }else {
                            trashBanana.throwAway(0, 0);
                            System.out.print("nie git");
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
            if (dumbster[i].color == "black") {
                g.drawImage(Data.blackDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            } else if (dumbster[i].color == "green") {
                g.drawImage(Data.greenDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            } else if (dumbster[i].color == "yellow") {
                g.drawImage(Data.yellowDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            } else if (dumbster[i].color == "blue") {
                g.drawImage(Data.blueDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            } else if (dumbster[i].color == "brown") {
                g.drawImage(Data.brownDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            }
        }
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 15; j++) {
                g.drawImage(Data.wallImage, wall[i][j].getX(), wall[i][j].getY(), null);
            }
        }
        g.drawImage(Data.characterImage, character.getX(), character.getY(), null);
        //Jeśli już wybrano Menu (czyli pausa) narysuj stosowną wersję paska Menu
        if(Data.pause){

        }
    }
}