package graphics;
import animals.*;
import food.*;
import diet.*;
import mobility.*;
import plants.*;
import utilities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
            this.getContentPane().setBackground(null);

        }
        if(e.getSource()==greenItem){
            this.getContentPane().setBackground(Color.GREEN);

        }
        if(e.getSource()==helpItem){

        }
        if(e.getSource()==ImageItem){

            this.getContentPane().add(label1);



        }



    }
}
