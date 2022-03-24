package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

public class Omnivore implements IDiet {
    private  Herbivore h;
    private  Carnivore c;
    public boolean canEat(EFoodType food) {
        if (food==EFoodType.VEGETABLE){
            return true;
        }
        if (food==EFoodType.MEAT) {
            return true;
        }
        return false;
    }
    public double eat(Animal animal, IEdible food) {
        if (h.canEat(food.getFoodtype()) || c.canEat(food.getFoodtype()))
            return h.eat(animal, food)+c.eat(animal, food);

        return 0;
    }
}
