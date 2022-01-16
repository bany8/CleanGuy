package CleanPackage.Trash;

import CleanPackage.Data;
import CleanPackage.GamePanel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Klasa dla odpadu - szklana butelka
 *
 * @author Bartosz Nysztal
 */
public class Trash {
    /**
     * Współrzędna x obiektu
     */
    public int x;
    /**
     * Współrzędna y obiektu
     */
    public int y;
    public String name;
    public boolean goodOrBad;


    /**
     * Konstruktor klasy odpadu - szklana butelka
     */
    public Trash(String name) {
        this.name=name;
    }

    /**
     * Metoda pobrania współrzędnej x odpadu - szklana butelka
     */
    public int getX() {
        return this.x;
    }

    /**
     * Metoda pobrania współrzędnej y odpadu - szklana butelka
     */
    public int getY() {
        return this.y;
    }

    public void putXY(int x, int y) {
        this.x=x;
        this.y=y;
    }




    public void randomAppear() {
        int a = getRandomNumber(1, 15);
        int b = getRandomNumber(1, 14);
        int aa = a;
        int bb = b;
        while (true) {
            while (GamePanel.map.isTaken(aa * 80, bb * 64)) {
                a = getRandomNumber(1, 14);
                b = getRandomNumber(1, 13);
                aa = a;
                bb = b;
            } if (!GamePanel.map.isTaken(aa * 80, bb * 64)){
                this.x = aa*80;
                this.y = bb*64;
                break;
            }
        }

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    /**
     * Metoda zmiany współrzędnych x i y odpadu - szklana butelka
     */
    public void moveToEquipment(int x, int y) {
        for (int i = 0; i < 7; i++) {
            if (GamePanel.map.isTakenEquipment(x + 80 * i)) {
            } else {
                this.x = x + i * 80;
                this.y = y;
                GamePanel.map.toTakeEquipment(x + i * 80);
                break;
            }
        }
    }

    public void throwAway(int x, int y) {
        for (int i = 0; i < 7; i++) {
            if (GamePanel.map.isTakenEquipment(x + 80 * i)) {
            } else {
                this.x = x + i * 80;
                this.y = y;
                GamePanel.map.toTakeEquipment(x + i * 80);
                playSound(new File("sound/smieci.wav"));
                break;
            }
        }
    }



    /**
     * Funkcja odtwarzania dźwięku z pliku
     *
     * @param f - obiekt klasy File reprezentujący ścieżkę do pliku MP3
     */
    public static synchronized void playSound(final File f) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }//playSound()
}