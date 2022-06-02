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
import java.util.concurrent.*;

/**
 * 'ZooPanel' class, used to declare the panel of the zoo, using ActionListener.
 * @version 29.4.22
 * @author Tal and Shoham
 * @see JPanel
 * @see Runnable
 * @see ActionListener
 * @see Animal
 * */
public class ZooPanel extends JPanel implements  ActionListener {
    private BufferedImage img = null;
    private Button Add;
    private Button Sleep;
    private Button WakeUp;
    private Button Clear;
    private Button Food;
    private Button Info;
    private Button color;
    private Button Exit;
    private JDialog addAnimalDialog;
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private Plant plant;
    private Meat meat;
    private JPanel panel;
    private ArrayList<Object> foods = new ArrayList<Object>();
    private boolean flag = true;
    private static ZooPanel zoopanel=null;
    ExecutorService threadPoolExecutor = new ThreadPoolExecutor(10,10,60,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(5));
    /**
     * ZooPanel constructor.
     */
    private ZooPanel() {
        this.setSize(800, 600);
        Add = new Button("Add Animal");
        Sleep = new Button("Sleep");
        WakeUp = new Button("Wake up");
        Clear = new Button("Clear");
        color = new Button("Color");
        Food = new Button("Food");
        Info = new Button("Info");
        Exit = new Button("Exit");
        Add.setBackground(Color.WHITE);
        Sleep.setBackground(Color.WHITE);
        WakeUp.setBackground(Color.WHITE);
        color.setBackground(Color.WHITE);
        Clear.setBackground(Color.WHITE);
        Food.setBackground(Color.WHITE);
        Info.setBackground(Color.WHITE);
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        Add.addActionListener(this);
        color.addActionListener(this);
        Sleep.addActionListener(this);
        WakeUp.addActionListener(this);
        Clear.addActionListener(this);
        Food.addActionListener(this);
        Info.addActionListener(this);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 25));
        panel.add(Add);
        panel.add(Sleep);
        panel.add(WakeUp);
        panel.add(Clear);
        panel.add(color);
        panel.add(Food);
        panel.add(Info);
        panel.add(Exit);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 2));
        panel.setBackground(Color.BLUE);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.PAGE_END);

    }

    public ExecutorService getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public static ZooPanel getZoopanel(){
        if(zoopanel==null){
            synchronized (ZooPanel.class){
                if(zoopanel==null)
                    zoopanel=new ZooPanel();
            }
        }
        return zoopanel;
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
                                animals.get(i).setChanges(true);
                                meat = null;
                                repaint();
                            }
                        }
                    }
                    if (plant != null) {
                        if (animals.get(i).calcDistance(plant.getlocation()) <= 10 && animals.get(i).calcDistance(plant.getlocation()) <= 10) {
                            if (animals.get(i).eat(plant)) {
                                this.callback(animals.get(i));
                                animals.get(i).setChanges(true);
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
                                            animals.remove(animals.get(j));
                                            animals.get(i).IncEatcount();
                                            animals.get(i).setChanges(true);
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
            new AddAnimalDialog(this, animals);
            threadPoolExecutor.execute(animals.get(animals.size()-1));
            repaint();

        }
        if (e.getSource() ==color){
            String[] colors = {"Natural","Red", "Blue"};
            String [] names=new String[animals.size()] ;
            for (int i=0;i<animals.size();i++){
                names[i]=animals.get(i).getName()+":"+i;
            }
            JComboBox cb_type = new JComboBox(names),cb_color=new JComboBox(colors);
            int input = JOptionPane.showConfirmDialog(this, cb_type, "Choose animal: ", JOptionPane.DEFAULT_OPTION);
            if(input==JOptionPane.YES_OPTION) {
                int col = JOptionPane.showConfirmDialog(zoopanel, cb_color, "Choose animal's color: ", JOptionPane.DEFAULT_OPTION);
                if(col==JOptionPane.YES_OPTION){
                    animals.get(input).setColor(((String) cb_color.getSelectedItem()));
                   // animals.get(input).loadImages(((String) cb_color.getSelectedItem()));
                }
            }
        }
        if (e.getSource() == Sleep) {
            for (Animal animal : animals) {
                animal.setSuspended();
            }
            repaint();
        }
        if (e.getSource() == WakeUp) {
            synchronized (this) {
                for (Animal an : animals) {
                    an.setResumed();
                    repaint();
                }
            }
        }
        if (e.getSource() == Clear) {

            if (animals.size() > 0) {
                synchronized (this) {
                    for (int i = 0; i < animals.size(); i++) {
                        animals.get(0).setSuspended();
                        animals.get(0).setChanges(true);
                        animals.remove(0);
                        repaint();
                    }
                }
            }
            if (foods.size() > 0) {
                for (int i = 0; i <= foods.size(); i++) {

                    foods.remove(0);
                    repaint();
                }
            }

            if (animals.size() > 0) {
                synchronized (this) {
                    for (int i = 0; i <= animals.size(); i++) {
                        Animal temp = animals.get(0);

                        temp.setChanges(true);
                        animals.remove(0);
                        repaint();
                    }
                }
            }
            if (foods.size() > 0) {
                for (int i = 0; i <= foods.size(); i++) {
                    foods.remove(0);
                    repaint();
                }
            }
            plant = null;
            meat = null;
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
            if(foods.size()>0){
                JOptionPane.showMessageDialog(this,"cannot build,food is already exist");
                manageZoo();
            }
            else {
                String[] op = {"plant", "meat"};
                int x = JOptionPane.showOptionDialog(this, "Please choose type of food", "Food for animal",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, op, null);

                switch (x) {
                    case 0:
                        Animal.setPlant(true);
                        plant = Plant.getplant(this);
                        foods.add(plant);
                        plant.drawObject(this.getGraphics());
                        break;
                    case 1:
                        Animal.setMeat(true);
                        meat = Meat.getMeat();
                        foods.add(meat);
                        meat.drawObject(this.getGraphics());
                        break;
                }
            }
            if (meat != null || plant != null) {
                if (meat != null) {

                    for (Animal animal : animals) {
                        animal.change_direction(EFoodType.MEAT);
                    }
                }
                manageZoo();
            } else {

                for (Animal a : animals) {
                    a.change_direction(EFoodType.VEGETABLE);
                }
                manageZoo();
            }



        repaint();
        }
        if (e.getSource() == Exit) {
            for(Animal an:animals){
                an.setFlag();
            }
            System.exit(0);
        }
    }
}

