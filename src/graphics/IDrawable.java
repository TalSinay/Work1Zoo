package graphics;
import java.awt.*;
import java.io.IOException;
/**
 * 'IDrawable' interface, used to give the same drawing method for all the object type in zoo.
 * @version 24.4.22
 * @author Tal and Shoham
 * @see animals.Animal
 * */
public interface IDrawable {


    // public final static String PICTURE_PATH = "C:\\Users\\moyal\\IdeaProjects\\Work1Zoo\\assignment2_pictures";
   public final static String PICTURE_PATH = "C:\\Users\\USER\\IdeaProjects\\Work1Zoo\\assignment2_pictures";

    /**
     * loadImage method - try to load the object's photos from the file
     * @param nm the animal's code (name_1/2.png)
     * @exception IOException java.io.FileNotFoundException
     *
     */
    public void loadImages(String nm);
    /**
     * drawObject method
     * @param g Graphic Object to draw.
     */
    public void drawObject (Graphics g);
    /**
     * getColor method -
     * @return the object's color.
     */
    public String getColor();

}

