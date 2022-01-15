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

    public Map map;

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

    /**
     * Metoda zmiany współrzędnych x i y odpadu - banan
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