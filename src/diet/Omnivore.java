package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * 'Omnivore' class, used to declare all the animals were are both Carnivore and Herbivore.
 * this class implements IDiet interface.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see {food}
 * */
public class Omnivore implements IDiet {

    private  Herbivore h;
    private  Carnivore c;

    /**
     * canEat- method to check if the food isn't lion(NOTMEAT).
     * @param food
     * @return true/ false.
     */
    public boolean canEat(EFoodType food) {
        if (food==EFoodType.VEGETABLE){
            return true;
        }
        if (food==EFoodType.MEAT) {
            return true;
        }
        return false;
    }

    /**
     * eat method- using to feed the animal.
     * we using that method below, to do the right calculate in any feed.
     * @param animal we want to feed.
     * @param food
     * @return return the gain weight from the meal.
     */
    public double eat(Animal animal, IEdible food) {
        if (h.canEat(food.getFoodtype()) || c.canEat(food.getFoodtype()))
            return h.eat(animal, food)+c.eat(animal, food);

        return 0;
    }
}
