package zoo;
import animals.*;
import food.*;
import diet.*;
import mobility.*;

public class ZooActions {
    static public boolean eat(Object animal,IEdible food) {
        if (animal instanceof Carnivore) {
            if(((Carnivore) animal).canEat(food.getFoodtype())) {
                ((Carnivore) animal).eat((Animal) animal,food);
                return true;
            }
        }


        if (animal instanceof Omnivore) {
            if(((Omnivore) animal).canEat(food.getFoodtype())) {
                ((Omnivore) animal).eat((Animal) animal,food);
                return true;
            }
        }

        if (animal instanceof Herbivore) {
            if(((Herbivore) animal).canEat(food.getFoodtype())) {
                ((Herbivore) animal).eat((Animal) animal,food);
                return true;
            }

        }
        return false;
    }

    static public boolean move(Object animal,Point point) {
        if(point.getx()>point.getmaxX()||point.getx()<point.getminx()||point.gety()>point.getmaxy()||point.gety()<point.getminy())
            return false;
        if (animal instanceof Animal) {
            ((Animal) animal).move(point);
            return true;
        }
        return false;
    }


}

