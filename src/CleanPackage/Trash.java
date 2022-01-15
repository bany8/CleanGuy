package CleanPackage;

/**
 * Klasa dla odpadu - szklana butelka
 *
 * @author Bartosz Nysztal
 */
public class Trash {
    /**
     * Współrzędna x obiektu
     */
    public int x;
    /**
     * Współrzędna y obiektu
     */
    public int y;

    /**
     * Konstruktor klasy odpadu - szklana butelka
     *
     * @param x pozycja oś x
     * @param y pozycja oś y
     */
    public Trash(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metoda pobrania współrzędnej x odpadu - szklana butelka
     */
    public int getX() {
        return this.x;
    }

    /**
     * Metoda pobrania współrzędnej y odpadu - szklana butelka
     */
    public int getY() {
        return this.y;
    }

    /**
     * Metoda zmian współrzędnej x odpadu - szklana butelka
     */
    public void putX(int x) {
        this.x = x;
    }

    /**
     * Metoda zmiany współrzędnej y odpadu - szklana butelka
     */
    public void putY(int y) {
        this.y = y;
    }

    /**
     * Metoda zmiany współrzędnych x i y odpadu - szklana butelka
     */
    public void move(int x, int y) {
        for (int i = 0; i<7;i++){
            if (GamePanel.map.isTakenEquipment(x +80*i)){
            } else {
                this.x = x + i * 80;
                this.y = y;
                GamePanel.map.toTakeEquipment(x+i*80);
                break;
            }
        }
    }
}