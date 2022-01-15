package CleanPackage;

/**
 * Klasa dla ściany
 *
 * @author Bartosz Nysztal
 */
public class Wall {
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
     * Konstruktor klasy ściany
     *
     * @param x pozycja oś x
     * @param y pozycja oś y
     */
    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
        GamePanel.map.toTake(this.x, this.y);
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

    /**
     * Metoda podania współrzędnych xy ściany
     */
    public void putXY(int x ,int y) {
        this.x=x;
        this.y=y;
        GamePanel.map.toTake(x,y);
    }


}
