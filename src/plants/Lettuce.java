package plants;

import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {
	public Lettuce() {
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}

	@Override
	public void loadImages(String nm) {

	}

	@Override
	public String getColor() {
		return null;
	}
	public String get_nm() {
		return "\\lettuce.png";
	}
}
