package animals;
import mobility.*;
import diet.*;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;

/**
 * 'Elephant' class, used to declare all the elephants in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see Animal
 * */
public class Giraffe extends chew{
    private double neckLength;
    /**
     * the giraffe constructor
     * @param name the giraffe name.
     */
    public Giraffe(String name) {
        super(name,new Point(50,0));
        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
        this.setWeight(450);
        this.setNeckLength(1.5);
        setDiet(new Herbivore());

    }
    /**
     * the giraffe constructor
     * @param name the giraffe name.
     * @param p the starts point.

     */
    public Giraffe(String name,Point p) {
        super(name,p);
        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
        this.setWeight(450);
        this.setNeckLength(1.5);
        setDiet(new Herbivore());
    }
    /**
     * the giraffe fully constructor
     * @param name the giraffe name.
     * @param p the starts point.
     * @param len the neck length.
     */
    public Giraffe(String name,Point p,double len) {
        super(name,p);
        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
        this.setWeight(450);
        this.setNeckLength(len);
        setDiet(new Herbivore());
    }
    /**
     * tnis method use to make the giraffe's sound.
     */
    public void chew() {
        MessageUtility.logSound(getName(), "Bleats and Stomps its legs, then chews");
    }

    /**
     * setNeckLength method- set the neck length of the giraffe.
     * @param len the new len.
     * @return true/ false.
     */
    public boolean setNeckLength(double len){

        boolean flag = false;
        if(len >= 1 && len <= 2.5) {
            neckLength = len;
            flag = true;
        }
        MessageUtility.logSetter(this.getName(),"setNeckLength",len,flag);
        return flag;
    }
    double getNeckLength(){
        return this.neckLength;
    }

    public void drawObject (Graphics g)
    {
        g.setColor(getCol());
        if(getX_dir()==1) // giraffe goes to the right side
            g.drawImage(this.getImg1(), this.getLocation().getx()-getSize()/2, this.getLocation().gety()-getSize()/10, getSize()/2, getSize(), getPan());
        else // giraffe goes to the left side
            g.drawImage(this.getImg2(), this.getLocation().getx(), this.getLocation().gety()-getSize()/10, getSize()/2, getSize(), getPan());
    }
//
//    /**
//     * overide method. use setNeckLength method
//     * @param value the new length
//     * @return true/ false.
//     */
//    @Override
//    public boolean setValue(double value) {
//        return setNeckLength(value);
//    }
}

