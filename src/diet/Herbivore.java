package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

public class Herbivore implements IDiet {
    public boolean canEat(EFoodType food) {
        if (food==EFoodType.VEGETABLE) {
            return true;
        }
        return false;

    }
    public double eat(Animal animal, IEdible food) {
        if (canEat(food.getFoodtype())) {
            return animal.getWeight()*0.07;
        }
        return 0;
    }


}
