package animals;
import mobility.*;
import diet.*;
import food.EFoodType;
/**
 * 'Lion' class, used to declare all the lions in the zoo.
 * @version 24.3.22
 * @author Tal and Shoham
 * @see {Animal}
 * */
public class Lion extends roar {
    private int scarCount=0;

    /**
     * Lion constructor(one parameter).
     *
     * @param name the lion's name.
     */
    public Lion(String name) {
        super(name,new Point(20,0));
        setDiet(new Carnivore());
        scarCount = 0;
        this.setWeight(408.2);
        System.out.println("[+] new Lion: "+ name);
    }

    /**
     * Lion constructor.
     * @param name the lion's name.
     * @param p the lion's location.
     */
    public Lion(String name,Point p) {
        super(name,p);
        setDiet(new Carnivore());
        scarCount = 0;
        this.setWeight(408.2);
        System.out.println("[+] new Lion: "+ name);
    }

    /**
     * this methos is using to make the lion's sound.
     */
    public void roar() {
        System.out.println("Roars, then stretches and shakes its mane");
    }

    /**
     * this method sets the amount of scars of the lion
     * @param scars the new amount of scars
     * @return true.
     */
    public boolean setScarCount(int scars){
        boolean flag = false;
        if(scars > 0) {
            scarCount = scars;
            flag = true;
        }
        System.out.print("[s] "+ getName() + "setScarCount("+scars+ ") => "+ flag);
        return flag;
    }

    /**
     * override method. use setScarCount.
     * @param scars amount of scars
     * @return true
     */
    @Override
    public boolean setValue(int scars){
        return setScarCount(scars);
    }
    /**
     * {@see Animal}, override the base class method to return the right type.
     * (only lions get this type)
     *
     * @return NOTFOOD (EFoodType).
     */
    @Override
    public EFoodType getFoodtype() {
        return EFoodType.NOTFOOD;
    }
}
