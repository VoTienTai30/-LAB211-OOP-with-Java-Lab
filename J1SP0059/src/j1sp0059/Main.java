package j1sp0059;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        HandleFile handle = new HandleFile();
        GetInput get = new GetInput();
        // loop until user want to exit program
        while (true) {
            // 1. Display menu and ask user to select option
            handle.displayMenu();
            // 2. Get select from user
            int option = get.getOption();
            switch (option) {
                // 3. Find person info
                case 1: {
                    handle.findPerson();
                    break;
                }
                // 4. Copy text to new file
                case 2: {
                    handle.copyText();
                    break;
                }
                // 5. Exit program
                case 3: {
                    handle.exitProgram();
                    break;
                }
            }
        }
    }

}
