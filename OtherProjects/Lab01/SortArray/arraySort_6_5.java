package Lab01.SortArray;

import java.util.Arrays;

public class arraySort_6_5{
    static void sort(int[] arr){
        Arrays.sort(arr);
        System.out.println("\nThe sorted array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("\n");       
    }
    
    static void calcu(int[] arr){
        int sum = 0;
        for(int value : arr){
            sum += value;
        }
        double average = (double)sum / arr.length;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
 
    public static void main(String[] args){
        int[] arr = new int [] {5, 2, 8, 7, 1};
        sort(arr);
        calcu(arr);
        System.exit(0);
    }
}
