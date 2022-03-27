package animals;
import diet.*;
import mobility.*;
/**
 * 'Elephant' class, used to declare all the elephants in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see {Animal}
 * */
public class Elephant extends chew{
    private double trunkLength;

    /**
     * the elephant constructor
     * @param name the elephant name.
     */
    public Elephant(String name) {
        super(name,new Point(50,90));
        this.trunkLength=1;
        this.setWeight(500);
        setDiet(new Herbivore());
    }

    /**
     * the elephant constructor.
     * @param name elephant's name.
     * @param p location (point)
     * @param num the trunk length
     */
    public Elephant(String name,Point p,double num) {
        super(name,p);
        this.setWeight(500);
        setDiet(new Herbivore());
        if (num>0.5 && num<3)
            this.trunkLength=num;
        else
            this.trunkLength=1;

    }

    /**
     * tnis method use to make the elephant's sound.
     */
    public void chew() {

    }
    public boolean settrunkLength(double len){return true;}
}
