package diet;

import animals.Animal;
import food.*;

public class Carnivore implements IDiet {

    @Override
    public boolean canEat(EFoodType food) {

        if (food==EFoodType.MEAT)
            return true;

        else
            return false;
    }

    @Override
    public double eat(Animal animal, IEdible food) {

        if (canEat(food.getFoodtype()))
            return animal.getWeight()*0.1;

        return 0;
    }

}
