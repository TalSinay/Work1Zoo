package animals;

import graphics.ZooPanel;
import mobility.Point;

import java.util.Observer;

/**
 * 'chew' an abstract class, used to declare all the animals in the zoo who chews.
 * @version 2.4.22
 * @author Tal and Shoham
 * @see  Elephant
 * @see Giraffe
 * @see Turtle
 * */
public abstract class chew  extends Animal{

    /**
     * chew Constructor.
     * @param p the starting point.
     * @param size the animal's size
     * @param ver_speed the animal's ver speed.
     * @param hor_speed the animal's hor speed.
     * @param color the animal's color
     * @param weight the animal's weight
     * @param pan the zoo panel.
     */
    public chew(Point p, int size, int ver_speed, int hor_speed, String color, double weight, ZooPanel pan, Observer observer){
        super(p, size, ver_speed, hor_speed, color, weight, pan,observer);
    }
    /**
     * makeSound method. using to make the animal's sound (in this case: to chew).
     */
    public void makeSound() {
        chew();
    }

    /**
     * chew method, this method must be override by the derived class.(animals who chew).
     */
    public abstract void chew();
}