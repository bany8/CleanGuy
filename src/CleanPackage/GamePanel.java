package CleanPackage;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    /** Szerokość pola graficznego gry*/
    public int sWidth;
    /** Wysokość pola graficznego gry*/
    public int sHeight;
    /** Wysokość paska menu*/
    public int barHeight;
    /** Obiekt pierwszego planu*/
    private Character character;
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
        barHeight = 50;

        character = new Character(500,500);
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
        // Narysuj tło
        g.drawImage(Data.bgImage, 0, 0, null);
        g.drawImage(Data.characterImage, character.getX(), character.getY(), null);
    }
}