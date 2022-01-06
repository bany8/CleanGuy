package CleanPackage;

import javax.swing.*;
import java.awt.*;

public class Data {

    /**  Obraz tła   */
    public static Image bgImage;

    public static void loadInitialImages() {
        bgImage = loadImage("img/tlo.png");
    }//koniec loadInitialImages()

     /**
     * Metoda pobierania obiektu klasy Image na podstawie ścieżki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();
}