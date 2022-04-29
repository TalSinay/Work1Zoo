package animals;
import graphics.ZooPanel;
import mobility.*;
import diet.*;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;

/**
 * 'Elephant' class, used to declare all the elephants in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see Animal
 * */
public class Giraffe extends chew{

    /**
     * get_loc -> give the default location of the Giraffe.
     * @return default location(Point).
     */
    public static Point get_loc(){
        return new Point(100, 5);
    }
    /**
     * Giraffe Constructor.
     * @param size the animal's size
     * @param ver_speed the animal's vertical speed
     * @param hor_speed the animal's horizontal speed.
     * @param color the animal's color
     * @param weight the animal's weight
     * @param pan the zoo panel.
     */
    public Giraffe(int size, int ver_speed, int hor_speed, String color, double weight, ZooPanel pan){
        super(get_loc(), size, ver_speed, hor_speed, color, weight, pan);
        setName("Giraffe");
        loadImages(get_nm());
        setDiet(new Herbivore());
    }
    /**
     * tnis method use to make the giraffe's sound.
     */
    public void chew() {
        MessageUtility.logSound(getName(), "Bleats and Stomps its legs, then chews");
    }

    /**
     * get_nm method
     * @return the name of the animal in the files.
     */
public String get_nm() {
    String s = new String("");
    switch (getColor()) {
        case "Red" -> s = "grf_r";
        case "Blue" -> s = "grf_b";
        case "Natural" -> s = "grf_n";
    }
    return s;
}
}

