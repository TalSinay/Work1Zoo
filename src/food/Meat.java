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
        int x = rand.nextInt(30);
        int y = rand.nextInt(12);
        this.location = new Point(x, y);
        this.height = rand.nextInt(30);
        this.weight = rand.nextInt(12);
        loadImages(get_nm());
    }
    public Point getlocation(){return location;}

    public String get_nm() {
        return "\\meat.png";
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
        g.drawImage(this.img,300, 400, 25, 25, pan);
    }

    @Override
    public String getColor() {
        return col;
    }

}
