package animals;
import diet.*;
import mobility.*;

/**
 * 'Bear' class, used to declare all the bears in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see {Animal}
 * */
public class Bear extends roar{
    private String furColor;

    /**
     * constructor with only one argument.
     * @param name the bear's name.
     */
    public Bear(String name) {
        super(name,new Point(100,5));
        this.furColor="GRAY";
        setDiet(new Herbivore());
        this.setWeight(308.2);
    }

    /**
     * 'Bear' constructor.
     * @param name the bear's name.
     * @param p the bear's location.
     * @param color the bear's fur color.
     */
    public Bear(String name,Point p) {
        super(name,p);
        this.furColor="GRAY";
        setDiet(new Herbivore());
        this.setWeight(308.2);
    }

    /**
     * this method used to make the bear sound.
     */
    public void roar() {
        System.out.println("Stands on its hind legs, roars and scratches its belly");
    }

    /**
     * setFurColor method - set the fur color of the bear.
     * @param color the new color
     * @return true/ false.
     */
    public boolean setFurColor(String color){
        if(color.equals("BLACK")||color.equals("WHITE")||color.equals("GRAY")){
            furColor = color;
        }
        return true;
    }

    /**
     * setValue - override method from Animal class. this method use setFurColor.
     * @param color new color.
     * @return true/ false
     */
    @Override
    public boolean setValue(String color){
        return setFurColor(color);
    }
}
