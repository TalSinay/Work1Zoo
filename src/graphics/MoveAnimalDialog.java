package graphics;

import animals.Animal;
import mobility.Point;

import javax.swing.*;
import java.util.ArrayList;

public class MoveAnimalDialog extends JDialog {

    public MoveAnimalDialog(ZooPanel zoo, ArrayList<Animal> animals){

    int x;
    int y;
    String [] names=new String[animals.size()] ;
    for (int i=0;i<animals.size();i++){
        names[i]=animals.get(i).getName()+":"+i;
    }
    JComboBox cb_type = new JComboBox(names);
    int input = JOptionPane.showConfirmDialog(zoo, cb_type, "Choose animal: ", JOptionPane.DEFAULT_OPTION);
    x =Integer.parseInt(JOptionPane.showInputDialog(zoo,"Enter the animal's location-> x (0-800): "));
    y =Integer.parseInt(JOptionPane.showInputDialog(zoo,"Enter the animal's location-> y (0-600) "));
    animals.get(cb_type.getSelectedIndex()).move(new Point(x,y));
    repaint();





    }
}
