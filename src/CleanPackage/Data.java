package CleanPackage;

import javax.swing.*;
import java.awt.*;

public class Data {

    /**
     * Zmienna pomocnicza określająca początkowy czas gry
     */
    public static long startTime;
    /**
     * Dopuszczalny czas gry
     */
    public static long GAME_TIME = Long.MAX_VALUE;

    /**
     * Obrazy
     */
    public static Image bgImage;
    public static Image characterImage;
    public static Image wallImage;
    public static Image trashBananaImage;
    public static Image greenDumbsterImage;
    public static Image blueDumbsterImage;
    public static Image yellowDumbsterImage;
    public static Image blackDumbsterImage;
    public static Image brownDumbsterImage;

    public static void loadInitialImages() {
        bgImage = loadImage("img/tlo.png");
        characterImage = loadImage("img/ludzik.png");
        wallImage = loadImage("img/siano.png");
        trashBananaImage = loadImage("img/banan.png");
        brownDumbsterImage = loadImage("img/kosz_brazowy.png");
        blackDumbsterImage = loadImage("img/kosz_czarny.png");
        yellowDumbsterImage = loadImage("img/kosz_zolty.png");
        blueDumbsterImage = loadImage("img/kosz_niebieski.png");
        greenDumbsterImage = loadImage("img/kosz_zielony.png");
    }//koniec loadInitialImages()

    /**
     * Metoda pobierania obiektu klasy Image na podstawie ścieżki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();
}
