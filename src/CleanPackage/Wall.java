package CleanPackage;

/**
 * Klasa dla ściany
 * @author Bartosz Nysztal
 */
public class Wall {
    /** Początkowa współrzędna x obiektu */
    public int x;
    /** Początkowa współrzędna y obiektu */
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
     * Metoda pobrania współrzędnej x ściany
     */
    public int getX(){
        return this.x;
    }

    /**
     * Metoda pobrania współrzędnej y ściany
     */
    public int getY(){
        return this.y;
    }
}
