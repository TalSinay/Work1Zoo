package animals;
import diet.*;
import graphics.*;
import mobility.*;
import utilities.MessageUtility;

import java.util.Observer;
import java.util.Vector;

/**
 * 'Turtle' class, used to declare all the turtles in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see Animal
 * */
public class Turtle extends chew{

    /**
     * Turtle constructor.
     *
     * @param size the given location (Point).
     * @param ver_speed the given vertical speed (int).
     * @param hor_speed the given horizontal speed (int).
     * @param color the given color (String).
     * @param weight the given  weight (double).
     * @param pan the given  panel (ZooPanel).
     */
    public Turtle(int size, int ver_speed, int hor_speed, String color, double weight, ZooPanel pan){
        super(get_loc(), size, ver_speed, hor_speed, color, weight, pan);
        setName("Turtle");
        loadImages(get_nm());
        setDiet(new Herbivore());
    }

    /**
     * get_loc -> give the default location of the Turtle.
     * @return default location(Point).
     */
    public static Point get_loc(){
        return new Point(80, 0);
    }

    /**
     * this method use to make the turtle sound
     */
    public void chew() {
//        MessageUtility.logSound(getName(),"Retracts its head in then eats quietly");
    }
    /**
     * get_nm method
     * @return the name of the animal in the files.
     */
    public String get_nm() {
        String s = new String("");
        switch (getColor()) {
            case "Red" -> s = "trt_r";
            case "Blue" -> s = "trt_b";
            case "Natural" -> s = "trt_n";
        }
        return s;
    }
}
