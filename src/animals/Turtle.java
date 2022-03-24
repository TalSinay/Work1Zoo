package animals;
import diet.*;
import mobility.*;

public class Turtle extends Animal{
    private int Age;

    public Turtle (String name) {
        super(name,new Point(80,0));
        setDiet(new Herbivore());
        this.setweight(1);

    }
    public Turtle(String name,Point p) {
        super(name,p);
        setDiet(new Herbivore());
        this.setweight(1);
    }
    public void chew() {

    }
}
