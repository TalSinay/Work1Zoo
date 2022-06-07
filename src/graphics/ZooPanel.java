package graphics;
import food.EFoodType;
import food.Meat;
import mobility.Point;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;
import animals.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;

/**
 * 'ZooPanel' class, used to declare the panel of the zoo, using ActionListener.
 * @version 29.4.22
 * @author Tal and Shoham
 * @see JPanel
 * @see Runnable
 * @see ActionListener
 * @see Animal
 * */
public class ZooPanel extends JPanel implements Runnable, ActionListener {
    public static ZooPanel zoo=null;
    private BufferedImage img = null;
    private Button Add;
    private Button Sleep;
    private Button WakeUp;
    private Button Clear;
    private Button Food;
    private Button Info;
    private Button Exit;
    private Button colorBottun;
    private Button save;
    private Button back;
    private JDialog addAnimalDialog;
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private Plant plant;
    private Meat meat;
    private JPanel panel;
    private ArrayList<Object> foods = new ArrayList<Object>();
    private Controller controller;
    private boolean flag = true;
    private Observer observer;

    /**
     * ZooPanel constructor.
     */
    public ZooPanel() {
        this.setSize(800, 600);
        Add = new Button("Add Animal");
        Sleep = new Button("Sleep");
        WakeUp = new Button("Wake up");
        Clear = new Button("Clear");
        Food = new Button("Food");
        Info = new Button("Info");
        Exit = new Button("Exit");
        save = new Button("Save");
        back = new Button("Back");
        colorBottun = new Button("Color");

        Add.setBackground(Color.WHITE);
        colorBottun.setBackground(Color.WHITE);
        back.setBackground(Color.WHITE);
        save.setBackground(Color.WHITE);
        Sleep.setBackground(Color.WHITE);
        WakeUp.setBackground(Color.WHITE);
        Clear.setBackground(Color.WHITE);
        Food.setBackground(Color.WHITE);
        Info.setBackground(Color.WHITE);
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        Add.addActionListener(this);
        colorBottun.addActionListener(this);
        back.addActionListener(this);
        save.addActionListener(this);
        Sleep.addActionListener(this);
        WakeUp.addActionListener(this);
        Clear.addActionListener(this);
        Food.addActionListener(this);
        Info.addActionListener(this);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 25));
        panel.add(Add);
        panel.add(Sleep);
        panel.add(colorBottun);
        panel.add(save);
        panel.add(back);
        panel.add(WakeUp);
        panel.add(Clear);
        panel.add(Food);
        panel.add(Info);
        panel.add(Exit);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 2));
        panel.setBackground(Color.BLUE);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.PAGE_END);
        Observer observer=new Controller(this);
       //controller
        this.manageZoo();

    }

    public static ZooPanel getZoopanel() {
        if (zoo == null) {
            synchronized (ZooPanel.class) {
                if (zoo == null) {
                    zoo = new ZooPanel();
                }
            }
        }
        return zoo;

    }


//    public Thread getController() {
//        return controller;
//    }

    /**
     * run the ZooPanel's controller (thread)
     */
    public void run() {
        while (true)
            manageZoo();


    }

    /**
     * manageZoo method - repaint all the objects in the zoo.
     */
    public void manageZoo() {

        if (isChange())
            repaint();
        if (animals.size() > 0) {
            synchronized (this) {
                for (int i = 0; i < animals.size(); i++) {

                    if (meat != null) {
                        if (animals.get(i).calcDistance(meat.getlocation()) <= 10 && animals.get(i).calcDistance(meat.getlocation()) <= 10) {
                            if (animals.get(i).eat(meat)) {
                                this.callback(animals.get(i));
                                animals.get(i).notifyObservers();
                                meat = null;
                                repaint();
                            }
                        }
                    }
                    if (plant != null) {
                        if (animals.get(i).calcDistance(plant.getlocation()) <= 10 && animals.get(i).calcDistance(plant.getlocation()) <= 10) {
                            if (animals.get(i).eat(plant)) {
                                this.callback(animals.get(i));
                                animals.get(i).notifyObservers();
                                plant = null;
                                repaint();
                            }
                        }
                    }
                }
            }
        }


        if ((animals.size() > 1)) {
            boolean flag = false;
            synchronized (this) {
                for (int i = 0; i < animals.size(); i++) {
                    synchronized (animals.get(i)) {
                        for (int j = 0; j < animals.size(); j++) {
                            synchronized (animals.get(j)) {
                                if (!(animals.get(i).equals(animals.get(j)))) {
                                    if (animals.get(i).getWeight() > animals.get(j).getWeight() * 2 && animals.get(i).calcDistance(animals.get(j).getLocation()) < animals.get(j).getSize()) {
                                        if (animals.get(i).eat(animals.get(j))) {
                                            if (i > j)
                                                i--;
                                            flag = true;
                                            //foodAnimal.setSuspended();
                                            animals.get(j).setAlive(false);
                                            animals.remove(animals.get(j));
                                            animals.get(i).IncEatcount();
                                            animals.get(i).notifyObservers();
                                            return;
                                        }
                                    }
                                }
                            }
                        }
//                        if (flag)
//                            break;
                    }

                }
            }
            repaint();
        }
    }


    /**
     * isChange method, checks if some object moved.
     *
     * @return boolean
     */
    public boolean isChange() {
        for (Animal animal : animals) {
            if (animal.getChanges()) {

                animal.setChanges(false);
                return true;
            }
        }
        return false;
    }

    /**
     * paintComponent method
     *
     * @param g the panel we want to draw in.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (animals.size() > 0) {
            synchronized (this) {
                for (Animal animal : animals) {
                    animal.drawObject(g);
                }
            }
        }
        if (plant != null)
            plant.drawObject(g);
        //need to call drawObject()
        if (meat != null)
            meat.drawObject(g);
    }

    /**
     * increase the animal's EatCount
     *
     * @param animal the animal that ate.
     */
    public void callback(Animal animal) {
        animal.IncEatcount();
    }

    /**
     * actionPerformed override method.
     *
     * @param e the interaction between the user to the system.
     * @throws IOException java.io.FileNotFoundException
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Add) {

            new AddAnimalDialog(this, animals,observer);
            repaint();

        }
        if (e.getSource() == Sleep) {
            for (Animal animal : animals) {
                animal.setFlag1(false);
            }
            repaint();
        }
        if (e.getSource() == WakeUp) {
            synchronized (this) {
                for (Animal an : animals) {
                    an.setFlag1(true);
                    repaint();
                }
            }

        }
        if (e.getSource() == Clear) {

            if (animals.size() > 0) {
                synchronized (this) {
                    for (int i = 0; i < animals.size(); i++) {
                        animals.get(0).setAlive(false);
                        animals.get(0).notifyObservers();
                        animals.remove(0);
                        repaint();
                    }
                }
            }
            if (foods.size() > 0) {
                for (int i = 0; i <= foods.size(); i++) {
                    if(foods.get(0) instanceof Meat)
                        meat=null;
                    foods.remove(0);
                    repaint();
                }
            }

            if (animals.size() > 0) {
                synchronized (this) {
                    for (int i = 0; i <= animals.size(); i++) {
                        Animal temp = animals.get(0);
                        temp.setAlive(false);
                        temp.notifyObservers();
                        animals.remove(0);
                        repaint();
                    }
                }
            }
            if (foods.size() > 0) {
                for (int i = 0; i <= foods.size(); i++) {
                    meat=null;
                    plant=null;
                    foods.remove(0);
                    repaint();
                }
            }

            repaint();
        }
        if (e.getSource() == Info) {
            JFrame frame = new JFrame();
            String[][] data = new String[animals.size()][6];
            for (int i = 0; i < animals.size(); i++) {
                data[i][0] = animals.get(i).getClass().getSimpleName();
                data[i][1] = animals.get(i).getColor();
                data[i][2] = String.valueOf(animals.get(i).getWeight());
                data[i][3] = String.valueOf(animals.get(i).getHorSpeed());
                data[i][4] = String.valueOf(animals.get(i).getVerSpeed());
                data[i][5] = String.valueOf(animals.get(i).getEatCounter());

            }
            String[] col = {"Animal", "Color", "Weight", "Hor.speed", "Ver.speed", "Eat Counter"};
            JTable table = new JTable(data, col);
            table.setBounds(60, 90, 200, 300);
            JScrollPane scroll_pane = new JScrollPane(table);
            frame.add(scroll_pane);
            frame.setSize(300, 400);
            frame.setVisible(true);
        }
        if (e.getSource() == Food) {

            String[] op = {"lettuce", "cabbage", "meat"};
            int x = JOptionPane.showOptionDialog(this, "Please choose food", "Food for animal",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, op, null);

            switch (x) {
                case 0:
                    if(foods.size()>0){
                        JOptionPane.showMessageDialog(this,"Food already exist!");
                    }
                    else {
                        plant = Plant.getplant(this);
                        foods.add(plant);
                        plant.drawObject(this.getGraphics());
                    }
                    break;
                case 1:
                    if(foods.size()>0){
                        JOptionPane.showMessageDialog(this,"Food already exist!");
                    }
                    else {
                        plant = Plant.getplant(this);
                        foods.add(plant);
                        plant.drawObject(this.getGraphics());
                    }
                    break;
                case 2:
                    if(foods.size()>0){
                        JOptionPane.showMessageDialog(this,"Food already exist!");
                    }
                    else {
                        meat = Meat.getMeat();
                        foods.add(meat);
                        meat.drawObject(this.getGraphics());
                    }
                    break;

            }
            if (foods.size()>0) {
                if (meat != null) {

                    for (Animal animal : animals) {
                        animal.change_direction(EFoodType.MEAT);
                    }
                }
//                manageZoo();
            } else {

                for (Animal a : animals) {
                    a.change_direction(EFoodType.VEGETABLE);
                }
//                manageZoo();
            }
        repaint();
        }
        if (e.getSource() == Exit) {
            for(Animal an:animals){
                an.setFlag();
            }
            System.exit(0);
        }

        if (e.getSource() ==colorBottun){
            String[] colors = {"Natural","Red", "Blue"};
            String [] names=new String[animals.size()] ;
            for (int i=0;i<animals.size();i++){
                names[i]=animals.get(i).getName()+":"+i;
            }
            JComboBox cb_type = new JComboBox(names),cb_color=new JComboBox(colors);
            int input = JOptionPane.showConfirmDialog(this, cb_type, "Choose animal: ", JOptionPane.DEFAULT_OPTION);
            if(input==JOptionPane.YES_OPTION) {
                int col = JOptionPane.showConfirmDialog(this, cb_color, "Choose animal's color: ", JOptionPane.DEFAULT_OPTION);
                if(col==JOptionPane.YES_OPTION){
                    animals.get(cb_type.getSelectedIndex()).setColor(((String) cb_color.getSelectedItem()));
                    animals.get(cb_type.getSelectedIndex()).loadImages(animals.get(cb_type.getSelectedIndex()).get_nm());
                    // animals.get(input).loadImages(((String) cb_color.getSelectedItem()));
//                    animals.get(cb_type.getSelectedIndex()).drawObject(this.getGraphics());
                }
            }

            repaint();
        }
        if (e.getSource() == back) {


        }


        if (e.getSource() == save) {

        }


    }
}

