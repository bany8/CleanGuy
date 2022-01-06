package CleanPackage;

/**
 * Klasa dla postaci
 * @author Bartosz Nysztal
 */
public class Character {
    /** Współrzędna x obiektu */
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

    /**
     * Metoda przessunięcia postaci w prawo
     */
    public void moveRight(){
        this.x += 79;
        System.out.println("ruch");
    }

    /**
     * Metoda przessunięcia postaci w lewo
     */
    public void moveLeft(){
        this.x -= 79;
    }

    /**
     * Metoda przessunięcia postaci w górę
     */
    public void moveUp(){
        this.y -= 79;
    }

    /**
     * Metoda przessunięcia postaci w dół
     */
    public void moveDown(){
        this.y += 79;
    }
}
