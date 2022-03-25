package food;
/**
 * 'IEdible' interface, used to give a way to know diet types of animals.

 * @version 24.3.22
 * @author Tal and Shoham
 * @see {food}
 * */
public interface IEdible {
    /**
     * getFoodtype - method to get the food's type.
     * @return food's type.
     */
    public EFoodType getFoodtype();
}

