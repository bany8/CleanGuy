package CleanPackage;

/**
 * Klasa dla postaci
 *
 * @author Bartosz Nysztal
 */
public class Character {
    /**
     * Współrzędna x obiektu
     */
    public int x;
    /**
     * Współrzędna y obiektu
     */
    public int y;

    /**
     * Konstruktor klasy postaci
     *
     * @param x pozycja oś x
     * @param y pozycja oś y
     */
    public Character(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metoda pobrania współrzędnej x postaci
     */
    public int getX() {
        return this.x;
    }

    /**
     * Metoda pobrania współrzędnej y postaci
     */
    public int getY() {
        return this.y;
    }

    /**
     * Metoda przessunięcia postaci w prawo
     */
    public void moveRight() {
        if (GamePanel.map.isTaken(x +80,y)){
            this.x=x;
        }
        else {
            this.x += 80;
        }
    }

    /**
     * Metoda przessunięcia postaci w lewo
     */
    public void moveLeft() {
        if (GamePanel.map.isTaken(x -80,y)){
            this.x=x;
        }
        else {
            this.x -= 80;
        }
    }

    /**
     * Metoda przessunięcia postaci w górę
     */
    public void moveUp() {
        if (GamePanel.map.isTaken(x ,y-64)){
            this.y=y;
        }
        else {
            this.y -= 64;
        }
    }

    /**
     * Metoda przessunięcia postaci w dół
     */
    public void moveDown() {
        if (GamePanel.map.isTaken(x ,y+64)){
            this.y=y;
        }
        else {
            this.y += 64;
        }
    }
    public void putXY(int x, int y){
        this.x=x;
        this.y=y;
    }
}
