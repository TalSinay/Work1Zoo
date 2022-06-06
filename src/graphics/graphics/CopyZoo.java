package graphics.graphics;

import animals.Animal;
import graphics.*;

import java.util.ArrayList;

public class CopyZoo {
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Object> foods = new ArrayList<Object>();
    public ArrayList<Animal> getAnimals() {
        ArrayList<Animal> animalss = new ArrayList<Animal>(animals);
        return animalss;
    }

    public ArrayList<Object> getFoods() {
        ArrayList<Object> foodss = new ArrayList<Object>(foods);
        return foodss;
    }
    public CopyZoo(ZooPanel zp){
        animals = zp.getAnimals();
        foods = zp.getFoods();
    }
}
