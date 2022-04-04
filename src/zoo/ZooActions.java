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
        if (animal instanceof Animal) {
            if(((Animal) animal).eat(food)) {
                return true;
            }
        }

        return false;
    }

    /**
     * move method, moving animal from one point to another.
     * @param p the destination
     * @param animal we want to move on.
     * @return true/ false.
     */
    static public boolean move(Object animal,Point p) {
        if (animal instanceof Animal) {
            if(Point.cheackBounderies(p)){
                ((Animal) animal).move(p);
                return true;
            }

        }
        return false;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Enter amount of animals: (MINIMUM 3):");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(), choice;
        if (size < 3) {
            size = 3;
        }
        animals = new ArrayList<>();
//        Animal[] animals = new Animal[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Choose the Animal Type:\n1.Lion\n2.Bear\n3.Turtle\n4.Giraffe\n5.Elephant");
            sc = new Scanner(System.in);
            Point p;
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter Lion's name");
                    sc = new Scanner(System.in);
                    lion = new Lion(sc.nextLine());
                    animals.add(lion);

//                    System.out.println("Enter Lion's place");
//                    sc = new Scanner(System.in);
//                    p = new Point(sc.nextInt(), sc.nextInt());
//                    // 'setLocation' will check if the point are available.
//                    animals.get(i).setLocation(p);
//                    System.out.println("Enter Lion's scars amount");
//                    sc = new Scanner(System.in);
//                    int scars = sc.nextInt();
//                    ((Lion)animals.get(i)).setScarCount(scars);
                    break;


                case 2:
                    System.out.println("Enter Bear's name");
                    sc = new Scanner(System.in);
                    bear = new Bear(sc.nextLine());
                    animals.add(bear);
//                    System.out.println("Enter Bear's place");
//                    sc = new Scanner(System.in);
//                    p = new Point(sc.nextInt(), sc.nextInt());
//                    // 'setLocation' will check if the point are available.
//                    animals.get(i).setLocation(p);
//                    System.out.println("Enter Bear's fur color");
//                    sc = new Scanner(System.in);
//                    String furColor = sc.nextLine();
//                    animals.get(i).setValue(furColor);
                    break;

                case 3:
                    System.out.println("Enter turtle's name");
                    sc = new Scanner(System.in);
                    turtle = new Turtle(sc.nextLine());
                    animals.add(turtle);
//                    System.out.println("Enter turtle's place");
//                    sc = new Scanner(System.in);
//                    p = new Point(sc.nextInt(), sc.nextInt());
//                    // 'setLocation' will check if the point are available.
//                    animals.get(i).setLocation(p);
//                    System.out.println("Enter turtle's age");
//                    sc = new Scanner(System.in);
//                    int age = sc.nextInt();
//                    animals.get(i).setValue(age);
                    break;

                case 4:
                    System.out.println("Enter Giraffe's name");
                    sc = new Scanner(System.in);
                    giraffe = new Giraffe(sc.nextLine());
                    animals.add(giraffe);
//                    System.out.println("Enter Giraffe's place");
//                    sc = new Scanner(System.in);
//                    p = new Point(sc.nextInt(), sc.nextInt());
//                    // 'setLocation' will check if the point are available.
//                    animals.get(i).setLocation(p);
//                    System.out.println("Enter Giraffe's neck length");
//                    sc = new Scanner(System.in);
//                    double neckLength = sc.nextDouble();
//                    animals.get(i).setValue(neckLength);
                    break;
                case 5:
                    System.out.println("Enter Elephant's name");
                    sc = new Scanner(System.in);
                    elephant = new Elephant(sc.nextLine());
                    animals.add(elephant);
//                    System.out.println("Enter Elephant's place");
//                    sc = new Scanner(System.in);
//                    p = new Point(sc.nextInt(), sc.nextInt());
//                    // 'setLocation' will check if the point are available.
//                    animals.get(i).setLocation(p);
//                    System.out.println("Enter Elephant's trunk length");
//                    sc = new Scanner(System.in);
//                    int trunkLength = sc.nextInt();
//                    animals.get(i).setValue(trunkLength);
                    break;
                default:
                    System.out.println("Bad Choice, try again");
                    i--;
                    break;
            }// end switch.
        }// end for loop.
        food = new LinkedList<>();
        food.add(new Cabbage());
        food.add(animals.get(0));
        food.add(animals.get(1));
        Random rand = new Random();
        for (Animal animal : animals) {
            move(animal,new Point(rand.nextInt(801),rand.nextInt(601)));
        }
        for (int i = 0; i <= animals.size() / 2; i++) {
            int x = rand.nextInt(animals.size());
            int y = rand.nextInt(animals.size());
            int r = rand.nextInt(food.size());
            if (x != y) {
                if (eat(animals.get(x), animals.get(y))) {
                    animals.remove(y);
                    continue;
                } else if (eat(animals.get(x), food.get(r)))
                    food.remove(r);
            }
            else
                i--;

    }
        for (Animal animal:animals){
            System.out.println(animal.toString());
        }
    }// end main().


}

