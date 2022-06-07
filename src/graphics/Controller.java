package graphics;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
    private ZooPanel zoo;

    public Controller(ZooPanel zoo){
        zoo=zoo;
    }

    @Override
    public void update(Observable o, Object arg) {
        zoo.manageZoo();
    }
}
