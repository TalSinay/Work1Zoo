package mobility;

import animals.*;

/**
 * Mobile class, declare location and total distance of objects.

 * @version 24.3.22
 * @author Tal and Shoham
 * @see {Point}
 * */
public class Mobile {
    private Point location;
    private double totalDistance;

    /**
     * Mobile constructor.
     * @param p (Point)
     */
    public Mobile(Point p){
        this.location.setx(p.getx());
        this.location.sety(p.gety());
    }

    /**
     * calc the distance between two points, using the distance law.
     * @param p the second point.
     * @return the distance.
     */
    public double calcDistance(Point p) {
        return Math.sqrt((this.location.getx()-p.getx())*(this.location.getx()-p.getx())+(this.location.gety()-p.gety())*(this.location.gety()-p.gety()));
    }

    /**
     * move method, moving object from one point to the second.(if it possible)
     * @param p (Point)
     * @return the distance of this travel.
     */
    public double move(Point p) {
        this.location.setx(p.getx());
        this.location.sety(p.gety());
        this.totalDistance=this.totalDistance+ this.calcDistance(p);
        if(this instanceof Animal) {
            ((Animal)this).setWeight(((Animal)this).getWeight()-(this.calcDistance(p)*((Animal)this).getWeight()*0.00025));
        }
        return this.calcDistance(p);
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

}

