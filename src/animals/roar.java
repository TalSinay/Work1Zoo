package animals;

import mobility.Point;

public class roar  extends Animal{
    public roar(String name){
        super(name,new Point(20,0));
    }
    public void makeSound() {

        this.roar();
    }
    public roar(String name,Point p){
        super(name,p);
    }
    public abstract void roar();
}
