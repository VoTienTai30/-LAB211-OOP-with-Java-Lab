package j1sp0057;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class ManagerAccount {

    static GetInput get = new GetInput();

    static void displayMenu() {
        System.out.println("====== USER MANAGEMENT SYSTEM ======");
        System.out.println("1. Create a new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
        System.out.print("> Choose: ");
    }

    static void exitProgram() {
        System.exit(0);
    }

    static void createNewAccount() throws IOException {
        // get new username from user
        String newUserName = get.getNewUserName();
        // get password from user
        String newPassword = get.getPassword();
        // add account to program
        addAccount(newUserName, newPassword);
    }

    static void addAccount(String newUserName, String newPassword) throws IOException {
        FileWriter writer = new FileWriter("user.dat", true);
        Account newAccount = new Account(newUserName, newPassword);
        writer.write(newAccount.toString());
        writer.write("\n");
        writer.close();
    }
    
    private static ArrayList<Account> getListAccountFromFile() {
        ArrayList<Account> listAccount = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("user.dat"));
            String line;
            // read file until no more line to read
            while ((line = reader.readLine()) != null) {
                String arr[] = line.split(" ");
                String userName = arr[0].trim();
                String password = arr[1].trim();
                listAccount.add(new Account(userName, password));
            }
            return listAccount;
        } catch (IOException e) {
            return null;
        }

    }

    static void loginSystem() throws IOException {
        ArrayList<Account> listAccount = new ArrayList<>();
        listAccount = getListAccountFromFile();
        // if don't have any account in list
        if (listAccount == null || listAccount.isEmpty()) {
            System.out.println("Don't have any account.");
            return;
        }
        boolean isSuccess = false;
        // loop until user enter correct username and password
        while (true) {
            String userNameLogin = get.getUserNameLogin();
            String passwordLogin = get.getPassword();
            // traverse from first account to last account in list
            for (Account account : listAccount) {
                /* if account has username same as username user input 
                and password same as password user input */
                if (account.getUserName().equalsIgnoreCase(userNameLogin)
                        && account.getPassWord().equalsIgnoreCase(passwordLogin)) {
                    isSuccess = true;
                    break;
                }
            }
            // if user login success 
            if (isSuccess == true) {
                System.out.println("Login successful!");
                break;
            } // if user login fail with username and password don't exist in list account
            else {
                System.out.println("Wrong user name or password");
            }
        }
    }

}
