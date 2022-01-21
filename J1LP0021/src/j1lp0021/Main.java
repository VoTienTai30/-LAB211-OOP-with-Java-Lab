package j1lp0021;

public class Main {

    public static void main(String[] args) {
        ManageStudent manager = new ManageStudent();
        GetInput get = new GetInput();
        // Loop until user choose exit
        while (true) {
            // 1. Display menu
            manager.displayMenu();
            // 2. Input option
            int option = get.inputOption();
            switch (option) {
                case 1:
                    // 3. Create at least 10 students by inputting information
                    manager.createStudent();
                    break;
                case 2:
                    // 4. Find and sort student list just found by name
                    manager.findSortByName();
                    break;
                case 3:
                    // 5. Update/Delete student by ID
                    manager.updateDeleteById();
                    break;
                case 4:
                    // 6. Display all students with total Courses of this student
                    manager.displayAllStudentWithCourses();
                    break;
                case 5:
                    break;
            }
            // If user choose exit
            if (option == 5) {
                break;
            }
        }
    }

}
