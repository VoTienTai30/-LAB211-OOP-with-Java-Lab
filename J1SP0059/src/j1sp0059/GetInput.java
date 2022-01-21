package j1sp0059;

import java.io.File;
import java.util.Scanner;

public class GetInput {

    Scanner sc = new Scanner(System.in);

    String getStringNonEmpty() {
        String s = sc.nextLine().trim();
        // loop until user input a non empty string
        while (s.isEmpty()) {
            System.err.println("You cannot leave this section blank");
            System.out.print("Input again: ");
            s = sc.nextLine().trim();
        }
        return s;
    }

    int getOption() {
        int option;
        // loop until user input a valid option
        while (true) {
            try {
                option = Integer.parseInt(getStringNonEmpty());
                // if option user input out of range option
                if (option < 1 || option > 3) {
                    System.err.println("You must input 1 -> 3");
                    System.out.print("Input again: ");
                } // if option user input is valid 
                else {
                    return option;
                }
            } catch (Exception e) {
                System.err.println("You must input an integer");
                System.out.print("Input again: ");
            }
        }
    }

    String getPathFile() {
        // loop until user enter correct path file 
        while (true) {
            String pathFile = getStringNonEmpty();
            File file = new File(pathFile);
            // if don't exist this file or the path name is not file
            if (!file.exists() || !file.isFile()) {
                System.out.println("File doesn't exist");
                System.out.print("Input again: ");
            } // if user enter correct path file 
            else {
                return pathFile;
            }
        }
    }

    double getMoney() {
        // Loop until user enter correct value
        while (true) {
            String moneyTxt = getStringNonEmpty();
            try {
                double money = Double.parseDouble(moneyTxt);
                // if money user input >= 0
                if (money >= 0) {
                    return money;
                } // if money user input < 0
                else {
                    System.err.println("Money must be greater than or equal to 0");
                    System.out.print("Input again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Money is double number");
                System.out.print("Input again: ");
            }
        }
    }

    String getYN() {
        // loop until user enter correct value
        while (true) {
            String choiceYN = getStringNonEmpty();
            // if user enter choice is Y
            if (choiceYN.equalsIgnoreCase("Y")) {
                return "Y";
            } // if user enter choice is N
            else if (choiceYN.equalsIgnoreCase("N")) {
                return "N";
            } // if user enter choice is not Y or N
            else {
                System.err.println("Choice must be Y/N (y/n) ");
                System.out.print("Input again: ");
            }
        }
    }
}
