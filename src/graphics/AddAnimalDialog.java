package graphics;
import animals.*;
import javax.swing.*;
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
      * @param zoopanel the zoo panel (were we want to show the dialog).
     * @param animals ArrayList of animals
     */
    public AddAnimalDialog( ZooPanel zoopanel, ArrayList<Animal> animals){
        if(animals.size() == 10){
            JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals");
            return;
        }
        this.zopanel=zoopanel;
        int size=0;
        int ver_speed=0;
        int hor_speed=0;
        boolean flag=false;
        String[] objects = {"Lion", "Turtle", "Bear", "Giraffe", "Elephant"};
        String[] colors = {"Red", "Blue", "Natural"};
        JComboBox cb_type = new JComboBox(objects), cb_color = new JComboBox(colors);

        int input = JOptionPane.showConfirmDialog(zoopanel, cb_type, "Choose animal's type: ",JOptionPane.DEFAULT_OPTION);
        JOptionPane.showConfirmDialog(zoopanel, cb_color, "Choose animal's color: ", JOptionPane.DEFAULT_OPTION);
        size = Integer.parseInt(JOptionPane.showInputDialog(zoopanel,"Enter the animal's size: "));
        ver_speed = Integer.parseInt(JOptionPane.showInputDialog(zoopanel,"Enter the animal's vertical speed: "));
        hor_speed = Integer.parseInt(JOptionPane.showInputDialog(zoopanel,"Enter the animal's horitional speed: "));


        if(input == JOptionPane.OK_OPTION ) {
            String typeItemAt = ((String) cb_type.getItemAt(cb_type.getSelectedIndex()));
            switch (typeItemAt) {
                case "Lion" -> animals.add(new Lion(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 0.8, zoopanel));
                case "Bear" -> animals.add(new Bear(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 1.5, zoopanel));
                case "Giraffe" -> animals.add(new Giraffe(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 2.2, zoopanel));
                case "Turtle" -> animals.add(new Turtle(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 0.5, zoopanel));
                case "Elephant" -> animals.add(new Elephant(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 10, zoopanel));
                default -> JOptionPane.showMessageDialog(null, "You Entered a bad choice");
            }
             zoopanel.manageZoo();
        }
        else{
            System.out.println("canot made an animal");
        }
    }
}
