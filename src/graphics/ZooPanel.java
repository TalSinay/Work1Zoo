package graphics;
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
    private Plant p=null; //this will be the food i think(needs to talk about that).
    private BufferedImage img = null;
    Button Add;
    Button Move;
    Button Clear;
    Button Food;
    Button Info;
    Button Exit;
    private JDialog addAnimalDialog;
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private Plant plant;

    public ZooPanel(){
        this.setSize(new Dimension(800,600));
        BorderLayout myBorderLayout = new BorderLayout();
        myBorderLayout.setHgap(20);
        myBorderLayout.setVgap(50);
        this.setLayout(myBorderLayout);//layout



        Add =new Button("Add Animal");
        Move =new Button("Move Animal");
        Clear =new Button("Clear");
        Food =new Button("Food");
        Info =new Button("Info");
        Exit =new Button("Exit");
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
        JPanel panel=new JPanel();//panel
        panel.setPreferredSize(new Dimension(60, 25));//the blue panel
        panel.add(Add);
        panel.add(Move);
        panel.add(Clear);
        panel.add(Food);
        panel.add(Info);
        panel.add(Exit);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER,60,2));
        panel.setBackground(Color.BLUE);
        this.add(panel);
    }
    public void run() {

    }
    public void manageZoo() {
        if (isChange())
            repaint();

    }

    public boolean isChange() {
        //if (getChanges())
        //return true;
        for(Animal animal: animals){
            if(animal.getChanges()){
                animal.setChanges(false);
                return true;
            }
        }
        return false;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g) ;

        if(animals.size() > 0){
            for(Animal animal: animals){
                animal.drawObject(g);
            }
        }
        if(plant != null)
            plant.drawObject(g);
        //need to call drawObject()




    }
    public void callback(Animal animal){
        animal.IncEatcount();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==Add){
            new AddAnimalDialog(this, animals);
        }
        if(e.getSource()==Move){

        }
        if(e.getSource()==Clear){
//            for()
        }
        if(e.getSource()==Info){
            for(Animal animal: animals){
                System.out.println(animal);
            }
        }
        if(e.getSource()==Food){

        }
        if(e.getSource()==Exit){
            System.exit(0);

        }


        }
}
