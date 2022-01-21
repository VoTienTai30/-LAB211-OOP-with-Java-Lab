package j1sp0057;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class GetInput {

    Scanner sc = new Scanner(System.in);

    String inputNotBlank() {
        String result = sc.nextLine().trim();
        // loop until user input a string not blank
        while (result.isEmpty()) {
            System.err.print("You cannot leave this section blank. Enter again: ");
            result = sc.nextLine().trim();
        }
        return result;
    }

    int getChoice() {
        String choice;
        // Loop until the user inputs the correct value 
        while (true) {
            choice = inputNotBlank();
            try {
                int choiceNum = Integer.parseInt(choice);
                // if user enter choice in range 1 -> 3
                if (choiceNum >= 1 && choiceNum <= 3) {
                    return choiceNum;
                } // if user enter choice out of range 1 -> 3
                else {
                    System.err.print("Your choice must be in range 1 -> 3. Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.print("Your choice must be integer. Enter again: ");
            }
        }
    }
    
    boolean isUserNameExist(String userName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("user.dat"));
        String line;
        // loop until read all data in file
        while ((line = reader.readLine()) != null) {            
            String a[];
            a = line.split(" ");
            if(a[0].equalsIgnoreCase(userName)) {
                return true;
            }
        }
        return false;
    }
    
    String getNewUserName() throws IOException {
        File fileName = new File("user.dat");
        // if file has not exist
        if (!fileName.exists()) {
            fileName.createNewFile();
        }
        String userName;
        // loop until user enter valid username
        while (true) {
            System.out.print("Enter Username: ");
            userName = sc.nextLine();
            // if username has length less than 5 or contain space
            if (userName.length() < 5 || userName.contains(" ")) {
                System.out.println("Your must enter least at 5 character, and no space!");
            } // if username has length at least 5 and no contain space
            else {
                // if username has not exist
                if (!isUserNameExist(userName)) {
                    return userName;
                } // if username has already exist
                else {
                    System.out.println("Username has already exist. Enter again");
                }

            }
        }
    }
    
    String getPassword() {
        String passWord;
        // loop until user enter valid password
        while (true) {
            System.out.print("Enter Password: ");
            passWord = sc.nextLine();
            // if password has length less than 6 or contain space
            if (passWord.length() < 6 || passWord.contains(" ")) {
                System.out.println("You must enter least at 6 character, and no space!");
            } // if username has length at least 6 and no contain space
            else {
                return passWord;
            }
        }
    }
    
    String getUserNameLogin() {
        String userName;
        // loop until user enter valid username
        while (true) {
            System.out.print("Enter Username: ");
            userName = sc.nextLine();
            // if username has length less than 5 or contain space
            if (userName.length() < 5 || userName.contains(" ")) {
                System.out.println("Your must enter least at 5 character, and no space!");
            } // if username has length at least 5 and no contain space
            else {
                return userName;
            }
        }
    }

}
