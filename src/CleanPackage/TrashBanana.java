package CleanPackage;

/**
 * Klasa dla odpadu - banan
 *
 * @author Bartosz Nysztal
 */
public class TrashBanana {
    /**
     * Współrzędna x obiektu
     */
    public int x;
    /**
     * Współrzędna y obiektu
     */
    public int y;

    /**
     * Konstruktor klasy odpadu - banan
     *
     * @param x pozycja oś x
     * @param y pozycja oś y
     */
    public TrashBanana(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metoda pobrania współrzędnej x odpadu - banan
     */
    public int getX() {
        return this.x;
    }

    /**
     * Metoda pobrania współrzędnej y odpadu - banan
     */
    public int getY() {
        return this.y;
    }

    /**
     * Metoda zmian współrzędnej x odpadu - banan
     */
    public void putX(int x) {
        this.x = x;
    }

    /**
     * Metoda zmiany współrzędnej y odpadu - banan
     */
    public void putY(int y) {
        this.y = y;
    }
}