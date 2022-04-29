package animals;
import diet.*;
import food.*;
import graphics.*;
import mobility.*;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    private String col;
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
     *
     * @param p the given location (Point).
     * @param size the given size (int).
     * @param ver the given vertical speed (int).
     * @param hor the given horizontal speed (int).
     * @param color the given color (String).
     * @param weight the given  weight (double).
     * @param pan the given  panel (ZooPanel).
     */
    public Animal(Point p, int size, int ver, int hor, String color, double weight, ZooPanel pan){
        super(p);
        this.size = size;
        this.verSpeed = ver;
        this.horSpeed = hor;
        this.col = color;
        this.weight = weight;

        this.pan = pan;
        coordChanged = true;

    }

    /**
     * this method using to set the 'IDiet' interface in the animal's attribute
     * @param diet the interface.
     * @return return true.
     */
    public boolean setDiet(IDiet diet) {
        boolean flag = true;
        this.diet=diet;
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setDiet", diet.toString(), flag);
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
        MessageUtility.logGetter(this.getAnimalName(), "getFoodType", this instanceof Lion ? EFoodType.NOTFOOD: EFoodType.MEAT);
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
        String v=food instanceof Animal ?"\t"+((Animal) food).getAnimalName():"";
        String s="["+food.getClass().getSimpleName()+"]"+v;
        MessageUtility.logBooleanFunction(this.name, "eat", s , flag);
        this.makeSound();
        return flag;
    }


    /**
     * getAnimalName method.
     * @return the object's name.
     *
     */
    public String getAnimalName(){
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
        return "[!] ["+this.name+"] "+" weight: ["+this.weight+"], color: ["+this.getColor()+"]";
    }

    /**
     * drawObject method
     * @param g Graphic Object to draw.
     */
    public void drawObject(Graphics g)
    {
        if(getX_dir()==1) // giraffe goes to the right side

            g.drawImage(this.getImg1(), this.getLocation().getx()-getSize()/2, this.getLocation().gety()-getSize()/10, getSize()/2, getSize(), getPan());
        else // giraffe goes to the left side
            g.drawImage(this.getImg2(), this.getLocation().getx(), this.getLocation().gety()-getSize()/10, getSize()/2, getSize(), getPan());
    }


    /**
     * getName method.
     * @return the object's name.
     *
     */
    public String getName() {
        return name;
    }

    /**
     * getX_dir method
     * @return the x_dir data member
     */
    public int getX_dir(){return this.x_dir;}
    /**
     * getY_dir method
     * @return the y_dir data member
     */
    public int getY_dir(){return this.y_dir;}

    /**
     * getSize method
     * @return the animal's size.
     */
    public int getSize(){return this.size;}

    /**
     * getPan method
     * @return the animal's panel
     */
    public ZooPanel getPan(){return this.pan;}

    /**
     * getImg1 method
     * @return the image of the animal walking right
     */
    public BufferedImage getImg1(){return this.img1;}

    /**
     * getImg2 method
     * @return the image of the animal walking left
     */
    public BufferedImage getImg2(){return this.img2;}

    /**
     * IncEatcount method - increase the eatCount by one.
     */
    public void IncEatcount(){
        this.eatCount=this.eatCount+1;
        TotalEatCount=TotalEatCount+1;
    }

    /**
     * loadImage method - try to load the animal's photos from the file
     * @param nm the animal's code (name_1/2.png)
     * @exception IOException java.io.FileNotFoundException
     *
     */
    public void loadImages(String nm){
        try {
            img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm +"_1.png"));
            img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "\\" + nm +"_2.png"));
        }
        catch(IOException e) {
            System.out.println("Shit");
        }
    }

    /**
     * getColor method -
     * @return the animal's color.
     */
    public String getColor(){
        return this.col;
    }

    /**
     * eatInc method.
     * increase eat count.
     */
    public void eatInc(){

    }

    /**
     * getEatCount
     * @return the eatCounter.
     */
    public int getEatCount(){
        return this.eatCount;
    }

    /**
     * getChanges
     * @return if the animal has changed
     */
    public boolean getChanges (){
        return this.coordChanged;
    }

    /**
     * setChange method
     * @param state the new state of coordChange.
     */
    public void setChanges (boolean state){

    }

    /**
     * get_nm method
     * @return the name of the animal in the files.
     */
    public String get_nm(){return "Animal";}

    /**
     * getHorSpeed
     * @return the hor speed.
     */
    public int getHorSpeed(){return horSpeed;}
    /**
     * getVerSpeed
     * @return the ver speed.
     */
    public int getVerSpeed(){return verSpeed;}
    /**
     * getEatCounter
     * @return the eat counter.
     */
    public int getEatCounter(){return eatCount;}
}

