package diet;

import animals.Animal;
import food.*;
/**
 * 'Carnivore' class, used to declare all the animals were are Carnivores.
 * this class implements IDiet interface.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see food
 * */
public class Carnivore implements IDiet {

    /**
     * canEat method- check if the food is MEAT.
     * @param food
     * @return true/ false.
     */
    @Override
    public boolean canEat(EFoodType food) {

        if (food==EFoodType.MEAT)
            return true;

        else
            return false;
    }

    /**
     * eat method- a method to eat food (if it possible).
     * @param animal the animal we want to feed.
     * @param food
     * @return the gain weight from the meal (can be zero).
     */
    @Override
    public double eat(Animal animal, IEdible food) {

        if (canEat(food.getFoodtype()))
            return animal.getWeight()*0.1;


       return 0;
    }

    /**
     * toString method.
     * @return the eating type in a String format.
     */
    public String toString(){
        return "[Carnivore]";
    }

}
