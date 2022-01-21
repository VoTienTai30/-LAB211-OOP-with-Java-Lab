package j1sp0101;

public class Main {

    public static void main(String[] args) {
        GetInput get = new GetInput();
        ManageEmployee manager = new ManageEmployee();
        // Loop until user choose exit
        while (true) {
            // 1. Display menu
            manager.displayMenu();
            // 2. User input an option
            int option = get.inputOption();
            switch (option) {
                case 1:
                    // 3. Add an employee to list
                    manager.addEmployee();
                    break;
                case 2:
                    // 4. Update information of employee found by ID
                    manager.updateInformationById();
                    break;
                case 3:
                    // 5. Remove employee found by ID
                    manager.removeEmployeeById();
                    break;
                case 4:
                    /* 6. Find employees by Name (First Name or Last Name) or 
                    a part of name */
                    manager.findEmployeeByName();
                    break;
                case 5:
                    // 7. Sort employees by salary
                    manager.sortEmployeeBySalary();
                    break;
                case 6:
                    break;
            }
            // if user choose exit
            if (option == 6) {
                break;
            }
        }
    }

}
