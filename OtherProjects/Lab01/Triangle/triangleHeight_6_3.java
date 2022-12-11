package Lab01.Triangle;

import javax.swing.JOptionPane;

public class triangleHeight_6_3 {
    public static void main(String[] args){
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Input triangle's height: ", 
                                                        JOptionPane.INFORMATION_MESSAGE));
        int i;
        for(i = 1; i <= n; ++i){
            int k = 0;
            for(int space = 1; space <= n - i; ++space){
                System.out.print(" ");
            }
            while(k != 2*i - 1){
                System.out.print("*");
                ++k;
            }
            System.out.print("\n");            
        }
        System.exit(0);
    }
}
