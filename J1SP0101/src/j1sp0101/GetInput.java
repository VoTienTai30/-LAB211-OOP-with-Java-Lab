package j1sp0101;

import java.util.Scanner;

public class GetInput {

    Scanner sc = new Scanner(System.in);

    // User input a string and return it if it is not blank
    public String inputStringNotBlank() {
        String s = sc.nextLine().trim();
        // loop until string is not blank
        while (s.isEmpty()) {
            System.err.println("This section cannot be blank");
            System.out.print("Enter again: ");
            s = sc.nextLine().trim();
        }
        return s;
    }

    // Return option user select if it is valid
    public int inputOption() {
        int option;
        // loop until user input a valid option
        while (true) {
            try {
                option = Integer.parseInt(inputStringNotBlank());
                // if option is < 1 or > 6
                if (option < 1 || option > 6) {
                    System.err.println("Your choice must be 1 -> 6");
                    System.out.print("Enter again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println("Your choice must be positive integer ");
                System.out.print("Enter again: ");
            }
        }
        return option;
    }
    
    // User input sex and return sex if it is male or female or others
    public String inputSex() {
        String sex = inputStringNotBlank();
        // loop until sex is male or female or others
        while (!sex.equalsIgnoreCase("male") && !sex.equalsIgnoreCase("female") 
                && !sex.equalsIgnoreCase("others")) {
            System.err.println("Sex must be male or female or others");
            System.out.print("Enter again: ");
            sex = inputStringNotBlank();
        }
        return sex;
    }
}
