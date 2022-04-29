package diet;
import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * 'IDiet' interface, used to give the same interface for all the diet types.

 * @version 24.3.22
 * @author Tal and Shoham
 * @see food
 * */
public interface IDiet {
    /**
     * canEat method, every class that'll implement this interface must give is unique implement for this method.
     * @param food the food.
     * @return true/ false.
     */
    boolean canEat(EFoodType food);

    /**
     * eat method, every class that'll implement this interface must give is unique implement for this method.
     * @param animal the animal we want to feed
     * @param food the food.
     * @return the gain weight(could be 0)
     */
    double eat(Animal animal, IEdible food);
    /**
     * toString method.
     * @return the eating type in a String format.
     */
    public String toString();

}
