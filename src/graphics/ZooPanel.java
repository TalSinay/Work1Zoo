package graphics;
import plants.Plant;
import animals.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;

public class ZooPanel extends JPanel implements Runnable {
    private Plant p=null; //this will be the food i think(needs to talk about that).
    private BufferedImage img = null;

    public void run() {

    }
    public void manageZoo() {

        while (true) {
            if (isChange())
                repaint();


        }
    }

    public boolean isChange() {
        if (getCoordChanged()){
            return true;
        }
        return false;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g) ;
        if(img!=null)
            g.drawImage(img,0,0,getWidth(),getHeight(), this);


    }

}
