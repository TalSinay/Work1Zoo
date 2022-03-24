package animals;
import diet.*;
import mobility.*;
public class Bear extends Animal{
    private String furColor;

    public Bear(String name) {
        super(name,new Point(100,5));
        this.furColor="GRAY";
        setDiet(new Herbivore());
        this.setweight(308.2);
    }
    public Bear(String name,Point p,String color) {
        super(name,p);
        this.furColor=color;
        setDiet(new Herbivore());
        this.setweight(308.2);
    }
    public void roar() {

    }
}
