package Lab01.JavaBasics;

import javax.swing.JOptionPane;

public class ChoosingOption_6_1 {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change the first class ticket?");
        JOptionPane.showMessageDialog(null,"You've chosen: " + (option == JOptionPane.YES_NO_OPTION? "Yes":"No"));
        System.exit(0);
    }
}

//if users choose "Cancel", program return message "You've chosen: No"
