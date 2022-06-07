package animals;
import diet.*;
import graphics.ZooPanel;
import mobility.*;
import utilities.MessageUtility;

import java.util.Observer;
import java.util.Vector;

/**
 * 'Bear' class, used to declare all the bears in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see Animal
 * */
public class Bear extends roar {
    private String furColor;


    /**
     * get_loc -> give the default location of the bear.
     * @return default location(Point).
     */
    public static Point get_loc() {
        return new Point(100, 5);
    }

    /**
     * Bear Constructor.
     * @param size the bear size
     * @param ver_speed the bear vertical speed
     * @param hor_speed the bear horizontal speed.
     * @param color the bear color
     * @param weight the bear weight
     * @param pan the zoo panel.
     */
    public Bear(int size, int ver_speed, int hor_speed, String color, double weight, ZooPanel pan,Observer observer) {
        super(get_loc(), size, ver_speed, hor_speed, color, weight, pan,observer);
        loadImages(get_nm());
        setName("Bear");
        setDiet(new Omnivore());
    }

    /**
     * this method used to make the bear sound.
     */
    public void roar() {
//        MessageUtility.logSound(getName(), "Stands on its hind legs, roars and scratches its belly");
    }
    /**
     * get_nm method
     * @return the name of the animal in the files.
     */

    public String get_nm() {
        String s = new String("");
        switch (getColor()) {
            case "Red" -> s = "bea_r";
            case "Blue" -> s = "bea_b";
            case "Natural" -> s = "bea_n";
        }
        return s;
    }
}



