package animals;
import java.util.Scanner;
import diet.*;
import food.*;
import mobility.*;

public class Animal extends Mobile implements IEdible  {
    private String name;
    private double weight;
    private IDiet diet;

    public Animal(String name,Point location) {
        super(location);
        this.name=name;

    }
    public boolean setDiet(IDiet diet) {
        this.diet=diet;
        return true;
    }
    public double getWeight() {
        return this.weight;
    }

    public void setweight(double x) {
        this.weight=x;

    }
    public void setName(String name) {
        this.name=name;
    }
    public void makeSound() {
        if (this instanceof Lion) {
            ((Lion) this).roar();
        }
        else if(this instanceof Bear) {
            ((Bear) this).roar();
        }
        else if(this instanceof Elephant) {
            ((Elephant) this).chew();
        }
        else if(this instanceof Giraffe) {
            ((Giraffe) this).chew();
        }
        else if(this instanceof Turtle) {
            ((Turtle) this).chew();
        }

    }


    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }
    public boolean eat(IEdible food) {
        double y=diet.eat(this, food);
        if (y>0) {
            this.setweight(getWeight()+y);
            return true;
        }
        return false;
    }



}

