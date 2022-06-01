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

/**
 * 'ZooFrame' class, used to declare the ZooFrame and manage the ZooPanel, using message dialog with user and ActionListener.
 * @version 29.4.22
 * @author Tal and Shoham
 * @see JOptionPane
 * @see JFrame
 * @see ActionListener
 * @see Animal
 * */
public class ZooFrame extends JFrame implements ActionListener {
    private ZooPanel zoo;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu backGroundMenu;
    private  JMenu helpMenu;
    private JMenuItem NoneItem;
    private JMenuItem ImageItem;
    private JMenuItem greenItem;
    private JMenuItem helpItem;
    private JMenuItem exitItem;
    private JLabel label;
    private  ImageIcon image =new ImageIcon("savanna.png");
    private JLabel label1;
    JComboBox comboBox;

    /**
     * ZooFrame Constructor.
     * Create the zoo frame and make it visible.
     */
    ZooFrame(){
        zoo=ZooPanel.getZoopanel();
        this.setTitle("zoo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
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
        label1=new JLabel(image);
        this.setJMenuBar(menuBar);
        BorderLayout myBorderLayout = new BorderLayout();
        myBorderLayout.setHgap(2);
        myBorderLayout.setVgap(5);
        this.setLayout(myBorderLayout);
        this.add(zoo);
        this.setVisible(true);
    }

    /**
     * the main of the program.
     * @param args contains the supplied command-line arguments as an array of String objects.
     */
    public static void main(String args[]){
        new ZooFrame();
    }

    /**
     * actionPerformed override method.
     * @param e the interaction between the user to the system.
     * @exception IOException java.io.FileNotFoundException
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==exitItem){
            System.exit(0);
        }
        if(e.getSource()==NoneItem){
            if(label!=null)

                this.remove(label);
            this.getContentPane().setBackground(null);
        }
        if(e.getSource()==greenItem){
            if(label!=null)
                this.remove(label);
            this.getContentPane().setBackground(Color.GREEN);

        }
        if(e.getSource()==helpItem){
            JOptionPane.showMessageDialog(this, "Home Work 2\nGUI");
        }
        if(e.getSource()==ImageItem){

            try {
               if(label!=null)
                    this.remove(label);

                this.getContentPane().setBackground(null);
                BufferedImage img = ImageIO.read(new File(IDrawable.PICTURE_PATH+"\\savanna.png"));
                label = new JLabel();
                label.setBounds(0, -30, 800, 600);
                Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                label.setIcon(imageIcon);
                this.getContentPane().add(label);
            }
            catch (IOException a) { System.out.println("Cannot load image");
                System.out.println(a.toString());}
        }
    }
}
