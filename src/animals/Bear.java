package animals;
import diet.*;
import graphics.ZooPanel;
import mobility.*;
import utilities.MessageUtility;

/**
 * 'Bear' class, used to declare all the bears in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see Animal
 * */
public class Bear extends roar {
    private String furColor;

    public static Point get_loc() {
        return new Point(100, 5);
    }
//    /**
//     * constructor with only one argument.
//     * @param name the bear's name.
//     */
//    public Bear(String name) {
////        super(name,new Point(100,5));
//        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
//        this.setWeight(308.2);
//        this.setFurColor("GRAY");
//        setDiet(new Omnivore());
//    }
//
//    /**
//     * 'Bear' constructor.
//     * @param name the bear's name.
//     * @param p the bear's location.
//     * //@param color the bear's fur color.
//     */
//    public Bear(String name,Point p) {
//        super(name,p);
//        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
//        this.setWeight(308.2);
//        this.setFurColor("GRAY");
//        setDiet(new Omnivore());
//
//    }
//    /**
//     * 'Bear' fully constructor.
//     * @param name the bear's name.
//     * @param p the bear's location.
//     * @param furColor the bear's fur color.
//     * //@param color the bear's fur color.
//     */
//    public Bear(String name,Point p, String furColor) {
//        super(name,p);
//        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
//        this.setWeight(308.2);
//        this.setFurColor(furColor);
//        setDiet(new Omnivore());
//
//    }

    public Bear(int size, int ver_speed, int hor_speed, String color, double weight, ZooPanel pan) {
        super(get_loc(), size, ver_speed, hor_speed, color, weight, pan);
    }

    /**
     * this method used to make the bear sound.
     */
    public void roar() {
        MessageUtility.logSound(getName(), "Stands on its hind legs, roars and scratches its belly");

    }

    /**
     * setFurColor method - set the fur color of the bear.
     *
     * @param color the new color
     * @return true/ false.
     */
    public boolean setFurColor(String color) {
        boolean flag = false;
        if (color.equals("BLACK") || color.equals("WHITE") || color.equals("GRAY")) {
            flag = true;
            this.furColor = color;
        } else {
            this.furColor = "GRAY";
        }
        MessageUtility.logSetter(this.getName(), "setFurColor", color, flag);
        return flag;
    }

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



