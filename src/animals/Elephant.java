package animals;
import diet.*;
import graphics.ZooPanel;
import mobility.*;
import utilities.MessageUtility;

/**
 * 'Elephant' class, used to declare all the elephants in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see Animal
 * */
public class Elephant extends chew{
    public static Point get_loc(){
        return new Point(50, 90);
    }
//
//    /**
//     * the elephant constructor
//     * @param name the elephant name.
//     */
//    public Elephant(String name) {
//        super(name,new Point(50,90));
//        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
//        this.settrunkLength(1);
//        this.setWeight(500);
//        setDiet(new Herbivore());
//
//    }
//    /**
//     * the elephant constructor.
//     * @param name elephant's name.
//     * @param p location (point)
//     */
//    public Elephant(String name,Point p) {
//        super(name,p);
//        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
//        this.setWeight(500);
//        this.settrunkLength(1);
//        setDiet(new Herbivore());
//    }

//    /**
//     * the elephant fully constructor.
//     * @param name elephant's name.
//     * @param p location (point)
//     * @param num the trunk length
//     */
//    public Elephant(String name,Point p,double num) {
//        super(name,p);
//        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
//        this.setWeight(500);
//        this.settrunkLength(num);
//        setDiet(new Herbivore());
//    }
    public Elephant(int size, int ver_speed, int hor_speed, String color, double weight, ZooPanel pan){
        super(get_loc(), size, ver_speed, hor_speed, color, weight, pan);
    }

    /**
     * tnis method use to make the elephant's sound.
     */
    public void chew() {
        MessageUtility.logSound(getName(),"Trumpets with joy while flapping its ears, then chews");
    }
    /**
     * settrunkLength method - set the trunk length of the elephant.
     * //@param  the new length.
     * @return true/ false.
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
