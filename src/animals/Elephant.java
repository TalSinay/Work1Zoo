package animals;
import diet.*;
import graphics.ZooPanel;
import mobility.*;
import utilities.MessageUtility;

import java.util.Observer;
import java.util.Vector;

/**
 * 'Elephant' class, used to declare all the elephants in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see Animal
 * */
public class Elephant extends chew{

    /**
     * get_loc -> give the default location of the Elephant.
     * @return default location(Point).
     */
    public static Point get_loc(){
        return new Point(50, 90);
    }

    /**
     * Elephant Constructor.
     * @param size the animal's size
     * @param ver_speed the animal's vertical speed
     * @param hor_speed the animal's horizontal speed.
     * @param color the animal's color
     * @param weight the animal's weight
     * @param pan the zoo panel.
     */
    public Elephant(int size, int ver_speed, int hor_speed, String color, double weight, ZooPanel pan,Observer observer){
        super(get_loc(), size, ver_speed, hor_speed, color, weight, pan,observer);
        loadImages(get_nm());
        setName("Elephant");
        setDiet(new Herbivore());
    }
    public Elephant(Elephant e){
        super(get_loc(), e.getSize(), e.getVerSpeed(), e.getHorSpeed(), e.getColor(), e.getWeight(), e.getPan(),null);
        loadImages(get_nm());
        setName("Elephant");
        setDiet(new Herbivore());
    }

    /**
     * tnis method use to make the elephant's sound.
     */
    public void chew() {
//        MessageUtility.logSound(getName(),"Trumpets with joy while flapping its ears, then chews");
    }

    /**
     * get_nm method
     * @return the name of the animal in the files.
     */
    public String get_nm() {
        String s = new String("");
        switch (getColor()) {
            case "Red" -> s = "elf_r";
            case "Blue" -> s = "elf_b";
            case "Natural" -> s = "elf_n";
        }
        return s;
    }
}
