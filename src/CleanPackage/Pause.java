package CleanPackage;

/**
 * Klasa dla pauzy
 *
 * @author Bartosz Nysztal
 */
public class Pause {
    /**
     * Współrzędna x obiektu
     */
    public int x;
    /**
     * Współrzędna y obiektu
     */
    public int y;

    /**
     * Konstruktor klasy pauzy
     *
     * @param x pozycja oś x
     * @param y pozycja oś y
     */
    public Pause(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metoda pobrania współrzędnej x ściany
     */
    public int getX() {
        return this.x;
    }

    /**
     * Metoda pobrania współrzędnej y ściany
     */
    public int getY() {
        return this.y;
    }

    public void pauseGame(){
        Data.pause = !Data.pause;
    }
}