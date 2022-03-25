package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;
/**
 * 'Herbivore' class, used to declare all the animals were are Herbivore.
 * this class implements IDiet interface.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see {food}
 * */

public class Herbivore implements IDiet {
    /**
     * canEat method- used to check if the food is vegan.
     * @param food
     * @return true/ false.
     */

    public boolean canEat(EFoodType food) {
        if (food==EFoodType.VEGETABLE) {
            return true;
        }
        return false;

    }

    /**
     * eat method- a method to feed the animal.
     * @param animal that we want to feed
     * @param food
     * @return the weight it gained in the meal (can be zero).
     */
    public double eat(Animal animal, IEdible food) {
        if (canEat(food.getFoodtype())) {
            return animal.getWeight()*0.07;
        }
        return 0;
    }


}
