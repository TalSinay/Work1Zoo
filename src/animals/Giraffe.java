package animals;
import mobility.*;
import diet.*;
import utilities.MessageUtility;

public class Giraffe extends chew{
    private double neckLength;

    public Giraffe(String name) {
        super(name,new Point(50,0));
        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
        this.setWeight(450);
        this.setNeckLength(1.5);
        setDiet(new Herbivore());

    }
    public Giraffe(String name,Point p,double len) {
        super(name,p);
        MessageUtility.logConstractor(this.getClass().getSimpleName(),name);
        this.setWeight(450);
        if (len>1 && len<2.5)
            this.setNeckLength(len);
        else
            this.setNeckLength(1.5);
        setDiet(new Herbivore());

    }
    public void chew() {
        MessageUtility.logSound(getName(), "Bleats and Stomps its legs, then chews");
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
        MessageUtility.logSetter(this.getName(),"setNeckLength",len,flag);
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

