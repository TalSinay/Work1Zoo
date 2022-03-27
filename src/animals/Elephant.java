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
        System.out.println("Trumpets with joy while flapping its ears, then chews");
    }
    /**
     * settrunkLength method - set the trunk length of the elephant.
     * @param len the new length.
     * @return true/ false.
     */
    public boolean settrunkLength(double len){
        if (len>0.5 && len<3)
            trunkLength = len;
        return true;
    }

    /**
     * override method. use settrunkLength method
     * @param len the new len.
     * @return true/ false.
     */
    @Override
    public boolean setValue(double len) {
        return settrunkLength(len);
    }
}
