package mobility;
/**
 * Point class

 * @version 24.3.22
 * @author Tal and Shoham

 * */
public class Point {
    private int x,y;
    /**
     * the limits.
     */
    private static final int minx=0;
    private static final int maxx=800;
    private static final int miny=0;
    private static final int maxy=600;

    /**
     *Point constructor.
     * @param x x axis value
     * @param y y axis value
     */
    public Point(int x,int y) {
        this.x=x;
        this.y=y;
    }

    /**
     * setx method - using to give an api to change the x value of point.
     * @param x the new value.
     * @return true/ false.
     */
    public boolean setx(int x) {
        if (x < getmaxX() && x > getminx()) {
            this.x = x;
            return true;
        }
        return false;
    }

    /**
     * sety method - using to give an api to change the y value of point.
     * @param y the new value.
     * @return true/ false.
     */
    public boolean sety(int y) {
        if (y < getmaxy() && y > getminy()) {
            this.y = y;
            return true;
        }
        return false;
    }

    /**
     * getx method
     * @return the x value of point
     */
    public int getx() {
        return this.x;
    }
    /**
     * gety method
     * @return the y value of point
     */
    public int gety() {
        return this.y;
    }

    /**
     * getmaxX method
     * @return the max value in the x axis
     */
    public int getmaxX() {
        return this.maxx;
    }
    /**
     * getminX method
     * @return the min value in the x axis
     */
    public int getminx() {
        return this.minx;
    }
    /**
     * getmaxY method
     * @return the max value in the y axis
     */
    public int getmaxy() {
        return this.maxy;
    }
    /**
     * getminY method
     * @return the min value in the y axis
     */
    public int getminy() {
        return this.miny;
    }

}
