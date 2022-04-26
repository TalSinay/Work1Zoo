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
//    /**
//     * roar constructor.
//     * @param name the object's name.
//     * @param p start location.
//     */
//    public roar(String name,Point p){
//        super(name,p);
//    }
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
