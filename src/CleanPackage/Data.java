package CleanPackage;

import javax.swing.*;
import java.awt.*;

public class Data {

    /**
     * Zmienna pomocnicza określająca początkowy czas gry
     */
    public static long startTime;
    public static long stopTime;
    public static long pauseTime;
    public static long timePaused;
    /**
     * Zmienna stanu określającam czy jest przerwa w grze
     */
    public static boolean pause = false;
    /**
     * Zmienna stanu określającam czy jest przerwa w grze
     */
    public static boolean menu = false;
    /**
     * Zmienna pomocnicza określająca status ukończenia gry
     */
    public static int endGamePoints = 0;
    /**
     * Czas gry na danym poziomie
     */
    public static int points = 0;
    /**
     * Czas gry na danym poziomie
     */
    public static double time;
    public static int level = 1;

    public static Image bgImage;
    public static Image characterImage;
    public static Image wallImage;
    public static Image trashBananaImage;
    public static Image trashGlassBottleImage;
    public static Image trashNewspaperImage;
    public static Image trashAppleImage;
    public static Image trashEggImage;
    public static Image trashCapImage;
    public static Image trashCardboardImage;
    public static Image trashMilkImage;
    public static Image trashSmokeImage;
    public static Image trashDiaperImage;
    public static Image trashCanImage;
    public static Image trashJarImage;
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
        trashNewspaperImage = loadImage("img/gazeta.png");
        trashAppleImage = loadImage("img/jablko.png");
        trashEggImage = loadImage("img/jajko.png");
        trashCapImage = loadImage("img/kapsel.png");
        trashCardboardImage = loadImage("img/karton.png");
        trashMilkImage = loadImage("img/Mleko.png");
        trashSmokeImage = loadImage("img/pet.png");
        trashDiaperImage = loadImage("img/pielucha.png");
        trashCanImage = loadImage("img/puszka.png");
        trashJarImage = loadImage("img/sloik.png");

        brownDumbsterImage = loadImage("img/kosz_brazowy.png");
        blackDumbsterImage = loadImage("img/kosz_czarny.png");
        yellowDumbsterImage = loadImage("img/kosz_zolty.png");
        blueDumbsterImage = loadImage("img/kosz_niebieski.png");
        greenDumbsterImage = loadImage("img/kosz_zielony.png");
        pauseImage = loadImage("img/pauza.png");
        menuImage = loadImage("img/menu.png");
    }//koniec loadInitialImages()

    public static void reset() {
        endGamePoints = 0;
        points =0;
        time = 0.0;
        startTime=System.currentTimeMillis();
        stopTime=0;
        pauseTime=0;
        endGamePoints = 0;
    }//reset()


    /**
     * Metoda pobierania obiektu klasy Image na podstawie ścieżki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec loadImage();
}
