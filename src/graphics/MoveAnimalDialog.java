package graphics;

import animals.Animal;
import mobility.Point;
import javax.swing.*;
import java.util.ArrayList;
/**
 * 'MoveAnimalDialog' class, used to move animals in zoo, using message dialog with user.
 * @version 29.4.22
 * @author Tal and Shoham
 * @see JDialog
 * @see Animal
 * */
public class MoveAnimalDialog extends JDialog {

    /**
     * MoveAnimalDialog constructor.
     * @param zoo the zoopanel (were we want to show the message dialog).
     * @param animals ArrayList of animals.
     */
    public MoveAnimalDialog(ZooPanel zoo, ArrayList<Animal> animals){
    int x=-1;
    int y=-1;
    boolean flag=false;
    String [] names=new String[animals.size()] ;
    for (int i=0;i<animals.size();i++){
        names[i]=animals.get(i).getName()+":"+i;
    }
    JComboBox cb_type = new JComboBox(names);

    int input = JOptionPane.showConfirmDialog(zoo, cb_type, "Choose animal: ", JOptionPane.DEFAULT_OPTION);
        if(input==JOptionPane.YES_OPTION) {
            while (!(flag)){
                try{
                    x = Integer.parseInt(JOptionPane.showInputDialog(zoo, "Enter the animal's location-> x (0-800): "));
                    y = Integer.parseInt(JOptionPane.showInputDialog(zoo, "Enter the animal's location-> y (0-600) "));
                    if((x>800||x<0)||(y>600||y<0)){
                        JOptionPane.showMessageDialog(zoo,"The coordinate is not in the range!");
                    }
                    else
                        flag=true;
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(zoo,"cannot move the animal!");
                    return;
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(zoo,"you have not choose an animal");
            return;
        }

    animals.get(cb_type.getSelectedIndex()).move(new Point(x,y));
    repaint();
    }
}

