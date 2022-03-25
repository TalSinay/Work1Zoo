package zoo;
import animals.*;
import food.*;
import diet.*;
import mobility.*;

/**
 * 'ZooActions' class, used to make all the actions in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * {@see animals}
 * */
public class ZooActions {
    /**
     * eat method, method to feed 'animal' with 'food'.
     * @param animal the animal we want to feed.
     * @param food the eaten one.
     * @return true/ false.
     */
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

    /**
     * move method, moving animal from one point to another.
     * @param animal we want to move on.
     * @param point the destination
     * @return true/ false.
     */
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

