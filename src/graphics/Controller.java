package graphics;

public class Controller implements IObserver {
    private ZooPanel zoo=ZooPanel.getZoopanel();


    public void notify(boolean state) {
        if (state) {
            zoo.repaint();
            zoo.manageZoo();
        }
    }
}
