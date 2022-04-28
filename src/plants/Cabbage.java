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

	public String get_nm() {
		return "\\cabbage.png";
	}

	@Override
	public boolean setlocation(Point p) {
		return false;
	}

	@Override
	public String getColor() {
		return null;
	}
}
