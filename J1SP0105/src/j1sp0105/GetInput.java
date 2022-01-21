package j1sp0105;

import java.util.Scanner;

public class GetInput {

    static Scanner sc = new Scanner(System.in);

    // Input a non-empty string
    public static String inputNonEmptyString() {
        String s = sc.nextLine().trim();
        // loop until user input a non-empty string
        while (s.isEmpty()) {
            System.err.print("This section cannot be left blank. Enter again: ");
            s = sc.nextLine().trim();
        }
        return s;
    }

    // Input a positive integer
    public static int inputPositiveInt() {
        int number;
        // loop until user input a positive integer
        while (true) {
            try {
                number = Integer.parseInt(inputNonEmptyString());
                // if if user not input a positive integer
                if (number <= 0) {
                    System.err.print("You must enter a positive integer. Enter again: ");
                } // if if user input a positive integer
                else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.print("You must enter a positive integer. Enter again: ");
            }
        }
        return number;
    }
    
    // Input option
    public int inputOption() {
        int option = inputPositiveInt();
        // loop until user input option in range 1 -> 6
        while (option < 1 || option > 5) {
            System.err.print("Your option must be in range 1 -> 6. Enter again: ");
            option = inputPositiveInt();
        }
        return option;
    }
    
    public int inputSearchType(){
        int option = inputPositiveInt();
        // loop until user input option in range 1 -> 6
        while (option < 1 || option > 4) {
            System.err.print("Your option must be in range 1 -> 4. Enter again: ");
            option = inputPositiveInt();
        }
        return option;
    }
}
