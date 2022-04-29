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

    public Point(){
        this(0,0);
    }
    /**
     *Point constructor.
     * @param x x axis value
     * @param y y axis value
     */

    public Point(int x,int y) {
            this.x = x;
            this.y = y;
    }

    /**
     * setx method - using to give an api to change the x value of point.
     * @param x the new value.
     * @return true/ false.
     */
    public boolean setx(int x) {
        if (x <= getmaxX() && x >= getminx()) {
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
        if (y <= getmaxy() && y >= getminy()) {
            this.y = y;
            return true;
        }
        return false;
    }

    /**
     * method to check if the point is in the board
     * @param p the given point
     * @return boolean
     */
    public static boolean cheackBounderies(Point p){
        return(p.getx()>=getminx() && p.getx()<= getmaxX() && p.gety()>=getminy() && p.gety() <= getmaxy());
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
    public static int getmaxX() {
        return maxx;
    }
    /**
     * getminX method
     * @return the min value in the x axis
     */
    public static int getminx() {
        return minx;
    }
    /**
     * getmaxY method
     * @return the max value in the y axis
     */
    public static int getmaxy() {
        return maxy;
    }
    /**
     * getminY method
     * @return the min value in the y axis
     */
    public static int getminy() {
        return miny;
    }

    /**
     * toString - override method.
     * @return the point in a custom String format.
     */
    public String toString(){
        return "("+ getx() + ", " + gety() + ")";
    }
}
