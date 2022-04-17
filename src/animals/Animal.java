package animals;
import diet.*;
import food.*;
import graphics.*;
import mobility.*;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 'Animal' class, used to declare all the animals in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see diet
 * */
public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior {
    private String name;
    private double weight;
    private IDiet diet;
    private final int EAT_DISTANCE = 10;
    private int size;
    private Color col;
    private int horSpeed;
    private int verSpeed;
    private boolean coordChanged=false;
    private Thread thread;
    private int x_dir=1;
    private int y_dir=1;
    private int eatCount=0;
    private ZooPanel pan;
    private BufferedImage img1, img2; // img1 to move right,img2 to move left.
    private static int TotalEatCount=0;

    /**
     * animal constructor.
     * @param name the given name (string).
     * @param location the given location (point).
     */
    public Animal(String name,Point location) {
        super(location);
        MessageUtility.logConstractor(super.getClass().getSuperclass().getSuperclass().getSimpleName(), name);
        this.setName(name);

    }

    /**
     * this method using to set the 'IDiet' interface in the animal's attribute
     * @param diet the interface.
     * @return return true.
     */
    public boolean setDiet(IDiet diet) {
        boolean flag = true;
        this.diet=diet;
        MessageUtility.logSetter(this.name, "setDiet", diet.toString(), flag);
        return true;
    }

    /**
     * 'get' method to get the animal's weight.
     * @return the animal's weight.
     */

    public double getWeight() {
        MessageUtility.logGetter(this.name, "getWeight", this.weight);
        return this.weight;
    }

    /**
     * set weight method, use for set new weight
     * @param x the new animal's weight.
     */
    public boolean setWeight(double x) {
        boolean flag = false;
        if(x > 0) {
            this.weight = x;
            flag = true;
        }
        MessageUtility.logSetter(this.name, "setWeight", x, flag);
        return true;
    }

    /**
     * set name method, use for set new name
     * @param  name  new animal's name.
     */
    public boolean setName(String name) {
        boolean flag = name != null;
        if(flag) {
            this.name = name;
            MessageUtility.logSetter(this.name, "setName", name, flag);

        }
        return flag;
    }

    /**
     * makeSound method- using to sort the animals sound.
     * check the animal's type and make the requirement sound.
     */
    public abstract void makeSound();// in roar or chew

    /**
     * method to get the animal's type of food.
     * (in that case- all animals will return MEAT.)
     * @return the animal's type.
     */
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getName(), "getFoodType", this instanceof Lion ? EFoodType.NOTFOOD: EFoodType.MEAT);
        return EFoodType.MEAT;
    }
    // to get the animal's name.

    /**
     * eat method - method for the animals to eat.
     * set a new weight after eats.
     * return true/ false if he ate successfully.
     * @param food the food.(IEdible)
     * @return true/ false.
     */
    public boolean eat(IEdible food) {
        double y=diet.eat(this, food);
        boolean flag = y>0;
        if (flag) {
            this.setWeight(this.weight+y);
        }
        String v=food instanceof Animal ?"\t"+((Animal) food).getName():"";
        String s="["+food.getClass().getSimpleName()+"]"+v;
        MessageUtility.logBooleanFunction(this.name, "eat", s , flag);
        this.makeSound();
        return flag;
    }


    /**
     * getName method.
     * @return the object's name.
     */
    public String getName(){
        return name;
    }

    /**
     * getDiet method
     * @return the object's diet.
     */
    public IDiet getDiet() {
        return diet;
    }

    /**
     * toString method (override)
     * @return return the object's details in a String format.
     */
    public String toString(){
        return "[!] ["+this.getClass().getSimpleName()+"] "+this.name+" total distance: ["+this.getTotalDistance()+"],weight: ["+this.weight+"]";
    }

    @Override
    public void drawObject(Graphics g) {

    }

    public boolean getCoordChanged() {
        return this.coordChanged;
    }
    public Color getCol(){return this.col;}
    public int getX_dir(){return this.x_dir;}
    public int getY_dir(){return this.y_dir;}
    public int getSize(){return this.size;}
    public ZooPanel getPan(){return this.pan;}
    public BufferedImage getImg1(){return this.img1;}
    public BufferedImage getImg2(){return this.img2;}
    public void IncEatcount(){
        this.eatCount=this.eatCount+1;
        TotalEatCount=TotalEatCount+1;
    }



}

