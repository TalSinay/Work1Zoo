package animals;
import mobility.*;
import diet.*;

public class Giraffe extends chew{
    private double neckLength;

    public Giraffe(String name) {
        super(name,new Point(50,0));
        this.neckLength=1.5;
        setDiet(new Herbivore());
        System.out.println("[+] new Giraffe: "+ name);
    }
    public Giraffe(String name,Point p,double len) {
        super(name,p);
        setDiet(new Omnivore());
        if (len>1 && len<2.5)
            this.neckLength=len;
        else
            this.neckLength=1.5;
        setDiet(new Herbivore());
        System.out.println("[+] new Giraffe: "+ name);
    }
    public void chew() {
        System.out.println("Bleats and Stomps its legs, then chews");
    }

    /**
     * setNeckLength method- set the neck length of the giraffe.
     * @param len the new len.
     * @return true/ false.
     */
    public boolean setNeckLength(double len){

        boolean flag = false;
        if(len >= 1 && len <= 2.5) {
            neckLength = len;
            flag = true;
        }
        System.out.print("[s] "+ getName() + "setNeckLength("+len+ ") => "+ flag);
        return flag;
    }

    /**
     * overide method. use setNeckLength method
     * @param value the new length
     * @return true/ false.
     */
    @Override
    public boolean setValue(double value) {
        return setNeckLength(value);
    }
}

