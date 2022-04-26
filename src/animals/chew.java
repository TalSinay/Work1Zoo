package animals;

import graphics.ZooPanel;
import mobility.Point;
/**
 * 'chew' an abstract class, used to declare all the animals in the zoo who chews.
 * @version 2.4.22
 * @author Tal and Shoham
 * @see  Elephant
 * @see Giraffe
 * @see Turtle
 * */
public abstract class chew  extends Animal{
//    /**
//     * chew constructor.
//     * @param name the object's name.
//     * @param p start location.
//     */
//    public chew(String name, Point p){
//        super(name,p);
//    }

    public chew(Point p, int size, int ver_speed, int hor_speed, String color, double weight, ZooPanel pan){
        super(p, size, ver_speed, hor_speed, color, weight, pan);
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