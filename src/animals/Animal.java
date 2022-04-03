package animals;
// import java.util.Scanner;
import diet.*;
import food.*;
import mobility.*;
import utilities.MessageUtility;

/**
 * 'Animal' class, used to declare all the animals in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see {diet}
 * */
public abstract class Animal extends Mobile implements IEdible  {
    private String name;
    private double weight;
    private IDiet diet;

    /**
     * animal constructor.
     * @param name the given name (string).
     * @param location the given location (point).
     */
    public Animal(String name,Point location) {
        super(location);
        this.name=name;
        MessageUtility.logConstractor(getClass().getName(), name);
    }

    /**
     * this method using to set the 'IDiet' interface in the animal's atribute
     * @param diet the interface.
     * @return return true.
     */
    public boolean setDiet(IDiet diet) {
        boolean flag = true;
        this.diet=diet;
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setDiet", diet, flag);
        return true;
    }

    /**
     * 'get' method to get the animal's weight.
     * @returnthe animal's weight.
     */

    public double getWeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
        return this.weight;
    }

    /**
     * set weight method, use for set new weight
     * @param x the new animal's weight.
     */
    public boolean setWeight(double x) {
        boolean flag = false;
        if(x > 0) {
            this.weight = x;
            flag = true;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", x, flag);
        return true;
    }

    /**
     * set name method, use for set new name
     * @param  name  new animal's name.
     */
    public boolean setName(String name) {
        boolean flag = name != null;
        if(flag) {
            this.name = name;
            MessageUtility.logSetter(this.getClass().getSimpleName(), "setName", name, flag);

        }
        return flag;
    }

    /**
     * makeSound method- using to sort the animals sound.
     * check the animal's type and make the requirement sound.
     */
    public abstract void makeSound();// in roar or chew

    /**
     * method to get the animal's type of food.
     * (in that case- all animals will return MEAT.)
     * @return the animal's type.
     */
    public EFoodType getFoodtype() {
        //////////////////
        /**
         * need to fix.
         */
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", this instanceof Lion ? EFoodType.NOTFOOD: EFoodType.MEAT);
        return EFoodType.MEAT;
    }



    public boolean Move(Point p){
        boolean flag = Point.cheackBounderies(p);
        MessageUtility.logBooleanFunction(this.getClass().getSimpleName(), "Move", p, flag);
        return flag;
    }
    /**
     * eat method - method for the animals to eat.
     * set a new weight after eats.
     * return true/ false if he ate successfully.
     * @param food the food.(IEdible)
     * @return true/ false.
     */
    public boolean eat(IEdible food) {
        double y=diet.eat(this, food);
        boolean flag = y>0;
        if (flag) {
            this.setWeight(getWeight()+y);
        }
        MessageUtility.logBooleanFunction(this.getClass().getSimpleName(), "eat", food, flag);
        return flag;
    }
    public boolean setValue(String value){return true;};
    public boolean setValue(double value){return true;};
    public boolean setValue(int value){return true;};
//
//    @Override
//    public String toString() {
//        return "[" + this.getClass().getSimpleName() + "]: " + this.getName();
//    }
    //
    public String getName(){
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getName", this.name);
        return name;
    }

}

