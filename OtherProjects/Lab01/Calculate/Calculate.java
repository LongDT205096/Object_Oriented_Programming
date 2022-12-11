package Lab01.Calculate;

import javax.swing.JOptionPane;

public class Calculate {
    public static void main(String[] args){
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog("Input the first number:",
                                        JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog("Input the first number:",
                                        JOptionPane.INFORMATION_MESSAGE);
        
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        while (num2 == 0){
            JOptionPane.showMessageDialog(null, "num2 must not equal to 0");
            num2 = Double.parseDouble(JOptionPane.showInputDialog("Input again: "));
        }
        
        double sum = num1 + num2;
        double diff = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;
        JOptionPane.showMessageDialog(null, "Sum of " + num1 + " and " + num2 + " is " + sum);
        JOptionPane.showMessageDialog(null, "Differrent of "+ num1 + " and " + num2 + " is " + diff);
        JOptionPane.showMessageDialog(null, "Product of " + num1 + " and " + num2 + " is " + product);
        JOptionPane.showMessageDialog(null, "Quotient of " + num1 + " and " + num2 + " is " + quotient);
    
        System.exit(0);
    }
}
