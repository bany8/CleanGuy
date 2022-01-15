package CleanPackage;

import javax.swing.*;
import java.awt.*;

/**
 * Okno główne gry
 *
 * @author Bartosz Nysztal
 */
public class GameWindow extends JFrame {

    /**
     * Główny konstruktor klasy - ustawienie parametrów i rozpoczęcia akcji
     *
     * @param width  szerokość okna
     * @param height wysokość okna
     * @param x      pozycja x lewego górnego narożnika okna
     * @param y      pozycja y lewego górnego narożnika okna
     */
    public GameWindow(int width, int height, int x, int y) {
        super(); //wywołaj konstruktor klasy nadrzędnej - utwórz okno
        setSize(width, height); //ustaw wymiary okna
        setLocation(x, y);  //ustaw pozycję okna
        setResizable(false); //zablokuj możliwość zmian rozmiaru okna
        setUndecorated(true); //ukryj ramkę okna i przyciski kontrolne
        initGUI(width, height); //wywołaj metodę budowy interfejsu
        setVisible(true); //pokaż okno
        animationLoop(); //uruchom pętlę animacji gry

    }//koniec GameWindow()

    /**
     * Utwórz interfejs graficzny użytkownika
     *
     * @param width  szerokość okna
     * @param height wysokość okna
     */
    private void initGUI(int width, int height) {
        setLayout(new GridLayout(1, 1)); //ustaw rozkład
        //ustaw zasoby i parametry początkowe
        Data.loadInitialImages();
        add(new GamePanel(width, height)); //dodaj panel gry zawierający grafikę i akcję
    }//koniec initGUI()

    /**
     * Główna pętla gry - takt animacji (w procesie dalszej edukacji
     * można używać wątków czy klasy Timer)
     */
    private void animationLoop() {
        //pobierz liczbę milisekund od daty referencyjnej (w ms)
        Data.startTime = System.currentTimeMillis();
        long currTime = Data.startTime;

        while (currTime - Data.startTime <= Data.endGame) {
            long elapsedTime = System.currentTimeMillis() - currTime;
            //licz czas gry - może się przydać w ograniczeniach czasowych
            //w tej demonstracji nie wykorzystane
            currTime += elapsedTime;

            //odrysuj kolejny ekran gry (nowe pozycje obiektów - symulacja ruchu)
            repaint();

            // przerwa w czasie
            try {
                Thread.sleep(80);
            } catch (InterruptedException ex) {
                System.out.println("Wyjątek: " + ex);
            }
        }//koniec while
    }//koniec animationLoop()
}
