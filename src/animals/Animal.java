package animals;
// import java.util.Scanner;
import diet.*;
import food.*;
import mobility.*;

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

    }

    /**
     * this method using to set the 'IDiet' interface in the animal's atribute
     * @param diet the interface.
     * @return return true.
     */
    public boolean setDiet(IDiet diet) {
        this.diet=diet;
        System.out.println("[s] "+ getName() + "setDiet("+diet.toString()+ ") => true");
        return true;
    }

    /**
     * 'get' method to get the animal's weight.
     * @returnthe animal's weight.
     */

    public double getWeight() {
        System.out.println("[g] " + name + ":getWeight() => true");
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
        System.out.println("[s] "+ getName() + "setWeight("+x+ ") => " + flag);
        return true;
    }

    /**
     * set name method, use for set new name
     * @param  name  new animal's name.
     */
    public void setName(String name) {
        this.name=name;
        System.out.print("[s] "+ getName() + "setName("+name+ ") => true");
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
        System.out.println("[g] " + name + ":getFoodtype() => ");
        return EFoodType.MEAT;
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
        if (y>0) {
            this.setWeight(getWeight()+y);
            return true;
        }
        return false;
    }
    public boolean setValue(String value){return true;};
    public boolean setValue(double value){return true;};
    public boolean setValue(int value){return true;};

    //
    public String getName(){return name;}

}

