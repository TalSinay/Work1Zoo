package plants;

import mobility.Point;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {
	public Cabbage() {
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}



	@Override
	public boolean setlocation(Point p) {
		return false;
	}
}
