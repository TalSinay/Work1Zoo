package graphics;
/**
 * 'IAnimalBehavior' interface, used to give the same interface for all the animals type.

 * @version 24.4.22
 * @author Tal and Shoham
 * @see animals.Animal
 * */
public interface IAnimalBehavior {

    /**
     * getAnimalName method
     * @return the animal name.
     */
    public String getAnimalName();

    /**
     * getSize method
     * @return the animal size
     */
    public int getSize();

    /**
     * eatInc method, increase eat counter after meal
     */
    public void eatInc();

    /**
     * getEatCount method
     * @return the animal's eat counter
     */
    public int getEatCount();

    /**
     * getChanges
     * @return if the animal has changed
     */
    public boolean getChanges ();
    /**
     * setChange method
     * @param state the new state of coordChange.
     */
    public void setChanges (boolean state);
}
