package CleanPackage;

/**
 * Klasa dla postaci
 * @author Bartosz Nysztal
 */
public class Character {
    /** Początkowa współrzędna x obiektu */
    public int x;
    /** Współrzędna y obiektu */
    public int y;

    /**
     * Konstruktor klasy postaci
     *
     * @param x pozycja oś x
     * @param y pozycja oś y
     */
    public Character(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
