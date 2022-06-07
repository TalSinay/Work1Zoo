package food;
/**
 * 'Meat' class, used to declare all the meat objects in the zoo.
 * @version 29.4.22
 * @author Tal and Shoham
 * @see food.IEdible
 * */

import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Point;
import plants.Plant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static graphics.IDrawable.PICTURE_PATH;

public class Meat implements IEdible , IDrawable {

    private double height;
    private double weight;
    private String col;
    private ZooPanel pan;
    private Point location;
    private BufferedImage img;
    private static Meat meat=null;


    /**
     * Meat default Constructor.
     */
    private Meat() {
        Random rand = new Random();

        this.location = new Point(400, 300);
        this.height = rand.nextInt(30);
        this.weight = rand.nextInt(12);
        loadImages(get_nm());
    }


    public static Meat getMeat() {
        if (meat == null) {
            synchronized (Meat.class) {
                if (meat == null) {
                    meat = new Meat();
                }
            }
        }
        return meat;
    }


        /**
         * getloction method.
         * @return the location of meat.
         */
    public Point getlocation(){return location;}
    /**
     * get_nm method
     * @return the name of the meat in files.
     */
    public String get_nm() {
        return "\\meat.gif";
    }

    /**
     * loadImage method - try to load the meat's photos from the file
     * @param nm the meat's code (\\meat.gif)
     * @exception IOException java.io.FileNotFoundException
     *
     */
    public void loadImages(String nm) {
        try {
            img = ImageIO.read(new File(PICTURE_PATH + nm));

        } catch (IOException e) {
            System.out.println("Shit");
        }
    }

    /**
     * getFoodtype - method to get the food's type.
     * @return food's type.
     */
    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }
    /**
     * drawObject method
     * @param g Graphic Object to draw.
     */
    public void drawObject(Graphics g)
    {
        g.drawImage(this.img,400, 300, 25, 25, pan);
    }

    /**
     * getColor method -
     * @return the color.
     */
    @Override
    public String getColor() {
        return col;
    }

}
