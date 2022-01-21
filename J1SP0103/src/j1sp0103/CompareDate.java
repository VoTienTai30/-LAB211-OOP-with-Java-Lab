package j1sp0103;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CompareDate {

    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Check format of date
    public static boolean checkFormatDate(String date) {
        // loop until user doesn't leave date blank
        while (date.isEmpty()) {
            System.err.println("Date cannot be blank.");
            System.out.print("Enter again: ");
            date = sc.nextLine().trim();
        }

        // if day or month or year is not a number
        if (date.matches("\\D+/\\D+/\\D+")) {
            System.err.println("Day, month, year must be number");
            return false;
        } // if the input date there is no '/' separator between day, month, year 
        else if (date.matches("\\d+/\\d+/\\d+") == false) {
            System.err.println("Wrong format [dd/mm/yyyy], day, month, year are "
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
                    break;
                } // if this is not a leap year
                else {
                    // if number of days if not a positive number or > 28
                    if (day == 0 || day > 28) {
                        System.err.println("Number of days of February must be 1 -> 28");
                        return false;
                    }
                    break;
                }
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

    // Input a non empty string
    public static String inputNonEmptyString() {
        String s = sc.nextLine().trim();
        // loop until user input a non empty string
        while (s.isEmpty()) {
            System.err.println("This section cannot be left blank");
            System.out.print("Enter again: ");
            s = sc.nextLine().trim();
        }
        return s;
    }

    // Input date with format [dd/mm/yyyy]
    public static Date inputDate(String ordinal) throws ParseException {
        System.out.print("Please enter the " + ordinal + " date: ");
        String date = inputNonEmptyString();
        // loop until date user input correct format and exist
        while (true) {
            // if date user input incorrect format
            if (!checkFormatDate(date)) {
                System.out.print("Enter again: ");
                date = inputNonEmptyString();
            } // if date user input correct format
            else {
                break;
            }
        }
        return sdf.parse(date);
    }

    // Compare 2 dates
    public static String compareDates(Date date1, Date date2) {
        // if date 1 before date 2
        if (date1.before(date2)) {
            return "before";
        } // if date 1 after date 2
        else if (date1.after(date2)) {
            return "after";
        } else {
            return "same time";
        }
    }

    // Dispay result to screen
    public static void displayResult(String result) {
        System.out.println("\nDate1 is " + result + " Date2");
    }

    public static void main(String[] args) throws ParseException {
        // Step 1: User input the first date
        Date date1 = inputDate("first");
        
        // Step 2: User input the second date
        Date date2 = inputDate("second");

        // Step 3: Compare 2 dates user entered 
        String result = compareDates(date1, date2);

        // Step 4: Display result
        displayResult(result);
    }

}
