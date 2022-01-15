package CleanPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


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
    /**
     * Obiekt reprezentujący status gry
     */
    public GameStatus gameStatus;
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
        gameStatus = new GameStatus();
        menuFont = new Font("Dialog", Font.BOLD, 36);
        alertFont = new Font("Dialog", Font.BOLD, 92);
        setFocusable(true);
        requestFocusInWindow();
        this.sWidth = width;
        this.sHeight = height;

        map = new Map();
        pause = new Pause(14 * 80, 15 * 64);
        menu = new Menu(15 * 80, 15 * 64);
        trashBanana = new TrashBanana();
        trashGlassBottle = new TrashGlassBottle();
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
                if (Data.endGamePoints == 2 && me.getX() > 470 && me.getX() < 720 && me.getY() > 665 && me.getY() < 700) {
                    Data.level = 1;
                    restartGame();
                }
                if (Data.endGamePoints == 2 && me.getX() > 470 && me.getX() < 720 && me.getY() > 565 && me.getY() < 600) {
                    if (Data.level == 1) {
                        Data.level = 2;
                    } else if (Data.level == 2) {
                        Data.level = 1;
                    }
                    restartGame();
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
                            && character.getX() > dumbster[i].getX() - 81 && character.getX() < dumbster[i].getX() + 81
                            && (5 * 80 == trashGlassBottle.getX() || 6 * 80 == trashGlassBottle.getX() || 7 * 80 == trashGlassBottle.getX()
                            || 8 * 80 == trashGlassBottle.getX() || 9 * 80 == trashGlassBottle.getX() || 10 * 80 == trashGlassBottle.getX()
                            || 11 * 80 == trashGlassBottle.getX()) && trashGlassBottle.getY() == 15 * 64) {
                        if (dumbster[i].color == "yellow") {
                            trashGlassBottle.moveToEquipment(0, 0);
                            Data.endGamePoints++;
                        } else {
                            trashGlassBottle.throwAway(0, 0);
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
                        if (dumbster[i].color == "brown") {
                            trashBanana.moveToEquipment(0, 0);
                            Data.endGamePoints++;
                        } else {
                            trashBanana.throwAway(0, 0);
                            Data.endGamePoints++;
                        }
                    }
                    if (me.getX() < pause.getX() + 80 && me.getX() > pause.getX()
                            && me.getY() < pause.getY() + 64 && me.getY() > pause.getY()) {
                        pause.pauseGame();

                    }
                    if (me.getX() < menu.getX() + 80 && me.getX() > menu.getX()
                            && me.getY() < menu.getY() + 64 && me.getY() > menu.getY()) {
                        menu.gameMenu();

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
        g.drawImage(Data.trashBananaImage, trashBanana.getX(), trashBanana.getY(), null);
        g.drawImage(Data.trashGlassBottleImage, trashGlassBottle.getX(), trashGlassBottle.getY(), null);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 15; j++) {
                g.drawImage(Data.wallImage, wall[i][j].getX(), wall[i][j].getY(), null);
            }
        }
        g.drawImage(Data.characterImage, character.getX(), character.getY(), null);


        if (Data.pause) {
            g.setColor(new Color(50, 30, 0));
            g.fillRect(300, 300, 680, 424);
            g.setColor(Color.white);
            g.setFont(menuFont);
            g.drawString("GRA ZATRZYMANA", 470, 520);
        } else if (Data.menu) {
            g.setColor(new Color(50, 30, 0));
            g.fillRect(300, 300, 680, 424);
            g.setColor(Color.white);
            g.setFont(menuFont);
            g.drawString("NASTEPNY POZIOM", 470, 420);
            g.drawString("NOWA GRA", 470, 520);
            g.drawString("KONIEC GRY", 470, 620);
        }
        if (Data.endGamePoints == 2) {
            DecimalFormat df = new DecimalFormat("#.##");
            g.setColor(new Color(50, 30, 0));
            g.fillRect(300, 300, 680, 424);
            g.setColor(Color.white);
            g.setFont(menuFont);
            g.drawString("WYGRANA !!! czas:" + df.format(Data.time) + "s", 400, 400);
            g.drawString("NASTEPNY POZIOM", 400, 600);
            g.drawString("GRAJ OD NOWA", 400, 700);
        }
    }

    public void restartGame() {
        Data.endGamePoints = 0;
        Data.resetPoints();
        if (Data.level == 1) {
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 15; j++) {
                    wall[i][j].putXY(0, 0);
                    map.toEmpty(i*80,j*64);
                    if (wall[0][0].table1[i][j]) {
                        wall[i][j].putXY(i * 80, j * 64);
                    }
                }
            }
            dumbster[0].putXY(1 * 80, 1 * 64);
            dumbster[1].putXY(14 * 80, 13 * 64);
            dumbster[2].putXY(1 * 80, 13 * 64);
            dumbster[3].putXY(14 * 80, 1 * 64);
            dumbster[4].putXY(5 * 80, 7 * 64);
            trashBanana.randomAppear();
            trashGlassBottle.randomAppear();
        } else if (Data.level == 2) {

            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 15; j++) {
                    wall[i][j].putXY(0, 0);
                    map.toEmpty(i * 80, j * 64);
                    if (wall[0][0].table2[i][j]) {
                        wall[i][j].putXY(i * 80, j * 64);
                    }
                }
            }
            dumbster[0].putXY(2 * 80, 7 * 64);
            dumbster[1].putXY(12 * 80, 3 * 64);
            dumbster[2].putXY(13 * 80, 7 * 64);
            dumbster[3].putXY(5 * 80, 11 * 64);
            dumbster[4].putXY(8 * 80, 7 * 64);
            trashBanana.randomAppear();
            trashGlassBottle.randomAppear();
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