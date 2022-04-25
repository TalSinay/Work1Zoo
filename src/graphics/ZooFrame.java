package graphics;
import animals.*;
import food.*;
import diet.*;
import mobility.*;
import plants.*;
import utilities.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ZooFrame extends JFrame implements ActionListener {
    private ZooPanel zoo;

    JComboBox comboBox;


    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu backGroundMenu;
    JMenu helpMenu;
    JMenuItem NoneItem;
    JMenuItem ImageItem;
    JMenuItem greenItem;
    JMenuItem helpItem;
    JMenuItem exitItem;
    JLabel label;

    ImageIcon image =new ImageIcon("savanna.png");
    JLabel label1;



    ZooFrame(){
        zoo=new ZooPanel();
        this.setTitle("zoo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);

        //zoo.manageZoo();

        menuBar=new JMenuBar();

        fileMenu = new JMenu("File");
        backGroundMenu = new JMenu("Background");
        helpMenu = new JMenu("Help");

        NoneItem=new JMenuItem("None");
        ImageItem=new JMenuItem("Image");
        greenItem=new JMenuItem("Green");
        helpItem=new JMenuItem("Help");
        exitItem=new JMenuItem("Exit");

        NoneItem.addActionListener(this);
        exitItem.addActionListener(this);
        helpItem.addActionListener(this);
        ImageItem.addActionListener(this);
        greenItem.addActionListener(this);

        fileMenu.add(exitItem);
        backGroundMenu.add(ImageItem);
        backGroundMenu.add(greenItem);
        backGroundMenu.add(NoneItem);
        helpMenu.add(helpItem);

        menuBar.add(fileMenu);
        menuBar.add(backGroundMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        BorderLayout myBorderLayout = new BorderLayout();
        myBorderLayout.setHgap(2);
        myBorderLayout.setVgap(5);
        this.setLayout(myBorderLayout);//layout
        this.add(zoo,BorderLayout.SOUTH);

        label1=new JLabel(image);





        this.setVisible(true);



    }










    public static void main(String args[]){
        new ZooFrame();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==exitItem){
            System.exit(0);

        }
        if(e.getSource()==NoneItem){
            this.remove(label);
            this.getContentPane().setBackground(null);

        }
        if(e.getSource()==greenItem){
            this.remove(label);
            this.getContentPane().setBackground(Color.GREEN);

        }
        if(e.getSource()==helpItem){

        }
        if(e.getSource()==ImageItem){

            try {

                this.getContentPane().setBackground(null);
                BufferedImage img = ImageIO.read(new File("D:/User Files/Desktop/טל לימודים/שנה ב סמסטר ב/תכנות מונחה עצמים מתקדם/עבודות הגשה/עבודה 2_pictures/assignment2_pictures/savanna.jpg"));
                label = new JLabel();
                label.setBounds(0, 0, 800, 600);
                Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                label.setIcon(imageIcon);
                this.getContentPane().add(label);
            }
            catch (IOException a) { System.out.println("Cannot load image");
                System.out.println(a.toString());}

            this.getContentPane().add(label1);



        }



    }
}
