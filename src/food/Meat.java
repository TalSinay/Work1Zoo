package food;

import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static graphics.IDrawable.PICTURE_PATH;

public class Meat implements IEdible , IDrawable {

    private double height;
    /**
     *
     */
    private Point location;
    /**
     *
     */
    private double weight;
    private String col;
    private BufferedImage img;
    private ZooPanel pan;

    /**
     *
     */
    public Meat() {
        Random rand = new Random();

        this.location = new Point(400, 300);
        this.height = rand.nextInt(30);
        this.weight = rand.nextInt(12);
        loadImages(get_nm());
    }
    public Point getlocation(){return location;}

    public String get_nm() {
        return "\\meat.gif";
    }


    public void loadImages(String nm) {
        try {
            img = ImageIO.read(new File(PICTURE_PATH + nm));

        } catch (IOException e) {
            System.out.println("Shit");
        }
    }

    @Override
    public EFoodType getFoodtype() {
        return EFoodType.MEAT;
    }
    public void drawObject(Graphics g)
    {
        g.drawImage(this.img,400, 300, 25, 25, pan);
    }

    @Override
    public String getColor() {
        return col;
    }

}
