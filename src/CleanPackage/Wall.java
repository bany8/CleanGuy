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

    /**
     * Konstruktor klasy ściany
     */
    public Wall() {
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
    public void putXY(int x, int y) {
        this.x = x;
        this.y = y;
        GamePanel.map.toTake(x, y);
    }

    public boolean table1[][] = {
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, false, false, true, false, false, false, false, false, false, false, false, true, false, true, true},
            {true, true, false, true, false, true, true, false, true, false, true, false, false, false, true, true},
            {true, false, false, false, false, true, false, false, true, false, true, true, false, true, true, true},
            {true, false, true, true, true, true, false, true, true, false, false, true, false, false, true, true},
            {true, true, true, false, false, true, false, false, true, false, true, true, true, true, true, true},
            {true, false, true, true, false, true, false, false, false, false, true, false, false, false, true, true},
            {true, false, false, false, false, false, false, true, true, false, true, false, true, false, true, true},
            {true, false, true, false, true, true, false, false, false, false, false, false, true, false, true, true},
            {true, false, true, true, false, true, false, true, true, true, true, true, true, true, true, true},
            {true, false, false, false, false, true, false, false, true, false, false, false, false, false, true, true},
            {true, true, true, true, true, true, false, true, true, true, true, false, true, false, true, true},
            {true, true, false, false, false, false, false, false, false, false, false, false, true, false, true, true},
            {true, true, true, true, false, true, true, false, true, true, true, false, true, false, true, true},
            {true, false, false, false, false, false, true, false, true, false, false, false, true, false, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
    };
    public boolean table2[][] = {
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
            {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true},
            {true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, true},
            {true, false, true, false, false, false, false, false, false, false, false, false, true, false, true, true},
            {true, false, true, false, true, true, true, false, true, true, true, false, true, false, true, true},
            {true, false, true, false, true, false, false, false, false, false, true, false, true, false, true, true},
            {true, false, true, false, true, false, true, true, true, false, true, false, true, false, true, true},
            {true, false, false, false, false, false, true, false, false, false, false, false, false, false, true, true},
            {true, false, false, false, false, false, true, false, true, false, false, false, false, false, true, true},
            {true, false, true, false, true, false, true, true, true, false, true, false, true, false, true, true},
            {true, false, true, false, true, false, false, false, false, false, true, false, true, false, true, true},
            {true, false, true, false, true, true, true, false, true, true, true, false, true, false, true, true},
            {true, false, true, false, false, false, false, false, false, false, false, false, true, false, true, true},
            {true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, true},
            {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true},
            {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
    };
}
