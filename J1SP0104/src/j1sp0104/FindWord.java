package j1sp0104;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindWord {

    static Scanner sc = new Scanner(System.in);

    // Input a string is not blank
    public static String inputNotBlank() {
        String s = sc.nextLine().trim();
        // loop until string is not empty
        while (s.isEmpty()) {
            System.err.print("You cannot leave this section blank, enter again: ");
            s = sc.nextLine().trim();
        }
        return s;
    }

    // Input directory of file
    public static String inputDirectory() {
        System.out.print("Please enter directory of file:  ");
        String directory;
        // loop until user input valid directory of file
        while (true) {
            try {
                directory = inputNotBlank();
                File f = new File(directory);
                FileReader fr = new FileReader(f);
                fr.close();
                break;
            } catch (IOException e) {
                System.err.print("File doesn't exist, enter again: ");
            }
        }
        return directory;
    }

    // Input string to search
    public static String inputStringToSearch() {
        System.out.print("Please enter string to search: ");
        String searchString = sc.nextLine().trim();
        return searchString;
    }

    // Search string or letter words contain input string
    public static ArrayList<String> searchString(String stringToSearch, String directory) {
        ArrayList<String> result = new ArrayList<>();
        try {
            File f = new File(directory);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            // loop until all lines of the file are read
            while ((line = br.readLine()) != null) {
                String[] array = line.split(" ");
                // traverse from the first word to the last word
                for (int i = 0; i < array.length; i++) {
                    String string = array[i];
                    // if word contains the string need to search
                    if (string.contains(stringToSearch)) {
                        // add word to list
                        result.add(string);
                    }
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("File doesn't exist!");
        }
        return result;
    }

    // Display result to screen
    public static void displayResult(ArrayList<String> result) {
        System.out.println("\nSearch results:");
        // traverse the array list from the first element to the last element
        for (int i = 0; i < result.size(); i++) {
            String get = result.get(i);
            System.out.println("     " + get);
        }
        System.out.println("     ...");
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: User input directory of file
        String directory = inputDirectory();

        // Step 2: User input string to search
        String stringToSearch = inputStringToSearch();

        // Step 3: Search string or letter words that contain the input string
        ArrayList<String> result = searchString(stringToSearch, directory);

        // Step 4: Display result to screen
        displayResult(result);
    }

}
