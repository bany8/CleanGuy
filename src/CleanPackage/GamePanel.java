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
    /**
     * Wysokość paska menu
     */
    public int barHeight;
    /**
     * Obiekt pierwszego planu
     */
    private Character character;
    private Wall wall;
    private Dumbster[] dumbster;
    private TrashBanana trashBanana;

    /**
     * Konstruktor klasy pola graficznego gry.
     * Ustawienia początkowe oraz ładowanie zasobów
     * Ponadto dodanie obsługi zdarzeń w polu graficznym gry
     *
     * @param width  Szerokość pola graficznego gry
     * @param height Wysokość pola graficznego gry
     */
    public GamePanel(int width, int height) {
        this.sWidth = width;
        this.sHeight = height;

        character = new Character(5*80, 5*64);
        trashBanana = new TrashBanana(5*80, 15*64);
        dumbster = new Dumbster[5];
        dumbster[0] = new Dumbster(1*80, 1*64, "green");
        dumbster[1] = new Dumbster(14*80, 1*64, "black");
        dumbster[2] = new Dumbster(5*80, 7*64, "blue");
        dumbster[3] = new Dumbster(1*80, 13*64, "yellow");
        dumbster[4] = new Dumbster(14*80, 13*64, "brown");
        wall = new Wall(15*80,14*64);

        /* Dodaj obsługę zdarzeń - wciśnięcie strzałki*/
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                System.out.print(ke.getKeyCode());
                if (ke.getKeyCode() == 39) {
                    character.moveRight();
                    System.out.print(ke.getKeyCode());
                } else if (ke.getKeyCode() == 37) {
                    character.moveLeft();
                    System.out.print(ke.getKeyCode());
                } else if (ke.getKeyCode() == 38) {
                    character.moveUp();
                    System.out.print(ke.getKeyCode());
                } else if (ke.getKeyCode() == 40) {
                    character.moveDown();
                    System.out.print(ke.getKeyCode());
                }
                repaint();
            }
        });

        /* Dodaj obsługę zdarzeń - wciśnięcie przycisku myszki*/
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //Czy wybrano opcję Menu w pasku dolnym
                System.out.print(me.getX());
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
        g.drawImage(Data.characterImage, character.getX(), character.getY(), null);
        for (int i = 0; i < 5; i++) {
            if (dumbster[i].color == "black"){
                g.drawImage(Data.blackDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            } else if (dumbster[i].color == "green"){
                g.drawImage(Data.greenDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            }else if (dumbster[i].color == "yellow"){
                g.drawImage(Data.yellowDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            }else if (dumbster[i].color == "blue"){
                g.drawImage(Data.blueDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            }else if (dumbster[i].color == "brown"){
                g.drawImage(Data.brownDumbsterImage, dumbster[i].getX(), dumbster[i].getY(), null);
            }
        }

                g.drawImage(Data.wallImage, wall.getX(), wall.getY(), null);
    }
}