package mobility;

import animals.*;
import diet.Carnivore;
import food.EFoodType;
import food.Meat;
import plants.Plant;
import utilities.MessageUtility;

import java.util.Observable;

/**
 * Mobile class, declare location and total distance of objects.

 * @version 24.3.22
 * @author Tal and Shoham
 * @see Point
 * */
public class Mobile extends Observable {
    private Point location = new Point();
    private double totalDistance;

    /**
     * Mobile constructor.
     * @param p (Point)
     */
    public Mobile(Point p){
        super();
        if(Point.cheackBounderies(p)){
            this.location.setx(p.getx());
            this.location.sety(p.gety());
            this.totalDistance=0;
        }

    }


    /**
     * calc the distance between two points, using the distance law.
     * @param p the second point.
     * @return the distance.
     */
    public double calcDistance(Point p) {
        double x=this.location.getx()-p.getx();
        double y=this.location.gety()-p.gety();
        return Math.sqrt(x*x+y*y);
    }

    /**
     * move method, moving object from one point to the second.(if it possible)
     * @param p (Point)
     * @return the distance of this travel.
     */
    public double move(Point p) {
        boolean flag = false;
        if(Point.cheackBounderies(p)) {
            flag = true;
            addTotalDistance(calcDistance(p));
            double distance = calcDistance(p);
            this.location.setx(p.getx());
            this.location.sety(p.gety());
            if (this instanceof Animal) {
                double x = ((Animal) this).getWeight() - (distance * ((Animal) this).getWeight() * 0.00025);
                ((Animal) this).setWeight(x);
                MessageUtility.logBooleanFunction(((Animal) this).getName(), "move", p.toString(), flag);
            }
            setChanged();
            //notifyObservers();
            return this.calcDistance(p);
        }
        return 0;
    }

    public void change_direction(EFoodType f) {
        if(this instanceof Animal) {
            if(((Animal) this).getDiet().canEat(f)) {
                if (this.getLocation().getx() < 400 && ((Animal) this).getX_dir() == -1) {
                    ((Animal) this).setX_dir(1);

                }
                if (this.getLocation().gety() < 300 && ((Animal) this).getY_dir() == -1) {
                    ((Animal) this).setY_dir(1);
                }
                if (this.getLocation().getx() > 400 && ((Animal) this).getX_dir() == 1) {
                    ((Animal) this).setX_dir(-1);
                }
                if (this.getLocation().gety() > 300 && ((Animal) this).getY_dir() == 1) {
                    ((Animal) this).setY_dir(-1);
                }
            }
        }
    }

    /**
     * addTotalDistance- using to increase the total distance.
     * @param num the additional distance.
     */
    public void addTotalDistance(double num) {
        this.totalDistance=this.totalDistance+num;
    }

    /**
     * getLocation method
     * @return the current location of object.
     */
    public Point getLocation() {
        return this.location;
    }

    /**
     * setLocation method- set a new point (when moving).
     * @param p (Point) the destination
     * @return true/ false.
     */
    public boolean setLocation(Point p) {
        if (p.getx()<p.getmaxX() && p.getx()>p.getminx())
            if(p.gety()>p.getminy() &&p.gety()<p.getmaxy())
            {
                this.move(p);
                return true;
            }
        return false;

    }

    /**
     * getTotalDistance method.
     * @return the totalDistance the animals moved.
     */
    public double getTotalDistance() {
        return totalDistance;
    }
}

