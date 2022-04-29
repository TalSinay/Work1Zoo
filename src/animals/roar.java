package animals;

import graphics.ZooPanel;
import mobility.*;

/**
 * 'roar' an abstract class, used to declare all the animals in the zoo who roars.
 * @version 2.4.22
 * @author Tal and Shoham
 * @see Bear
 * @see Lion
 * * */
public abstract class roar  extends Animal{
    /**
     * roar Constructor.
     * @param p the starting point.
     * @param size the animal's size
     * @param ver_speed the animal's ver speed.
     * @param hor_speed the animal's hor speed.
     * @param color the animal's color
     * @param weight the animal's weight
     * @param pan the zoo panel.
     */
    public roar(Point p, int size, int ver_speed, int hor_speed, String color, double weight, ZooPanel pan){
        super(p, size, ver_speed, hor_speed, color, weight, pan);
    }
    /**
     * makeSound method. using to make the animal's sound (in this case: to roar).
     */
    public void makeSound() {
        roar();
    }
    /**
     * roar method, this method must be override by the derived class.(animals who roar).
     */
    public abstract void roar();
}
