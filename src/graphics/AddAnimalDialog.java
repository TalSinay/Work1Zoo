package graphics;
import animals.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;

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
    private Animal animal;
    private ZooPanel zopanel;

    /**
     * AddAnimalDialog Constructor.
     *
     * @param zoopanel the zoo panel (were we want to show the dialog).
     * @param animals  ArrayList of animals
     */
    public AddAnimalDialog(ZooPanel zoopanel, ArrayList<Animal> animals, Observer observer) {
        if (animals.size() == 10) {
            JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals");
            return;
        }
        this.zopanel = zoopanel;
        int size = -1, hor_speed = -1, ver_speed = -1;
        boolean flag=false;
        String[] objects = {"Lion", "Turtle", "Giraffe", "Elephant","Bear"};
        String[] types = {"Herbivore","Omnivore","Carnivore"};
        String[] Herbivore = {"Turtle", "Giraffe", "Elephant","Bear"};
        String[] Carnivore = {"Lion", "Bear"};
        String[] colors = {"Natural","Red", "Blue"};
        JComboBox cb_object = new JComboBox(objects), cb_color = new JComboBox(colors),cb_type=new JComboBox(types),cb_her=new JComboBox(Herbivore),cb_car=new JComboBox(Carnivore);
        int type = -1, col = -1,obj=-1;
        try {
            type = JOptionPane.showConfirmDialog(zoopanel, cb_type, "Choose animal's diet: ", JOptionPane.DEFAULT_OPTION);
            switch (cb_type.getSelectedIndex()) {
                case 0:
                    obj = JOptionPane.showConfirmDialog(zoopanel, cb_her, "Choose animal's type: ", JOptionPane.DEFAULT_OPTION);
                    break;
                case 1:
                    obj = 1;
                    break;
                case 2:
                    obj = JOptionPane.showConfirmDialog(zoopanel, cb_car, "Choose animal's type: ", JOptionPane.DEFAULT_OPTION);
                    break;

            }
            if (obj == JOptionPane.YES_OPTION || obj == 1) {

                col = JOptionPane.showConfirmDialog(zoopanel, cb_color, "Choose animal's color: ", JOptionPane.DEFAULT_OPTION);
                if (col == JOptionPane.YES_OPTION) {
                    try {
                        while ((!flag)) {
                            size = Integer.parseInt(JOptionPane.showInputDialog(zoopanel, "Enter the animal's size(50-300): "));
                            ver_speed = Integer.parseInt(JOptionPane.showInputDialog(zoopanel, "Enter the animal's vertical speed(1-10): "));
                            hor_speed = Integer.parseInt(JOptionPane.showInputDialog(zoopanel, "Enter the animal's horizontal speed(1-10): "));
                            if ((ver_speed < 1 || ver_speed > 10) || (hor_speed < 1 || hor_speed > 10) || (size > 300 || size < 50)) {
                                flag = false;
                                JOptionPane.showMessageDialog(zoopanel, "Input wrong");
                            } else
                                flag = true;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(zoopanel, "Cannot build ,only numbers");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(zoopanel, "You have not choose a color");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(zoopanel, "You have not choose an animal");
                return;
            }

            if (type == JOptionPane.YES_OPTION && col == JOptionPane.YES_OPTION) {
                String typeItemAt = ((String) cb_type.getSelectedItem());
                switch (typeItemAt) {
                    case "Carnivore":
                        if (cb_car.getSelectedIndex() == 0) {
                            animal = new Lion(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 0.8, zoopanel, observer);
                            break;
                        }
                    case "Omnivore":
                        animal = new Bear(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 1.5, zoopanel, observer);
                        break;
                    case "Herbivore":
                        if (cb_her.getSelectedIndex() == 0) {
                            animal = new Turtle(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 0.5, zoopanel, observer);
                            break;
                        } else if (cb_her.getSelectedIndex() == 1) {
                            animal = new Giraffe(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 2.2, zoopanel, observer);
                        } else if (cb_her.getSelectedIndex() == 2) {
                            animal = new Elephant(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 10, zoopanel, observer);
                            break;
                        } else {
                            animal = new Bear(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 1.5, zoopanel, observer);
                            break;
                        }

                }
            }

            animals.add(animal);

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(zoopanel,"The animal factory fails in building");
        }
    }
}




