package j1sp0101;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class ManageEmployee {

    Scanner sc = new Scanner(System.in);
    GetInput get = new GetInput();
    ArrayList<Employee> list = new ArrayList<>();
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Display menu
    public void displayMenu() {
        System.out.println("=========== Employee Management System ===========");
        System.out.println("\t1. Add employee");
        System.out.println("\t2. Update employee");
        System.out.println("\t3. Remove employee");
        System.out.println("\t4. Search employee by name");
        System.out.println("\t5. Sort employees by salary");
        System.out.println("\t6. Exit");
        System.out.println("Enter your choice:");
    }

    // Check if ID of employee already exists
    public boolean checkIdExist(String id) {
        // traverse from the first employee to the last employee in the list
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            if (get.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    // Check and return salary user input if it is a positive number
    public double inputSalary() {
        double salary;
        // loop until user input a positive number
        while (true) {
            try {
                salary = Double.parseDouble(get.inputStringNotBlank());
                // if salary is not a positive number
                if (salary <= 0) {
                    System.err.println("Salary must be a positive number");
                    System.out.print("Enter again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println("Salary must be a positive number");
                System.out.print("Enter again: ");
            }
        }
        return salary;
    }

    // Check date user input if it is correct format [dd/MM/yyyy]
    public boolean checkFormatDate(String date) {
        // if day or month or year is not a number
        if (date.matches("\\D+/\\D+/\\D+")) {
            System.err.println("Day, month, year must be number");
            return false;
        } // if the input date there is no '/' separator between day, month, year 
        else if (date.matches("\\d+/\\d+/\\d+") == false) {
            System.err.println("Wrong format [dd/MM/yyyy], day, month, year are "
                    + "positive integers separated by '/'");
            return false;
        }

        String[] array = date.split("/");
        int day = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int year = Integer.parseInt(array[2]);
        // if number of months is not a positive number or > 12
        if (month == 0 || month > 12) {
            System.err.println("Number of months of a year must be 1 -> 12");
            return false;
        }

        switch (month) {
            // if this is January
            case 1:
                // if number of days if not a positive number or > 31
                if (day == 0 || day > 31) {
                    System.err.println("Number of days of January must be 1 -> 31");
                    return false;
                }
                break;
            // if this is February
            case 2:
                // if this is a leap year
                if (year % 4 == 0) {
                    // if number of days if not a positive number or > 29
                    if (day == 0 || day > 29) {
                        System.err.println("Number of days of February must be 1 -> 29");
                        return false;
                    }
                } // if this is not a leap year
                else {
                    // if number of days if not a positive number or > 28
                    if (day == 0 || day > 28) {
                        System.err.println("Number of days of February must be 1 -> 28");
                        return false;
                    }
                }
                break;
            // if this is March
            case 3:
                // if number of days if not a positive number or > 31
                if (day == 0 || day > 31) {
                    System.err.println("Number of days of March must be 1 -> 31");
                    return false;
                }
                break;
            // if this is April
            case 4:
                // if number of days if not a positive number or > 30
                if (day == 0 || day > 30) {
                    System.err.println("Number of days of April must be 1 -> 30");
                    return false;
                }
                break;
            // if this is May
            case 5:
                // if number of days if not a positive number or > 31 
                if (day == 0 || day > 31) {
                    System.err.println("Number of days of May must be 1 -> 31");
                    return false;
                }
                break;
            // if this is June
            case 6:
                // if number of days if not a positive number or > 30
                if (day == 0 || day > 30) {
                    System.err.println("Number of days of June must be 1 -> 30");
                    return false;
                }
                break;
            // if this is July
            case 7:
                // if number of days if not a positive number or > 31
                if (day == 0 || day > 31) {
                    System.err.println("Number of days of July must be 1 -> 31");
                    return false;
                }
                break;
            // if this is August
            case 8:
                // if number of days if not a positive number or > 31
                if (day == 0 || day > 31) {
                    System.err.println("Number of days of August must be 1 -> 31");
                    return false;
                }
                break;
            // if this is September
            case 9:
                // if number of days if not a positive number or > 30
                if (day == 0 || day > 30) {
                    System.err.println("Number of days of September must be 1 -> 30");
                    return false;
                }
                break;
            // if this is October
            case 10:
                // if number of days if not a positive number or > 31
                if (day == 0 || day > 31) {
                    System.err.println("Number of days of October must be 1 -> 31");
                    return false;
                }
                break;
            // if this is November
            case 11:
                // if number of days if not a positive number or > 30
                if (day == 0 || day > 30) {
                    System.err.println("Number of days of November must be 1 -> 30");
                    return false;
                }
                break;
            // if this is December
            case 12:
                // if number of days if not a positive number or > 31
                if (day == 0 || day > 31) {
                    System.err.println("Number of days of December must be 1 -> 31");
                    return false;
                }
                break;
        }
        return true;
    }

    // Check date user input is in the past
    public boolean checkDatePast(String date) {
        LocalDate now = LocalDate.now();
        String[] array = date.split("/");
        int day = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int year = Integer.parseInt(array[2]);
        LocalDate dateCompare = LocalDate.of(year, month, day);
        // if date user input is in the past
        if (now.compareTo(dateCompare) > 0) {
            return true;
        } // if date user input is today 
        else if (now.compareTo(dateCompare) == 0) {
            System.err.println("This date today");
            return false;
        } // if date user input is in the future 
        else {
            System.err.println("This date is not exists");
            return false;
        }
    }

    // Check if all the characters of string are numbers
    public boolean checkNumber(String number) {
        // traverse from the first character to the last character of string
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Check if string is correct email format
    public boolean checkFormatEmail(String email) {
        // if email contains space
        if (email.contains(" ")) {
            System.err.println("Email must not contain space");
            return false;
        }
        // if email not contain '@'
        if (!email.contains("@")) {
            System.err.println("Email must contains @ separating Local-part and "
                    + "Domain-name");
            return false;
        }
        // if email not have '.' between Domain-name
        if (email.matches("\\w+@\\w+") || email.matches("\\w+@\\w+\\.")
                || email.matches("\\w+@\\.\\w+")) {
            System.err.println("Email must have '.' between Domain-name");
            return false;
        }
        // if email not have Local-part and Domain-name
        if (email.matches("\\s*@\\w+\\.\\w+") || email.matches("\\w+@\\s*")
                || email.matches("\\s*@\\s*") || email.matches("\\s*@\\w+")) {
            System.err.println("Email must have Local-part and Domain-name");
            return false;
        }
        /* if email contains no space, has Local-part and Domain-name,
        contains @ separating Local-part and Domain-name, contains '.' with 
        subdomain in Domain-name */
        if (email.matches("\\w+@\\w+\\.\\w+")) {
            return true;
        }
        return false;
    }

    // Add a new employee to list
    public void addEmployee() {
        System.out.print("Enter ID: ");
        String id = get.inputStringNotBlank();
        // loop until ID not duplicated
        while (checkIdExist(id)) {
            System.err.println("This ID already exists");
            System.out.print("Enter again: ");
            id = get.inputStringNotBlank();
        }
        System.out.print("Enter First Name: ");
        String firstName = get.inputStringNotBlank();
        System.out.print("Enter Last Name: ");
        String lastName = get.inputStringNotBlank();
        System.out.print("Enter Phone: ");
        String phone = get.inputStringNotBlank();
        /* loop until all characters of phone number is number and 
        number of characters of phone number >= 10 */
        while (true) {
            // if any characters of phone number is not number
            if (!checkNumber(phone)) {
                System.err.println("Phone number must be digit");
                System.out.print("Enter again: ");
                phone = get.inputStringNotBlank();
            } // if number of characters of phone number < 10
            else if (phone.length() < 10) {
                System.err.println("phone number must have more than 9 digits");
                System.out.print("Enter again: ");
                phone = get.inputStringNotBlank();
            } else {
                break;
            }
        }
        System.out.print("Enter Email: ");
        String email = get.inputStringNotBlank();
        // loop until the email is in the correct format
        while (!checkFormatEmail(email)) {
            System.out.print("Enter again: ");
            email = get.inputStringNotBlank();
        }
        System.out.print("Enter Address: ");
        String address = get.inputStringNotBlank();
        System.out.print("Enter Date of Birth: ");
        String strDate = get.inputStringNotBlank();
        // loop until user input date correct format and date is not present or future
        while (true) {
            // if user input date incorrect format
            if (!checkFormatDate(strDate)) {
                System.out.print("Enter again: ");
                strDate = get.inputStringNotBlank();
            } // if user input date is present or future 
            else if (!checkDatePast(strDate)) {
                System.out.print("Enter again: ");
                strDate = get.inputStringNotBlank();
            } else {
                break;
            }
        }
        Date dateOfBirth = null;
        try {
            dateOfBirth = sdf.parse(strDate);
        } catch (ParseException ex) {
            System.err.println("Error!");
        }
        System.out.print("Enter Sex: ");
        String sex = get.inputSex();
        System.out.print("Enter Salary: ");
        double salary = inputSalary();
        System.out.print("Enter Agency: ");
        String agency = get.inputStringNotBlank();
        Employee newEmployee = new Employee(id, firstName, lastName, phone,
                email, address, dateOfBirth, sex, salary, agency);
        list.add(newEmployee);
    }

    // Update information of employee by ID
    public void updateInformationById() {
        // if list of employee is empty
        if (list.isEmpty()) {
            System.out.println("List of employee is empty!");
            return;
        }
        System.out.print("Enter ID: ");
        String idUpdate = get.inputStringNotBlank();
        int position = -1;
        // traverse from the first employee to the last employee in the list
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            // if ID user input is the same as the employee ID
            if (get.getId().equalsIgnoreCase(idUpdate)) {
                position = i;
            }
        }
        // if no employee is found with the same ID as the user entered
        if (position == -1) {
            System.out.println("Employee whose ID is " + idUpdate + " does not "
                    + "exist in the list");
            return;
        }
        Employee clearEmployee = new Employee("", "", "", "", "", "", null, "", -1, "");
        list.set(position, clearEmployee);
        System.out.print("Enter new ID: ");
        String id = get.inputStringNotBlank();
        // loop until ID not duplicated
        while (checkIdExist(id)) {
            System.err.println("This ID already exists");
            System.out.print("Enter again: ");
            id = get.inputStringNotBlank();
        }
        System.out.print("Enter new First Name: ");
        String firstName = get.inputStringNotBlank();
        System.out.print("Enter new Last Name: ");
        String lastName = get.inputStringNotBlank();
        System.out.print("Enter Phone: ");
        String phone = get.inputStringNotBlank();
        /* loop until all characters of phone number is number and 
        number of characters of phone number >= 10 */
        while (true) {
            // if any characters of phone number is not number
            if (!checkNumber(phone)) {
                System.err.println("Phone number must be digit");
                System.out.print("Enter again: ");
                phone = get.inputStringNotBlank();
            } // if number of characters of phone number < 10
            else if (phone.length() < 10) {
                System.err.println("phone number must have more than 9 digits");
                System.out.print("Enter again: ");
                phone = get.inputStringNotBlank();
            } else {
                break;
            }
        }
        System.out.print("Enter new Email: ");
        String email = get.inputStringNotBlank();
        // loop until the email is in the correct format
        while (!checkFormatEmail(email)) {
            System.out.print("Enter again: ");
            email = get.inputStringNotBlank();
        }
        System.out.print("Enter new Address: ");
        String address = get.inputStringNotBlank();
        System.out.print("Enter new Date of Birth: ");
        String strDate = get.inputStringNotBlank();
        // loop until user input date correct format and date is not present or future
        while (true) {
            // if user input date incorrect format
            if (!checkFormatDate(strDate)) {
                System.out.print("Enter again: ");
                strDate = get.inputStringNotBlank();
            } // if user input date is present or future 
            else if (!checkDatePast(strDate)) {
                System.out.print("Enter again: ");
                strDate = get.inputStringNotBlank();
            } else {
                break;
            }
        }
        Date dateOfBirth = null;
        try {
            dateOfBirth = sdf.parse(strDate);
        } catch (ParseException ex) {
            System.err.println("Error!");
        }
        System.out.print("Enter new Sex: ");
        String sex = get.inputSex();
        System.out.print("Enter new Salary: ");
        double salary = inputSalary();
        System.out.print("Enter new Agency: ");
        String agency = get.inputStringNotBlank();
        Employee employeeUpdate = new Employee(id, firstName, lastName, phone,
                email, address, dateOfBirth, sex, salary, agency);
        list.set(position, employeeUpdate);
        System.out.println("Update successful!");
    }

    // Remove employee by ID
    public void removeEmployeeById() {
        // if list of employee is empty
        if (list.isEmpty()) {
            System.out.println("List of employee is empty!");
            return;
        }
        System.out.print("Enter ID: ");
        String idRemove = get.inputStringNotBlank();
        int position = -1;
        // traverse from the first employee to the last employee in the list
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            // if ID user input is the same as the employee ID
            if (get.getId().equalsIgnoreCase(idRemove)) {
                position = i;
            }
        }
        // if no employee is found with the same ID as the user entered
        if (position == -1) {
            System.out.println("Employee whose ID is " + idRemove + " does not "
                    + "exist in the list");
            return;
        }
        list.remove(position);
        System.out.println("Remove successful!");
    }

    /* Find employees by Name (First Name or Last Name) or a part of name */
    public void findEmployeeByName() {
        // if list of employee is empty
        if (list.isEmpty()) {
            System.out.println("List of employee is empty!");
            return;
        }
        System.out.print("Enter name or a part of name: ");
        String employeeFound = get.inputStringNotBlank();
        ArrayList<Employee> listFindByName = new ArrayList<>();
        // traverse from the first employee to the last employee in the list
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            /* if name or part of name user input is the same as the employee name 
            or part of name */
            if ((get.getFirstName() + get.getLastName()).toLowerCase().
                    contains(employeeFound.toLowerCase())) {
                listFindByName.add(get);
            }
        }
        // if no employee is found with the same name or part of name as the user entered
        if (listFindByName.isEmpty()) {
            System.out.println("Employee whose name or part of name is "
                    + employeeFound + " does not exist in the list");
            return;
        }
        displayList(listFindByName);
    }

    // Display a list
    public void displayList(ArrayList<Employee> list) {
        System.out.printf("%-8s%-15s%-15s%-15s%-20s%-15s%-18s%-8s%-15s%-20s\n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                "Date of Birth", "Sex", "Salary", "Agency");
        // traverse from the first employee to the last employee in the list
        for (int i = 0; i < list.size(); i++) {
            Employee get = list.get(i);
            System.out.printf("%-8s%-15s%-15s%-15s%-20s%-15s%-18s%-8s%-15s%-20s\n",
                    get.getId(), get.getFirstName(), get.getLastName(), get.getPhone(),
                    get.getEmail(), get.getAddress(), sdf.format(get.getDateOfBirth()),
                    get.getSex(), get.getSalary(), get.getAgency());
        }
    }

    // Sort and display employees by salary
    public void sortEmployeeBySalary() {
        // if list of employee is empty
        if (list.isEmpty()) {
            System.out.println("List of employee is empty!");
            return;
        }
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee t, Employee t1) {
                // if salary of emplyee 1 > salary of employee 2
                if (t.getSalary() > t1.getSalary()) {
                    return 1;
                } // if salary of emplyee 1 < salary of employee 2 
                else if (t.getSalary() < t1.getSalary()) {
                    return -1;
                } // if salary of emplyee 1 = salary of employee 2
                else {
                    return 0;
                }
            }
        });
        displayList(list);
    }

}
