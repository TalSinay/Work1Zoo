package graphics;

import java.awt.*;

public interface IDrawable {

//    public final static String PICTURE_PATH = "C:\\Users\\moyal\\IdeaProjects\\Work1Zoo\\src\\assignment2_pictures";
    public final static String PICTURE_PATH = "D:\\User Files\\Desktop\\טל לימודים\\שנה ב סמסטר ב\\תכנות מונחה עצמים מתקדם\\עבודות הגשה\\עבודה 2_pictures\\assignment2_pictures";

    public void loadImages(String nm);
    public void drawObject (Graphics g);
    public String getColor();

}

