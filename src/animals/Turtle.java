package animals;
import diet.*;
import mobility.*;

/**
 * 'Turtle' class, used to declare all the turtles in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see {Animal}
 * */
public class Turtle extends Animal{
    private int Age;

    /**
     * the turtle constructor.
     * @param name the turtle's name.
     */
    public Turtle (String name) {
        super(name,new Point(80,0));
        setDiet(new Herbivore());
        this.setweight(1);

    }

    /**
     * turtle fully constructor.
     * @param name turtle's name.
     * @param p the turtle's location.
     */
    public Turtle(String name,Point p) {
        super(name,p);
        setDiet(new Herbivore());
        this.setweight(1);
    }

    /**
     * this method use to make the turtle sound
     */
    public void chew() {

    }

    /**
     * method to set the turtle's age.
     * @param age
     * @return true/ false.
     * */
    public boolean setAge(int age){return true;}
}
