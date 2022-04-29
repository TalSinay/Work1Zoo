package plants;

import mobility.Point;
import utilities.MessageUtility;

/**
 * 'Cabbage' class, used to declare all the Cabbage in the zoo.
 * @version 24.4.22
 * @author Tal and Shoham
 * @see Plant
 * */
public class Cabbage extends Plant {
	/**
	 * cabbage constructor.
	 */
	public Cabbage() {
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}

	/**
	 * get_nm method
	 * @return the name of the cabbage in the files.
	 */
	public String get_nm() {
		return "\\cabbage.png";
	}

	/**
	 * set location method
	 * @param p the new location
	 * @return boolean
	 */
	@Override
	public boolean setlocation(Point p) {
		return false;
	}

	/**
	 * getColor method -
	 * @return the animal's color.
	 */
	@Override
	public String getColor() {
		return null;
	}
}
