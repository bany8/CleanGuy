package CleanPackage;

import java.awt.Toolkit;

/**
 * Prosta gra (bez optymalizacji)
 *
 * @author Bartosz Nysztal
 */
public class CleanGuy {

    /**
     * Metoda uruchamia grę. Najpierw pobierane są parametry ekranu
     * i po ustaleniu rozmiaru gry (1024/768) obliczany jest punkt (x,y)
     * górnego, lewego narożnika panelu gry tak, aby pole gry było wyśrodkowane
     * na ekranie.
     */

    public static void main(String[] args) {

        int gameWidth = 1280;
        int gameHeight = 1024;

        //pobierz rozmiar ekranu
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        //oblicz współrzędne narożnika tak, aby pole gry było wyśrodkowane
        int xCenter = (screenWidth - gameWidth) / 2;
        int yCenter = (screenHeight - gameHeight) / 2;

        //utwórz obiekt klasy GameWindow - konstruktor wywołuje dalszą akcję
        GameWindow gw = new GameWindow(gameWidth, gameHeight, xCenter, yCenter);
    }//koniec main()

}//koniec class CleanGuy()
