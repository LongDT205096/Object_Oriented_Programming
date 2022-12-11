package Lab01.LinearEquation;

import javax.swing.JOptionPane;
import java.lang.Math;

public class LinearEquation {
    static void firstDegree(){
        double a = Double.parseDouble(JOptionPane.showInputDialog("Input number a: "));
        while (a == 0){
            JOptionPane.showMessageDialog(null, "a must not equal to 0");
            a = Double.parseDouble(JOptionPane.showInputDialog("Input again: "));
        }

        double b =  Double.parseDouble(JOptionPane.showInputDialog("Input number b: "));
        double fx = Double.parseDouble(JOptionPane.showInputDialog("Input result : "));
        double x = (fx-b)/a;
        JOptionPane.showMessageDialog(null, "x = " + x);
    }
    
    static void secondDegree(){
        double a = Double.parseDouble(JOptionPane.showInputDialog("Input number a: "));
        while (a == 0){
            JOptionPane.showMessageDialog(null, "a must not equal to 0");
            a = Double.parseDouble(JOptionPane.showInputDialog("Input again: "));
        }

        double b =  Double.parseDouble(JOptionPane.showInputDialog("Input number b: "));
        double c =  Double.parseDouble(JOptionPane.showInputDialog("Input number c: "));
        double delta = Math.pow(b, 2) - 4*a*c;

        if (delta > 0){
            double x1 = (-b + Math.sqrt(delta)) / (2*a);
            double x2 = (-b - Math.sqrt(delta)) / (2*a);
            JOptionPane.showMessageDialog(null, "Phuonng trinh co 2 nghiem phan biet " + x1 + " va " + x2);
        } else if(delta == 0){
            JOptionPane.showMessageDialog(null, "Phuonng trinh co nghiem don " + -b/(2*a));
        } else {
            JOptionPane.showMessageDialog(null, "Phuonng trinh vo nghiem");
        }   
    }

    static void firstDegreeTwoVariable(){
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Input number a11: "));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Input number a12: "));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Input number a21: "));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Input number a22: "));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Input result b1: "));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Input result b2: "));
        double D = a11*a22 - a21*a12;
        double D1 = b1*a22 - b2*a12;
        double D2 = a11*b2 - a21*b1;
        if (D == 0){
            if(D1 + D2 == 0){
                JOptionPane.showMessageDialog(null, "Phuong trinh co vo so nghiem");
            } else{
                JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
            }
        } else{
            double x1 = D1/D;
            double x2 = D2/D;
            JOptionPane.showMessageDialog(null, String.format("Phuong trinh co 2 nghiem (%lf, %lf)", x1, x2));
        }  
    }

    public static void main(String[] args){
        firstDegree();
        secondDegree();
        firstDegreeTwoVariable();
    }
}
