package CleanPackage;

/**
 * Klasa dla śmietnika
 *
 * @author Bartosz Nysztal
 */
public class Dumbster {
    /**
     * Współrzędna x obiektu
     */
    public int x;
    /**
     * Współrzędna y obiektu
     */
    public int y;

    /**
     * Wyliczenie kolorów
     */
    public String color;

    /**
     * Konstruktor klasy śmietnika
     *
     * @param x pozycja oś x
     * @param y pozycja oś y
     */
    public Dumbster(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Metoda pobrania współrzędnej x śmietnika
     */
    public int getX() {
        return this.x;
    }

    /**
     * Metoda pobrania współrzędnej x śmietnika
     */
    public int getY() {
        return this.y;
    }
}
