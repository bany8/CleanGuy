package CleanPackage.Trash;

import CleanPackage.Data;
import CleanPackage.Trash.Trash;

/**
 * Klasa dla odpadu - szklana butelka
 *
 * @author Bartosz Nysztal
 */
public class TrashGlassBottle extends Trash {

    /**
     * Konstruktor klasy odpadu - szklana butelka
     */
    public TrashGlassBottle(String name) {
        super(name);
    }
    public String goodNews(){
        if (this.goodOrBad){
            return "DOBRZE !!! "+ this.name + " wyrzucamy do zielonego!";
        }else {
            return "ZLE !!! "+ this.name + " wyrzucamy do zielonego!";
        }
    }
}