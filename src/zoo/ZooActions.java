package zoo;
import animals.*;
import food.*;
import diet.*;
import mobility.*;
import java.util.Scanner;
import java.util.Random;
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

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        System.out.println("Enter amount of animals: (MINIMUM 3):");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(), choice;
        if (size < 3){size = 3;}
        Animal[] animals = new Animal[size];
        for(int i = 0; i < size; i++){
            System.out.println("Choose the Animal Type:\n1.Lion\n2.Bear\n3.Turtle\n4.Giraffe\n5.Elephant");
            sc = new Scanner(System.in);
            Point p;
            switch (sc.nextInt()){
                case 1:
                    System.out.println("Enter Lion's name");
                    sc = new Scanner(System.in);
                    animals[i] = new Lion(sc.nextLine());
                    System.out.println("Enter Lion's place");
                    sc = new Scanner(System.in);
                    p = new Point(sc.nextInt(), sc.nextInt());
                    // 'setLocation' will check if the point are available.
                    animals[i].setLocation(p);
                    System.out.println("Enter Lion's scars amount");
                    sc = new Scanner(System.in);
                    int scars = sc.nextInt();
                    animals[i].setValue(scars);
                    break;


                case 2:
                    System.out.println("Enter Bear's name");
                    sc = new Scanner(System.in);
                    animals[i] = new Bear(sc.nextLine());
                    System.out.println("Enter Bear's place");
                    sc = new Scanner(System.in);
                    p = new Point(sc.nextInt(), sc.nextInt());
                    // 'setLocation' will check if the point are available.
                    animals[i].setLocation(p);
                    System.out.println("Enter Bear's fur color");
                    sc = new Scanner(System.in);
                    String furColor = sc.nextLine();
                    animals[i].setValue(furColor);
                    break;

                case 3:
                    System.out.println("Enter turtle's name");
                    sc = new Scanner(System.in);
                    animals[i] = new Turtle(sc.nextLine());
                    System.out.println("Enter turtle's place");
                    sc = new Scanner(System.in);
                    p = new Point(sc.nextInt(), sc.nextInt());
                    // 'setLocation' will check if the point are available.
                    animals[i].setLocation(p);
                    System.out.println("Enter turtle's age");
                    sc = new Scanner(System.in);
                    int age = sc.nextInt();
                    animals[i].setValue(age);
                    break;

                case 4:
                    System.out.println("Enter Giraffe's name");
                    sc = new Scanner(System.in);
                    animals[i] = new Giraffe(sc.nextLine());
                    System.out.println("Enter Giraffe's place");
                    sc = new Scanner(System.in);
                    p = new Point(sc.nextInt(), sc.nextInt());
                    // 'setLocation' will check if the point are available.
                    animals[i].setLocation(p);
                    System.out.println("Enter Giraffe's neck length");
                    sc = new Scanner(System.in);
                    double neckLength = sc.nextDouble();
                    animals[i].setValue(neckLength);
                    break;
                case 5:
                    System.out.println("Enter Elephant's name");
                    sc = new Scanner(System.in);
                    animals[i] = new Elephant(sc.nextLine());
                    System.out.println("Enter Elephant's place");
                    sc = new Scanner(System.in);
                    p = new Point(sc.nextInt(), sc.nextInt());
                    // 'setLocation' will check if the point are available.
                    animals[i].setLocation(p);
                    System.out.println("Enter Elephant's trunk length");
                    sc = new Scanner(System.in);
                    int trunkLength = sc.nextInt();
                    animals[i].setValue(trunkLength);
                    break;
                default:
                    System.out.println("Bad Choice, try again");
                    i--;
                    break;
            }// end switch.
        }// end for loop.
        Random rand = new Random();
        for(Animal animal :animals){
            move(animal,new Point(rand.nextInt(801), rand.nextInt(601)));
        }

        //////////////////////////
        for(int i = 0; i< animals.length /2; i++){

        }
    }// end main().


}

