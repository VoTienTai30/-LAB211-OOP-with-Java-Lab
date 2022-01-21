package j1sp0052;

import java.util.Scanner;

public class GetInput {

    Scanner sc = new Scanner(System.in);

    // User input an option
    public int inputOption() {
        int option = inputInt();
        // loop until user selects option 1 -> 5
        while (option < 1 || option > 5) {
            System.err.println("Your option must be 1 -> 5. Please enter again: ");
            option = inputInt();
        }
        return option;
    }

    // Return string user input if it is integer
    public int inputInt() {
        int result;
        // loop until user enter intger
        while (true) {
            try {
                result = Integer.parseInt(inputStringNotEmpty());
                break;
            } catch (NumberFormatException e) {
                System.err.println("You must enter integer. Please enter again: ");
            }
        }
        return result;
    }

    // User input a string and return it if it is not empty
    public String inputStringNotEmpty() {
        String string = sc.nextLine().trim();
        // loop until string user enter not blank
        while (string.isEmpty()) {
            System.err.println("You can't leave it blank. Please enter again: ");
            string = sc.nextLine().trim();
        }
        return string;
    }
}
