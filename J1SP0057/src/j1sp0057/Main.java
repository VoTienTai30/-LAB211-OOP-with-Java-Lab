package j1sp0057;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GetInput get = new GetInput();
        //loop until user want to exit
        while (true) {
            // Step 1: Display menu for user
            ManagerAccount.displayMenu();
            // Step 2: Get choice from user
            int choice = get.getChoice();
            switch (choice) {
                case 1: {
                    // Step 3: Create new account
                    ManagerAccount.createNewAccount();
                    break;
                }
                case 2: {
                    // Step 4 : Login System   
                    ManagerAccount.loginSystem();
                    break;
                }
                case 3: {
                    // Step 5: Exit program  
                    ManagerAccount.exitProgram();
                    break;
                }
            }
        }
    }

}
