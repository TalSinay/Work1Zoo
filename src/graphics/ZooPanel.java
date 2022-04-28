package graphics;
import food.EFoodType;
import food.Meat;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;
import animals.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class ZooPanel extends JPanel implements Runnable, ActionListener {
    private Plant p = null; //this will be the food i think(needs to talk about that).
    private BufferedImage img = null;
    private Button Add;
    private Button Move;
    private Button Clear;
    private Button Food;
    private  Button Info;
    private  Button Exit;

    private JDialog addAnimalDialog;
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private Plant plant;
    private Meat meat;
    private JPanel panel;
    private ArrayList<Object> foods = new ArrayList<Object>();

    public ZooPanel() {
        this.setSize(800, 600);

        Add = new Button("Add Animal");
        Move = new Button("Move Animal");
        Clear = new Button("Clear");
        Food = new Button("Food");
        Info = new Button("Info");
        Exit = new Button("Exit");
        Add.setBackground(Color.WHITE);
        Move.setBackground(Color.WHITE);
        Clear.setBackground(Color.WHITE);
        Food.setBackground(Color.WHITE);
        Info.setBackground(Color.WHITE);
        Exit.setBackground(Color.WHITE);

        Exit.addActionListener(this);
        Add.addActionListener(this);
        Move.addActionListener(this);
        Clear.addActionListener(this);
        Food.addActionListener(this);
        Info.addActionListener(this);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 25));
        panel.add(Add);
        panel.add(Move);
        panel.add(Clear);
        panel.add(Food);
        panel.add(Info);
        panel.add(Exit);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 2));
        panel.setBackground(Color.BLUE);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.PAGE_END);
        manageZoo();
    }

    public void run() {

    }

    public void manageZoo() {
        if (isChange())
            repaint();
        for (Animal animal : animals) {
            if (meat != null) {
                if (animal.calcDistance(meat.getlocation()) <= 10 && animal.calcDistance(meat.getlocation()) <= 10) {
                    if (animal.eat(meat)) {
                        this.callback(animal);
                        animal.setChanges(true);
                        meat=null;
                        repaint();
                    }
                }
            }
            if (plant != null) {
                if (animal.calcDistance(plant.getlocation()) <= 10 && animal.calcDistance(plant.getlocation()) <= 10) {
                    if (animal.eat(plant)) {
                        this.callback(animal);
                        animal.setChanges(true);
                        plant=null;
                        repaint();
                    }
                }
            }
        }
        for (Animal animal : animals) {
            for (Animal foodAnimal : animals) {
                if (!(animal.equals(foodAnimal))) {
                    if (animal.getWeight() > foodAnimal.getWeight() * 2 && animal.calcDistance(foodAnimal.getLocation()) < foodAnimal.getSize()) {
                        if (animal.eat(foodAnimal)) {
                            animal.IncEatcount();
                            animal.setChanges(true);
                            animals.remove(foodAnimal);
                            repaint();
                            break;
                        }
                    }
                }
            }
        }
    }

    public boolean isChange() {


        for (Animal animal : animals) {
            if (animal.getChanges()) {

                animal.setChanges(false);
                return true;
            }
        }
        return false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (animals.size() > 0) {
            for (Animal animal : animals) {
                animal.drawObject(g);
            }
        }
        if (plant != null)
            plant.drawObject(g);
        //need to call drawObject()
        if (meat != null)
            meat.drawObject(g);
    }

    public void callback(Animal animal) {
        animal.IncEatcount();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Add) {
            new AddAnimalDialog(this, animals);
            manageZoo();
        }
        if (e.getSource() == Move) {
            new MoveAnimalDialog(this, animals);
            manageZoo();
        }
        if (e.getSource() == Clear) {

            for (int i = 0; i <= animals.size(); i++) {
                Animal temp = animals.get(0);
                animals.get(0).setChanges(true);
                animals.remove(0);
                repaint();
            }
            for(int i=0;i<=foods.size();i++){
                foods.remove(foods.get(0));
                repaint();
            }
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
                    plant = new Lettuce();
                    foods.add(plant);
                    plant.drawObject(this.getGraphics());

                    break;
                case 1:
                    plant = new Cabbage();
                    foods.add(plant);
                    plant.drawObject(this.getGraphics());
                    break;
                case 2:
                    meat = new Meat();
                    foods.add(meat);
                    meat.drawObject(this.getGraphics());
                    break;
            }
            manageZoo();
        }
        if (e.getSource() == Exit) {
            System.exit(0);
        }
    }
}

