package plants;

import utilities.MessageUtility;

/**
 * 'Lettuce' class, used to declare all the Cabbage in the zoo.
 * @version 24.4.22
 * @author Tal and Shoham
 * @see Plant
 * */
public class Lettuce extends Plant {
	/**
	 * Lettuce constructor
	 */
	public Lettuce() {
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}
	/**
	 * getColor method -
	 * @return the Lettuce's color.
	 */
	@Override
	public String getColor() {
		return null;
	}
	/**
	 * get_nm method
	 * @return the name of the lettuce in the files.
	 */
	public String get_nm() {
		return "\\lettuce.png";
	}
}
