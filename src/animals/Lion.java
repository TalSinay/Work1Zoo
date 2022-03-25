package animals;
import mobility.*;
import diet.*;
import food.EFoodType;
/**
 * 'Lion' class, used to declare all the lions in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see {Animal}
 * */
public class Lion extends Animal {
    private int scarCount=0;

    public Lion(String name) {
        super(name,new Point(20,0));
        setDiet(new Carnivore());
        this.setweight(408.2);
    }
    public Lion(String name,Point p) {
        super(name,p);
        setDiet(new Carnivore());
        this.setweight(408.2);
    }

    public void roar() {

    }

    public EFoodType getFoodtype() {
        return EFoodType.NOTFOOD;
    }
}
