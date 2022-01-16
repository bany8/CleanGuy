package CleanPackage.Trash;

import CleanPackage.Data;
import CleanPackage.Trash.Trash;

/**
 * Klasa dla odpadu - banan
 *
 * @author Bartosz Nysztal
 */
public class TrashEgg extends Trash {
    /**
     * Konstruktor klasy odpadu - banan
     */
    public TrashEgg(String name) {
        super(name);
    }
    public String goodNews(){
        if (this.goodOrBad){
            return "DOBRZE !!! "+ this.name + " wyrzucamy do brazowego!";
        }else {
            return "ZLE !!! "+ this.name + " wyrzucamy do brazowego!";
        }
    }
}