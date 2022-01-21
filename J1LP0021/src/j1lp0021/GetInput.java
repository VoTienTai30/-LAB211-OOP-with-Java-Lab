package j1lp0021;

import java.util.Scanner;

public class GetInput {

    Scanner sc = new Scanner(System.in);

    // Input a string is not blank
    public String inputNotBlank() {
        String result = sc.nextLine().trim();
        // loop until user input a string not blank
        while (result.isEmpty()) {
            System.err.print("You cannot leave this section blank. Enter again: ");
            result = sc.nextLine().trim();
        }
        return result;
    }

    // Input a positive integer
    public int inputPositiveInt() {
        int result;
        // loop until user input a positive integer
        while (true) {
            try {
                result = Integer.parseInt(inputNotBlank());
                // if user not input a positive integer
                if (result <= 0) {
                    System.err.print("You must enter a positive integer. Enter again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.print("You must enter a positive integer. Enter again: ");
            }
        }
        return result;
    }

    // Input an option is integer in range [1, 5]
    public int inputOption() {
        int option;
        // loop until user enter an integer in range [1, 5]
        while (true) {
            option = inputPositiveInt();
            // if user enter an integer > 5
            if (option > 5) {
                System.err.print("Your choice must be 1 -> 5. Enter again: ");
            } else {
                break;
            }
        }
        return option;
    }

    // Input course name is Java or .Net or C/C++
    public String inputCourseName() {
        String courseName = inputNotBlank();
        // loop until course name user entered is Java or .Net or C/C++
        while (!courseName.equalsIgnoreCase("java") && !courseName.equalsIgnoreCase(".Net")
                && !courseName.equalsIgnoreCase("C/C++")) {
            System.err.print("Course name must be Java or .Net or C/C++. Enter again: ");
            courseName = inputNotBlank();
        }
        return courseName;
    }

    // Input choice is Yes or No
    public String inputYesNo() {
        String choice = inputNotBlank();
        // loop until choice is Y or N
        while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
            System.err.print("Your choice must be Y or N. Enter again: ");
            choice = inputNotBlank();
        }
        return choice;
    }

    // Input student name or a part of student name
    public String inputName() {
        System.out.print("Enter student name or a part of student name: ");
        String name = inputNotBlank();
        return name;
    }

    // Input student ID
    public String inputID() {
        System.out.print("Enter student ID: ");
        String id = inputNotBlank();
        return id;
    }

    // Input choice is (D) delete or (U) update 
    public String inputDeleteOrUpdate() {
        String choice = inputNotBlank();
        // loop until user's choice is U or D
        while (!choice.equalsIgnoreCase("U") && !choice.equalsIgnoreCase("D")) {
            System.err.print("Your choice must be U or D. Enter again: ");
            choice = inputNotBlank();
        }
        return choice;
    }

}
