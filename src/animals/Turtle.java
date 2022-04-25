package animals;
import diet.*;
import mobility.*;
import utilities.MessageUtility;

/**
 * 'Turtle' class, used to declare all the turtles in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see Animal
 * */
public class Turtle extends chew{

    public Turtle(int size, int ver_speed, int hor_speed, String color, double weight){
        super(get_loc(), size, ver_speed, hor_speed, color, weight);
    }


    //    /**
//     * the turtle constructor.
//     * @param name the turtle's name.
//     */
//    public Turtle (String name) {
//        super(name,new Point(80,0));
//        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
//        this.setWeight(1);
//        this.setAge(1);
//        setDiet(new Herbivore());
//    }
//
//    /**
//     * turtle constructor.
//     * @param name turtle's name.
//     * @param p the turtle's location.
//     */
//    public Turtle(String name,Point p) {
//        super(name,p);
//        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
//        this.setWeight(1);
//        this.setAge(1);
//        setDiet(new Herbivore());
//
//    }
//    /**
//     * turtle fully constructor.
//     * @param name turtle's name.
//     * @param p the turtle's location.
//     * @param age the turtle's age.
//     */
//    public Turtle(String name,Point p, int age) {
//        super(name,p);
//        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
//        this.setWeight(1);
//        this.setAge(age);
//        setDiet(new Herbivore());
//
//    }
    public static Point get_loc(){
        return new Point(80, 0);
    }

    /**
     * this method use to make the turtle sound
     */
    public void chew() {
        MessageUtility.logSound(getName(),"Retracts its head in then eats quietly");
    }



//    /**
//     * override method. use setAge.
//     * @param value the age
//     * @return true
//     */
//    @Override
//    public boolean setValue(int value) {
//        return setAge(value);
//    }

}
