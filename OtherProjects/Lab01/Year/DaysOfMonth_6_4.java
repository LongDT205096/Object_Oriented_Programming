package Lab01.Year;

import javax.swing.JOptionPane;

public class DaysOfMonth_6_4 {
    public static void main(String[] args){
        int year = Integer.parseInt(JOptionPane.showInputDialog(null,"Input year: ", JOptionPane.INFORMATION_MESSAGE));
        String month = JOptionPane.showInputDialog(null,"Input month: ", JOptionPane.INFORMATION_MESSAGE);
        String MonthOfName = "Unknown";
        int number_Of_DaysInMonth = 0;

        switch (month) {
            case "1": case "Jan": case "Jan.":
                MonthOfName = "January";
                number_Of_DaysInMonth = 31;
                break;
            case "2": case "Feb": case "Feb.":
                MonthOfName = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    number_Of_DaysInMonth = 29;
                } else {
                    number_Of_DaysInMonth = 28;
                }
                break;
            case "3": case "Mar": case "Mar.":
                MonthOfName = "March";
                number_Of_DaysInMonth = 31;
                break;
            case "4": case "Apr": case "Apr.":
                MonthOfName = "April";
                number_Of_DaysInMonth = 30;
                break;
            case "5": case "May": case "May.":
                MonthOfName = "May";
                number_Of_DaysInMonth = 31;
                break;
            case "6": case "Jun": case "Jun.":
                MonthOfName = "June";
                number_Of_DaysInMonth = 30;
                break;
            case "7": case "Jul": case "Jul.":
                MonthOfName = "July";
                number_Of_DaysInMonth = 31;
                break;
            case "8": case "Aug": case "Aug.":
                MonthOfName = "August";
                number_Of_DaysInMonth = 31;
                break;
            case "9": case "Sep": case "Sep.":
                MonthOfName = "September";
                number_Of_DaysInMonth = 30;
                break;
            case "10": case "Oct": case "Oct.":
                MonthOfName = "October";
                number_Of_DaysInMonth = 31;
                break;
            case "11": case "Nov": case "Nov.":
                MonthOfName = "November";
                number_Of_DaysInMonth = 30;
                break;
            case "12": case "Dec": case "Dec.":
                MonthOfName = "December";
                number_Of_DaysInMonth = 31;
        }
        System.out.print(MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days\n");
    }
}
