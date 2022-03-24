package mobility;

import animals.*;

public class Mobile {
    private Point location;
    private double totalDistance;

    public Mobile(Point p){
        this.location.setx(p.getx());
        this.location.sety(p.gety());
    }
    public double calcDistance(Point p) {
        return Math.sqrt((this.location.getx()-p.getx())*(this.location.getx()-p.getx())+(this.location.gety()-p.gety())*(this.location.gety()-p.gety()));
    }

    public double move(Point p) {
        this.location.setx(p.getx());
        this.location.sety(p.gety());
        this.totalDistance=this.totalDistance+ this.calcDistance(p);
        if(this instanceof Animal) {
            ((Animal)this).setweight(((Animal)this).getWeight()-(this.calcDistance(p)*((Animal)this).getWeight()*0.00025));
        }
        return this.calcDistance(p);
    }

    public void addTotalDistance(double num) {
        this.totalDistance=this.totalDistance+num;
    }
    public Point getLocation() {
        return this.location;
    }
    public boolean setLocation(Point p) {
        if (p.getx()<p.maxx && p.getx()>p.minx)
            if(p.gety()>p.miny &&p.gety()<p.maxy)
            {
                this.move(p);
                return true;
            }
        return false;

    }

}

