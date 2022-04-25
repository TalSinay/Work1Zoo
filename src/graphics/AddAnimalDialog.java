package graphics;
import animals.*;
import javax.swing.*;
import java.util.ArrayList;
public class AddAnimalDialog extends JDialog {
    private static ArrayList<Animal> my_list = new ArrayList<>();
    public static ArrayList<Animal> get_animals(){return my_list;}

    //need to change the function name (only tests)
    public static void main(String[] args){
        if(my_list.size() == 10){
            JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals");
            return;
        }
        int size;
        int ver_speed;
        int hor_speed;
        String[] objects = {"Lion", "Turtle", "Bear", "Giraffe", "Elephant"};
        String[] colors = {"Red", "Blue", "Natural"};
        JComboBox cb_type = new JComboBox(objects), cb_color = new JComboBox(colors);
        int input = JOptionPane.showConfirmDialog(null, cb_type, "Choose animal's type: ",JOptionPane.DEFAULT_OPTION);
        int input2 = JOptionPane.showConfirmDialog(null, cb_color, "Choose animal's color: ", JOptionPane.DEFAULT_OPTION);
        size = Integer.parseInt(JOptionPane.showInputDialog("Enter the animal's size: "));
        ver_speed = Integer.parseInt(JOptionPane.showInputDialog("Enter the animal's vertical speed: "));
        hor_speed = Integer.parseInt(JOptionPane.showInputDialog("Enter the animal's horitional speed: "));
        if(input == JOptionPane.OK_OPTION) {
            String s = ((String) cb_type.getItemAt(cb_type.getSelectedIndex()));
            switch (s) {
                case "Lion" -> my_list.add(new Lion(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 0.8));
                case "Bear" -> my_list.add(new Bear(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 1.5));
                case "Giraffe" -> my_list.add(new Giraffe(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 2.2));
                case "Turtle" -> my_list.add(new Turtle(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 0.5));
                case "Elephant" -> my_list.add(new Elephant(size, ver_speed, hor_speed, ((String) cb_color.getSelectedItem()), size * 10));
                default -> JOptionPane.showMessageDialog(null, "You Entered a bad choice");
            }
            System.out.println(my_list.get(my_list.size() - 1));
        }
    }
}
