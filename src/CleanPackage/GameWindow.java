package CleanPackage;

import javax.swing.*;
import java.awt.*;

/**
 * Okno główne gry
 * @author Bartosz Nysztal
 */
public class GameWindow extends JFrame {

     /**
     * Główny konstruktor klasy - ustawienie parametrów i rozpoczęcia akcji
     * @param width szerokość okna
     * @param height wysokość okna
     * @param x pozycja x lewego górnego narożnika okna
     * @param y pozycja y lewego górnego narożnika okna
     */
    public GameWindow(int width, int height, int x, int y){
        super(); //wywołaj konstruktor klasy nadrzędnej - utwórz okno
        setSize(width, height); //ustaw wymiary okna
        setLocation(x,y);  //ustaw pozycję okna
        setResizable(false); //zablokuj możliwość zmian rozmiaru okna
        setUndecorated(true); //ukryj ramkę okna i przyciski kontrolne
        initGUI(width,height); //wywołaj metodę budowy interfejsu
        setVisible(true); //pokaż okno
        //animationLoop(); //uruchom pętlę animacji gry

    }//koniec GameWindow()

    /**
     * Utwórz interfejs graficzny użytkownika
     * @param width szerokość okna
     * @param height wysokość okna
     */
    private void initGUI(int width, int height){
        setLayout(new GridLayout(1,1)); //ustaw rozkład
        //ustaw zasoby i parametry początkowe
        Data.loadInitialImages();
        add(new GamePanel(width,height)); //dodaj panel gry zawierający grafikę i akcję
    }//koniec initGUI()

}
