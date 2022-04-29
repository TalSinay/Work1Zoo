package plants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import graphics.ZooPanel.*;
import food.EFoodType;
import food.IEdible;
import graphics.*;
import mobility.ILocatable;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;

/**
 * 'Plant' class, used to declare all the plants in the zoo.
 * @version 24.4.22
 * @author Tal and Shoham
 * @see IEdible
 * @see IDrawable
 * @see ILocatable
 * */
public abstract class Plant implements IEdible, ILocatable, IDrawable {
	private double height;
	private Point location;
	private double weight;
	private String col;
	private BufferedImage img;
	private ZooPanel pan;

	/**
	 * Plant constructor.
	 */
	public Plant() {
		Random rand = new Random();

		this.location = new Point(400, 300);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		loadImages(get_nm());
		MessageUtility.logConstractor("Plant", "Plant");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see food.IFood#getFoodtype()
	 */
	@Override
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		return EFoodType.VEGETABLE;
	}

	/**
	 * get height method
	 * @return the height
	 */
	public double getHeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
		return this.height;
	}

	/**
	 * getlocation method.
	 * 
	 * @see mobility.ILocatable#getlocation()
	 */
	public Point getLocation() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
		return this.location;
	}

	/**
	 * get weight method
	 * @return return the weight.
	 */
	public double getWeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
		return weight;
	}

	/**
	 * setHeight method
	 * @param height the new height
	 * @return boolean
	 */
	public boolean setHeight(double height) {

		boolean isSuccess = (height >= 0);
		if (isSuccess) {
			this.height = height;
		} else {
			this.height = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
		return isSuccess;
	}

	/**
	 * set location method
	 * @param newLocation the new location.
	 * @see mobility.ILocatable#setlocation(mobility.Point)
	 */
	@Override
	public boolean setlocation(Point newLocation) {
		boolean isSuccess = Point.cheackBounderies(newLocation);
		if (isSuccess) {
			this.location = newLocation;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
		return isSuccess;
	}

	/**
	 * set weight method
	 * @param weight the new weight
	 * @return boolean
	 */
	public boolean setWeight(double weight) {
		boolean isSuccess = (weight >= 0);
		if (isSuccess) {
			this.weight = weight;
		} else {
			this.weight = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

		return isSuccess;
	}

	/**
	 * toString - override method
	 * @return the object in a String format.
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}

	/**
	 * getlocation method
	 * @return the object's location
	 */
	public Point getlocation(){return location;}

	/**
	 * loadImage method - try to load the object's photos from the file
	 * @param nm the animal's code (name_1/2.png)
	 * @exception IOException java.io.FileNotFoundException
	 *
	 */
	public void loadImages(String nm){
		try {
			img = ImageIO.read(new File(PICTURE_PATH + nm));

		}
		catch(IOException e) {
			System.out.println("Shit");
		}
	}
	/**
	 * drawObject method
	 * @param g Graphic Object to draw.
	 */
	public void drawObject(Graphics g)
	{
		g.drawImage(this.img,400, 300, 25, 25, pan);
	}
	/**
	 * get_nm method
	 * @return the name of the plant in the files.
	 */
	public String get_nm() {
		return "Plant";
	}

}
