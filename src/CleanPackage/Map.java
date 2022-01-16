package CleanPackage;

/**
 * Klasa dla mapy
 *
 * @author Bartosz Nysztal
 */
public class Map {

    /**
     * Tablica kratek
     */
    public boolean[][] boxWall;
    public boolean[] boxEquipment;

    public Map() {
        boxEquipment = new boolean[16];
        boxWall = new boolean[16][16];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                this.boxEquipment[i] = false;
                this.boxWall[i][j] = false;
            }
        }
    }

    public boolean isTaken(int x, int y) {
        return this.boxWall[x / 80][y / 64];
    }

    public void toEmpty(int x, int y) {
        this.boxWall[x / 80][y / 64] = false;
    }

    public void toTake(int x, int y) {
        this.boxWall[x / 80][y / 64] = true;
    }

    public boolean isTakenEquipment(int x) {
        return this.boxEquipment[x / 80];
    }

    public void toEmptyEquipment(int x) {
        this.boxEquipment[x / 80] = false;
    }

    public void toTakeEquipment(int x) {
        this.boxEquipment[x / 80] = true;
    }

    public void unTakeEquipment(int x) {
        this.boxEquipment[x / 80] = false;
    }
}