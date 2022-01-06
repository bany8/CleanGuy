package CleanPackage;

/**
 * Klasa dla ściany
 * @author Bartosz Nysztal
 */
public class Wall {
    /** Początkowa współrzędna x obiektu */
    public int x;
    /** Współrzędna y obiektu */
    public int y;

    /**
     * Konstruktor klasy ściany
     *
     * @param x pozycja oś x
     * @param y pozycja oś y
     */
    public Wall(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * Metoda pobrania współrzędnej x postaci
     */
    public int getX(){
        return this.x;
    }

    /**
     * Metoda pobrania współrzędnej y postaci
     */
    public int getY(){
        return this.y;
    }
}
