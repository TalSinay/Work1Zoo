package animals;
import mobility.*;
import diet.*;

public class Giraffe extends Animal{
    private double neckLength;

    public Giraffe(String name) {
        super(name,new Point(50,0));
        this.neckLength=1.5;
        setDiet(new Herbivore());
    }
    public Giraffe(String name,Point p,double len) {
        super(name,p);
        setDiet(new Omnivore());
        if (len>1 && len<2.5)
            this.neckLength=len;
        else
            this.neckLength=1.5;
    }
    public void chew() {

    }
    public boolean setNeckLength(double len){return true;}

}

