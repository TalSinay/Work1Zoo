package mobility;
/**
 * 'ILocatable' interface, used to give a way to know the location of objects.

 * @version 24.3.22
 * @author Tal and Shoham
 * @see {Point}
 * */
public interface ILocatable {
    /**
     * getLocation method- return the current location of the object
     * @return the object's location.
     */
    public Point getlocation();

    /**
     * set the object's location.
     * @param p the location.
     * @return true/ false.
     */
    public boolean setlocation(Point p);

}
