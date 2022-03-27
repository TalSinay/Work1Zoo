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
    public Bear(String name,Point p,String color) {
        super(name,p);
        this.furColor=color;
        setDiet(new Herbivore());
        this.setWeight(308.2);
    }

    /**
     * this method used to make the bear sound.
     */
    public void roar() {

    }
    public boolean setFurColor(String color){return true;}
}
