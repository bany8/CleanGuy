package CleanPackage;

import javax.swing.*;
import java.awt.*;

public class Data {

    /** Zmienna pomocnicza określająca początkowy czas gry */
    public static long startTime;
    /**  Dopuszczalny czas gry   */
    public static long GAME_TIME=Long.MAX_VALUE;

    /**  Obrazy   */
    public static Image bgImage;
    public static Image characterImage;
    public static Image wallImage;

    public static void loadInitialImages() {
        bgImage = loadImage("img/tlo.png");
        characterImage = loadImage("img/ludzik.png");
        wallImage = loadImage("img/siano.png");
    }//koniec loadInitialImages()

     /**
     * Metoda pobierania obiektu klasy Image na podstawie ścieżki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();
}
