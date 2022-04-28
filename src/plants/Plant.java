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
 * @author baroh
 *
 */
public abstract class Plant implements IEdible, ILocatable, IDrawable {
	/**
	 * 
	 */
	private double height;
	/**
	 * 
	 */
	private Point location;
	/**
	 * 
	 */
	private double weight;
	private String col;
	private BufferedImage img;
	private ZooPanel pan;

	/**
	 * 
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
	 * @return
	 */
	public double getHeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#getLocation()
	 */
	public Point getLocation() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
		return this.location;
	}

	/**
	 * @return
	 */
	public double getWeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
		return weight;
	}

	/**
	 * @param height
	 * @return
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#setLocation(mobility.Point)
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
	 * @param weight
	 * @return
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}

	public Point getlocation(){return location;}

	public void loadImages(String nm){
		try {
			img = ImageIO.read(new File(PICTURE_PATH + nm));

		}
		catch(IOException e) {
			System.out.println("Shit");
		}
	}
	public void drawObject(Graphics g)
	{
		g.drawImage(this.img,400, 300, 25, 25, pan);
	}

	public String get_nm() {
		return "Plant";
	}

}
