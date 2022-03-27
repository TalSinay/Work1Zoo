package animals;

import mobility.Point;

public abstract class chew  extends Animal{
    public chew(String name, Point p){
        super(name,p);
    }
    public void makeSound() {
        chew();
    }
    public abstract void chew();
}