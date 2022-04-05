package zoo;
import animals.*;
import food.*;
import diet.*;
import mobility.*;
import java.util.Scanner;
import java.util.Random;

import plants.*;
import utilities.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 'ZooActions' class, used to make all the actions in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * {@see animals}
 * */
public class ZooActions {
    private static List<Animal> animals;
	private static Bear bear;
	private static Elephant elephant;
	private static List<IEdible> food;
	private static Giraffe giraffe;
	private static Lion lion;
	private static Turtle turtle;
    /**
     * eat method, method to feed 'animal' with 'food'.
     * @param animal the animal we want to feed.
     * @param food the eaten one.
     * @return true/ false.
     */
    static public boolean eat(Object animal,IEdible food) {
//            if(((Carnivore) animal).canEat(food.getFoodtype())) {
//                ((Carnivore) animal).eat((Animal) animal,food);
//                return true;
//            }
//        }
//
//
//        if (animal instanceof Omnivore) {
//            if(((Omnivore) animal).canEat(food.getFoodtype())) {
//                ((Omnivore) animal).eat((Animal) animal,food);
//                return true;
//            }
//        }
//
//        if (animal instanceof Herbivore) {
//            if(((Herbivore) animal).canEat(food.getFoodtype())) {
//                ((Herbivore) animal).eat((Animal) animal,food);
//                return true;
//            }


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
            ((Mobile) animal).move(point);
            return true;
        }
        return false;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
//        System.out.println("Enter amount of animals: (MINIMUM 3):");
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        if (size < 3){size = 3;}
//        animals = new ArrayList<>();
////        Animal[] animals = new Animal[size];
//        for(int i = 0; i < size; i++){
//            System.out.println("Choose the Animal Type:\n1.Lion\n2.Bear\n3.Turtle\n4.Giraffe\n5.Elephant");
//            sc = new Scanner(System.in);
//            Point p;
//            switch (sc.nextInt()){
//                case 1:
//                    System.out.println("Enter Lion's name");
//                    sc = new Scanner(System.in);
//                    lion = new Lion(sc.nextLine());
//                    animals.add(lion);
//
//                    break;
//
//
//                case 2:
//                    System.out.println("Enter Bear's name");
//                    sc = new Scanner(System.in);
//                    bear = new Bear(sc.nextLine());
//                    animals.add(bear);
//
//                    break;
//
//                case 3:
//                    System.out.println("Enter turtle's name");
//                    sc = new Scanner(System.in);
//                    turtle = new Turtle(sc.nextLine());
//                    animals.add(turtle);
//
//                    break;
//
//                case 4:
//                    System.out.println("Enter Giraffe's name");
//                    sc = new Scanner(System.in);
//                    giraffe = new Giraffe(sc.nextLine());
//                    animals.add(giraffe);
//
//                    break;
//                case 5:
//                    System.out.println("Enter Elephant's name");
//                    sc = new Scanner(System.in);
//                    elephant = new Elephant(sc.nextLine());
//                    animals.add(elephant);
//                    break;
//                default:
//                    System.out.println("Bad Choice, try again");
//                    i--;
//                    break;
      //      }// end switch.
    //    }// end for loop.

//        food = new LinkedList<>();
//		food.add(new Cabbage());
//		food.add(animals.get(0));
//		food.add(animals.get(1));
//        Random rand = new Random();
//        for(Animal animal :animals){
//            move(animal,new Point(rand.nextInt(801), rand.nextInt(601)));
//        }
//
//        ////////////////////////// index 1 != index 2!!!!!
//        for(int i = 0; i< animals.size() /2; i++){
//            int x=rand.nextInt(animals.size());
//            int y=rand.nextInt(animals.size());
//            if(x!=y)
//                if(eat(animals.get(x), animals.get(y)))
//                    animals.remove(y);
//            else
//                i--;
//        }
        lion = new Lion("Simba", new Point(80, 80));
        bear = new Bear("Baloo", new Point(70, 70));
        //lion.eat(bear);
        eat(lion, bear);
    }// end main().


}
