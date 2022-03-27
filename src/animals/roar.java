package animals;

import mobility.*;

public abstract class roar  extends Animal{
    public roar(String name,Point p){
        super(name,p);
    }
    public void makeSound() {
        roar();
    }
    public abstract void roar();
}
