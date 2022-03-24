package animals;
import diet.*;
import mobility.*;
public class Elephant extends Animal{
    private double trunkLength;

    public Elephant(String name) {
        super(name,new Point(50,90));
        this.trunkLength=1;
        this.setweight(500);
        setDiet(new Herbivore());
    }
    public Elephant(String name,Point p,double num) {
        super(name,p);
        this.setweight(500);
        setDiet(new Herbivore());
        if (num>0.5 && num<3)
            this.trunkLength=num;
        else
            this.trunkLength=1;

    }
    public void chew() {

    }

}
