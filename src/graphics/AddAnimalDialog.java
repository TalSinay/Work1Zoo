package graphics;
import animals.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 'AddAnimalDialog' class, used to add animal to zoo, using message dialog with user.
 * @version 29.4.22
 * @author Tal and Shoham
 * @see JDialog
 * @see Animal
 * */
public class AddAnimalDialog extends JDialog {
    //    private static ArrayList<Animal> my_list = new ArrayList<>();
//    public static ArrayList<Animal> get_animals(){return my_list;}
    private ZooPanel zopanel;

    /**
     * AddAnimalDialog Constructor.
     *
     * @param zoopanel the zoo panel (were we want to show the dialog).
     * @param animals  ArrayList of animals
     */
    public AddAnimalDialog(ZooPanel zoopanel, ArrayList<Animal> animals) {
        if (animals.size() == 10) {
            JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals");
            return;
        }
        this.zopanel = zoopanel;
        int size = -1, hor_speed = -1, ver_speed = -1;
        boolean flag=false;
        String[] objects = {"Lion", "Turtle", "Bear", "Giraffe", "Elephant"};
        String[] colors = {"Red", "Blue", "Natural"};
        JComboBox cb_type = new JComboBox(objects), cb_color = new JComboBox(colors);
        int type = -1, col = -1;
        type = JOptionPane.showConfirmDialog(zoopanel, cb_type, "Choose animal's type: ", JOptionPane.DEFAULT_OPTION);
        if (type == JOptionPane.YES_OPTION) {
//        System.out.println("Error");
            col = JOptionPane.showConfirmDialog(zoopanel, cb_color, "Choose animal's color: ", JOptionPane.DEFAULT_OPTION);
            if (col == JOptionPane.YES_OPTION) {
                try {
                    while ((!flag)) {
                        size = Integer.parseInt(JOptionPane.showInputDialog(zoopanel, "Enter the animal's size: "));
                        ver_speed = Integer.parseInt(JOptionPane.showInputDialog(zoopanel, "Enter the animal's vertical speed: "));
                        hor_speed = Integer.parseInt(JOptionPane.showInputDialog(zoopanel, "Enter the animal's horizontal speed: "));
                        if ((ver_speed < 1 || ver_speed > 10) || (hor_speed < 1 || hor_speed > 10) || (size > 300 || size < 50)) {
                            flag = false;
                            JOptionPane.showMessageDialog(zoopanel, "Input wrong");
                        } else
                            flag = true;
                    }
                }
                catch (Exception e) {
                JOptionPane.showMessageDialog(zoopanel, "Canot build ,only numbers");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(zoopanel, "you have not choose a color");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(zoopanel, "you have not choose an animal");
            return;
        }

        if (type == JOptionPane.YES_OPTION && col == JOptionPane.YES_OPTION) {
            String typeItemAt = ((String) cb_type.getItemAt(cb_type.getSelectedIndex()));
            switch (typeItemAt) {
                case "Lion" -> animals.add(new Lion(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 0.8, zoopanel));
                case "Bear" -> animals.add(new Bear(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 1.5, zoopanel));
                case "Giraffe" -> animals.add(new Giraffe(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 2.2, zoopanel));
                case "Turtle" -> animals.add(new Turtle(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 0.5, zoopanel));
                case "Elephant" -> animals.add(new Elephant(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 10, zoopanel));
                default -> JOptionPane.showMessageDialog(zoopanel, "You Entered a bad choice");
            }
        }
        zoopanel.manageZoo();
    }
}




