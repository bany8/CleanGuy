package CleanPackage;

public class Character {
    /** Początkowa współrzędna x obiektu */
    public int x;
    /** Współrzędna y obiektu */
    public int y;

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
