package j1lp0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageStudent {

    GetInput getInput = new GetInput();
    ArrayList<Student> list = new ArrayList<>();

    // Display menu
    public void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
        System.out.println("");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to"
                + " Update/Delete, 4 to Report and 5 to Exit program).");
    }

    /* Check if the student user just entered is duplicated ID, semester and 
    course name with another student */
    public boolean checkStudentDuplicated(String id, String courseName, int semester) {
        // traverse from the first student to the last student in the list
        for (int i = 0; i < list.size(); i++) {
            Student get = list.get(i);
            // if this student has same ID, semester, course name as the user entered
            if (get.getId().equalsIgnoreCase(id) && get.getSemester() == semester
                    && get.getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    // Check if the ID already exists
    public boolean checkIdExist(String id) {
        // traverse from the first student to the last student in the list
        for (int i = 0; i < list.size(); i++) {
            Student get = list.get(i);
            // if this student has same ID as the user entered
            if (get.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    // Create a student by inputting information
    public void createStudent() {
        String id;
        String studentName;
        int semester;
        String courseName;
        String choice = "y";
        // if student list has > 10 records
        if (list.size() >= 2) {
            System.out.println("Student list has enough students. Do you want to"
                    + " continue (Y/N)? Choose Y to continue, N to return main screen.");
            choice = getInput.inputYesNo();
        }
        // if user doesn't want to continue create student
        if (choice.equalsIgnoreCase("n")) {
            return;
        } else {
            /* loop until all ID, semester and course name are not same as 
            ID, semester and course name of another student in the list */
            do {
                System.out.print("Enter ID: ");
                id = getInput.inputNotBlank();
                System.out.print("Enter student name: ");
                /* if this is the first time input name for student has ID same 
                as ID user just entered */
                if (!checkIdExist(id)) {
                    studentName = getInput.inputNotBlank();
                } else {
                    studentName = getInput.inputNotBlank();
                    // traverse from the first student to the last student in the list
                    for (int i = 0; i < list.size(); i++) {
                        Student get = list.get(i);
                        // if this student has same ID as the user entered
                        if (get.getId().equalsIgnoreCase(id)) {
                            // loop until this student have same name as the user just entered
                            while (!get.getStudentName().equalsIgnoreCase(studentName)) {
                                System.err.print("Name of the student with ID "
                                        + get.getId() + " is " + get.getStudentName()
                                        + ". Enter again: ");
                                studentName = getInput.inputNotBlank();
                            }
                            break;
                        }
                    }
                }
                System.out.print("Enter semester: ");
                semester = getInput.inputPositiveInt();
                System.out.print("Enter course name: ");
                courseName = getInput.inputCourseName();
                // if the student user just created is the same as another student 
                if (checkStudentDuplicated(id, courseName, semester)) {
                    System.err.println("This student already exists in the list. "
                            + "Create student again:");
                } // if the student user just created is not the same as another student
                else {
                    Student student = new Student(id, studentName, semester, courseName);
                    list.add(student);
                    System.out.println("Create student successful!");
                    System.out.println("");
                    break;
                }
            } while (true);
        }
    }

    // Find and sort student list just found by name
    public void findSortByName() {
        ArrayList<Student> listFindByName = new ArrayList<>();
        // if student list is empty
        if (list.isEmpty()) {
            System.out.println("Student list is empty!");
        } // if student list is not empty
        else {
            String name = getInput.inputName();
            // traverse from the first student to the last student in the list
            for (int i = 0; i < list.size(); i++) {
                Student get = list.get(i);
                // if this student's name contains student name or a part of student name
                if (get.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                    listFindByName.add(get);
                }
            }
            Collections.sort(listFindByName, new Comparator<Student>() {
                @Override
                public int compare(Student t, Student t1) {
                    return t.getStudentName().compareTo(t1.getStudentName());
                }
            });
            /* if no student can be found with the same name or part of the name
            as the user entered */
            if (listFindByName.isEmpty()) {
                System.out.println("There are no students with the same name or "
                        + "part of name you just entered!");
            } // if student list find by name is not empty
            else {
                // traverse from the first student to the last student in the list
                System.out.printf("%-20s%-20s%-10s\n", "Student name", 
                        "Semester", "Course name");
                /* traverse from the first student to the last student in the 
                student list find by name */
                for (int i = 0; i < listFindByName.size(); i++) {
                    Student get = listFindByName.get(i);
                    System.out.printf("%-20s%-20s%-10s\n", get.getStudentName(), 
                            get.getSemester(), get.getCourseName());
                }
            }
        }
        System.out.println("");
    }

    public void updateDeleteById() {
        String idUD = getInput.inputID();
        // if student list is empty
        if (list.isEmpty()) {
            System.out.println("Student list is empty!");
            System.out.println("");
        } // if no student can be found with the same ID as the user entered
        else if (checkIdExist(idUD) == false) {
            System.out.println("There are no students with the same ID you just entered!");
        } // if found any student with the same ID as the user entered
        else {
            System.out.println("Do you want to update (U) or delete (D) student."
                    + " Chooses U to update, D to delete student.");
            String optionDelUpd = getInput.inputDeleteOrUpdate();
            int position = -1;
            ArrayList<Student> listFindById = new ArrayList<>();
            // traverse from the first student to the last student in the list
            for (int i = 0; i < list.size(); i++) {
                Student get = list.get(i);
                // if this student has same ID as the user entered
                if (get.getId().equalsIgnoreCase(idUD)) {
                    listFindById.add(get);
                }
            }

            // if the record list of student found by ID has only 1 record
            if (listFindById.size() == 1) {
                // traverse from the first student to the last student in the list
                for (int i = 0; i < list.size(); i++) {
                    Student get = list.get(i);
                    // if this student has the same ID as the ID user just entered
                    if (get.getId().equalsIgnoreCase(idUD)) {
                        position = i;
                    }
                }
            } // if the record list of student found by ID has > 1 record
            else {
                System.out.println("All records of student with ID " + idUD + ": ");
                System.out.printf("%-20s%-20s%-10s\n", "Student ID", "Semester", 
                        "Course name");
                /* traverse from the first record to the last record in the 
                record list of student found by ID */
                for (int i = 0; i < listFindById.size(); i++) {
                    Student get = listFindById.get(i);
                    System.out.printf("%-20s%-20s%-10s\n", get.getId(), 
                            get.getSemester(), get.getCourseName());
                }

                // if user choose update
                if (optionDelUpd.equalsIgnoreCase("u")) {
                    System.out.print("Enter the semester of the record need to update: ");
                } // if user choose delete
                else {
                    System.out.print("Enter the semester of the record need to delete: ");
                }

                int semesterUD = getInput.inputPositiveInt();
                boolean checkExist = false;
                /* loop until user input a semester exist in the record list of 
                student found by ID */
                while (true) {
                    /* traverse from the first record to the last record in the 
                    record list of student found by ID */
                    for (int i = 0; i < listFindById.size(); i++) {
                        Student get = listFindById.get(i);
                        // if this record has same semester as the user just entered
                        if (get.getSemester() == semesterUD) {
                            checkExist = true;
                        }
                    }
                    /* if semester user just entered does not exist in the record 
                    list of student found by ID */
                    if (checkExist == false) {
                        System.err.print("This semester does not exist in the "
                                + "record list of student found by ID. Enter again: ");
                        semesterUD = getInput.inputPositiveInt();
                    } /* if semester user just entered exist in the record list 
                    of student found by ID */
                    else {
                        break;
                    }
                }

                /* traverse from the first record to the last record in 
                the record list of student found by ID */
                for (int i = 0; i < listFindById.size(); i++) {
                    Student get = listFindById.get(i);
                    // if this record has same semester as the user entered
                    if (get.getSemester() != semesterUD) {
                        listFindById.remove(i);
                        i--;
                    }
                }

                String courseUD;
                // if the record list of student found by ID has only 1 record left
                if (listFindById.size() == 1) {
                    // traverse from the first student to the last student in the list
                    for (int i = 0; i < list.size(); i++) {
                        Student get = list.get(i);
                        /* if this student has the same ID and semster as the ID
                        and semester the user just entered */
                        if (get.getId().equalsIgnoreCase(idUD) && get.getSemester() 
                                == semesterUD) {
                            position = i;
                        }
                    }
                } // if the record list of student found by ID has > 1 record
                else {
                    System.out.println("All records of student with ID " + idUD 
                            + " and in semester " + semesterUD + ": ");
                    System.out.printf("%-20s%-20s%-10s\n", "Student ID", 
                            "Semester", "Course name");
                    /* traverse from the first record to the last record in the 
                    record list of student found by ID */
                    for (int i = 0; i < listFindById.size(); i++) {
                        Student get = listFindById.get(i);
                        System.out.printf("%-20s%-20s%-10s\n", get.getId(), 
                                get.getSemester(), get.getCourseName());
                    }

                    // if user choose update
                    if (optionDelUpd.equalsIgnoreCase("u")) {
                        System.out.print("Enter the course name of the record "
                                + "need to update: ");
                    } // if user choose delete
                    else {
                        System.out.print("Enter the course name of the record "
                                + "need to delete: ");
                    }

                    courseUD = getInput.inputCourseName();
                    checkExist = false;
                    /* loop until user input a course name exist in the record list 
                    of student found by ID */
                    while (true) {
                        /* traverse from the first record to the last record in 
                        the record list of student found by ID */
                        for (int i = 0; i < listFindById.size(); i++) {
                            Student get = listFindById.get(i);
                            // if this record has same course name as the user just entered
                            if (get.getCourseName().equalsIgnoreCase(courseUD)) {
                                checkExist = true;
                            }
                        }
                        /* if course name user just entered does not exist in the 
                        record list of student found by ID */
                        if (checkExist == false) {
                            System.err.print("This course name does not exist in"
                                    + " the record list of student found by ID. Enter again: ");
                            courseUD = getInput.inputCourseName();
                        } /* if course name user just entered exist in the record 
                        list of student found by ID */
                        else {
                            break;
                        }
                    }

                    // traverse from the first student to the last student in the list
                    for (int i = 0; i < list.size(); i++) {
                        Student get = list.get(i);
                        /* if this student has the same ID, semster and course name 
                        as the ID, semster and course name the user just entered */
                        if (get.getId().equalsIgnoreCase(idUD) && get.getSemester() 
                                == semesterUD && get.getCourseName().equalsIgnoreCase(courseUD)) {
                            position = i;
                        }
                    }
                }
            }

            // if user choose update
            if (optionDelUpd.equalsIgnoreCase("u")) {
                String id;
                String studentName;
                int semester;
                String courseName;
                Student clearStudent = new Student("", "", -1, "");
                list.set(position, clearStudent);
                /* loop until all ID, semester and course name are not same as 
                ID, semester and course name of another student in the list */
                do {
                    System.out.print("Enter new ID: ");
                    id = getInput.inputNotBlank();
                    System.out.print("Enter new student name: ");
                    studentName = getInput.inputNotBlank();
                    // traverse from the first student to the last student in the list
                    for (int i = 0; i < list.size(); i++) {
                        Student get = list.get(i);
                        // if this student has the same ID as the student being updated 
                        if (get.getId().equalsIgnoreCase(id)) {
                            get.setStudentName(studentName);
                        }
                    }
                    System.out.print("Enter new semester: ");
                    semester = getInput.inputPositiveInt();
                    System.out.print("Enter new course name: ");
                    courseName = getInput.inputCourseName();
                    // if the student user just updated is the same as another student 
                    if (checkStudentDuplicated(id, courseName, semester)) {
                        System.err.println("This student already exists in the list. "
                                + "Update student again:");
                    } // if the student user just updated is not the same as another student
                    else {
                        Student student = new Student(id, studentName, semester,
                                courseName);
                        list.set(position, student);
                        System.out.println("Update successful!");
                        System.out.println("");
                        break;
                    }
                } while (true);
            } // if user choose delete
            else {
                list.remove(position);
                System.out.println("Delete successful!");
                System.out.println("");
            }
        }
    }

    // Display student with total Courses of this student
    public void displayStudentWithCourses(String id) {
        String name = "";
        int java = 0;
        int net = 0;
        int c = 0;
        // traverse from the first student to the last student in the list
        for (int i = 0; i < list.size(); i++) {
            Student get = list.get(i);
            // if this student's ID is same as ID of student need to display total Course
            if (get.getId().equalsIgnoreCase(id)) {
                name = get.getStudentName();
                // if this student is study Java course
                if (get.getCourseName().equalsIgnoreCase("java")) {
                    java++;
                } // if this student is study .Net course
                if (get.getCourseName().equalsIgnoreCase(".net")) {
                    net++;
                } // if this student is study C/C++ course
                if (get.getCourseName().equalsIgnoreCase("c/c++")) {
                    c++;
                }
            }
        }
        // if student learned Java
        if (java != 0) {
            System.out.printf("%-20s%-20s%-20s%-10s\n", id, name, "Java", java);
        }
        // if student learned .Net
        if (net != 0) {
            System.out.printf("%-20s%-20s%-20s%-10s\n", id, name, ".Net", net);
        }
        // if student learned C/C++
        if (c != 0) {
            System.out.printf("%-20s%-20s%-20s%-10s\n", id, name, "C/C++", c);
        }

    }

    // Display all student with total Courses
    public void displayAllStudentWithCourses() {
        // if student list is not empty
        if (!list.isEmpty()) {
            ArrayList<String> listId = new ArrayList<>();
            // traverse from the first student to the last student in the list
            for (int i = 0; i < list.size(); i++) {
                Student get = list.get(i);
                // if this student's ID is not in listId
                if (!listId.contains(get.getId())) {
                    listId.add(get.getId());
                }
            }
            System.out.printf("%-20s%-20s%-20s%-10s\n", "Student ID", "Student name",
                    "Course", "Total of Course");
            // traverse from the first ID to the last ID in the listId
            for (int i = 0; i < listId.size(); i++) {
                String get = listId.get(i);
                displayStudentWithCourses(get);
            }
            System.out.println("");
        } // if student list is empty
        else {
            System.out.println("Student list is empty!");
            System.out.println("");
        }
    }

}
