package animals;
import food.IEdible;
import graphics.ZooPanel;
import mobility.*;
import diet.*;
import food.EFoodType;
import utilities.MessageUtility;

import java.util.Observer;
import java.util.Random;
import java.util.Vector;

/**
 * 'Lion' class, used to declare all the lions in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see Animal
 * */
public class Lion extends roar {


    /**
     * Lion Constructor.
     * @param size the animal's size
     * @param ver_speed the animal's vertical speed
     * @param hor_speed the animal's horizontal speed.
     * @param color the animal's color
     * @param weight the animal's weight
     * @param pan the zoo panel.
     */
    public Lion(int size, int ver_speed, int hor_speed, String color, double weight, ZooPanel pan,Observer observer){
        super(get_loc(), size, ver_speed, hor_speed, color, weight, pan,observer);
        setName("Lion");
        loadImages(get_nm());
        this.setDiet(new Carnivore());
    }
    /**
     * get_loc -> give the default location of the Lion.
     * @return default location(Point).
     */
    public static Point get_loc(){
        return new Point(20, 0);
    }
    /**
     * this methos is using to make the lion's sound.
     */
    public void roar() {
//        MessageUtility.logSound(getName(),"Roars, then stretches and shakes its mane");
    }

    /**
     *
     * override the base class method to return the right type.
     * (only lions get this type)
     *@see Animal
     * @return NOTFOOD (EFoodType).
     */
    @Override
    public EFoodType getFoodtype() {
        return EFoodType.NOTFOOD;
    }
    public boolean eat(IEdible food){
        if(super.eat(food)){
            return true;
        }
        return false;
    }
    /**
     * get_nm method
     * @return the name of the animal in the files.
     */
    public String get_nm() {
        String s = new String("");
        switch (getColor()) {
            case "Red" -> s = "lio_r";
            case "Blue" -> s = "lio_b";
            case "Natural" -> s = "lio_n";
        }
        return s;
    }

}
