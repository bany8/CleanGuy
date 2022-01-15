package CleanPackage;

import javax.swing.*;
import java.awt.*;

public class Data {

    /**
     * Zmienna pomocnicza określająca początkowy czas gry
     */
    public static long startTime;
    /**  Liczba poziomów gry   */
    public final static long NO_LEVELS=2;
    /**  Zmienna stanu określającam czy jest przerwa w grze   */
    public static boolean pause=false;
    /**  Zmienna stanu określającam czy jest przerwa w grze   */
    public static boolean menu=false;
    /** Zmienna stanu określająca czy wybrano menu*/
    public static boolean levelPause=false;
    /** Zmienna pomocnicza określająca czas ukończenia aktualnego poziomu */
    public static double levelTime;
    /** Zmienna pomocnicza określająca status ukończenia gry */
    public static int endGame=0;
    /**
     * Obrazy
     */
    public static Image bgImage;
    public static Image characterImage;
    public static Image wallImage;
    public static Image trashBananaImage;
    public static Image trashGlassBottleImage;
    public static Image greenDumbsterImage;
    public static Image blueDumbsterImage;
    public static Image yellowDumbsterImage;
    public static Image blackDumbsterImage;
    public static Image brownDumbsterImage;
    public static Image pauseImage;
    public static Image menuImage;

    public static void loadInitialImages() {
        bgImage = loadImage("img/tlo.png");
        characterImage = loadImage("img/ludzik.png");
        wallImage = loadImage("img/siano.png");
        trashBananaImage = loadImage("img/banan.png");
        trashGlassBottleImage = loadImage("img/butelka_szklo.png");
        brownDumbsterImage = loadImage("img/kosz_brazowy.png");
        blackDumbsterImage = loadImage("img/kosz_czarny.png");
        yellowDumbsterImage = loadImage("img/kosz_zolty.png");
        blueDumbsterImage = loadImage("img/kosz_niebieski.png");
        greenDumbsterImage = loadImage("img/kosz_zielony.png");
        pauseImage = loadImage("img/pauza.png");
        menuImage = loadImage("img/menu.png");
    }//koniec loadInitialImages()

    /**
     * Metoda pobierania obiektu klasy Image na podstawie ścieżki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();
}
