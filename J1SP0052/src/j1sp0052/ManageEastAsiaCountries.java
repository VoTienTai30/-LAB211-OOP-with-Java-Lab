package j1sp0052;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManageEastAsiaCountries {

    GetInput get = new GetInput();
    Scanner sc = new Scanner(System.in);
    ArrayList<EastAsiaCountries> countryList = new ArrayList<>();

    // Display menu 
    public void displayMenu() {
        System.out.println("                               MENU");
        System.out.println("===================================================="
                + "======================");
        System.out.println("1. Input the information of 11 countries in East "
                + "Asia");
        System.out.println("2. Display the information of country you've just "
                + "input");
        System.out.println("3. Search the information of country by user-entered"
                + " name");
        System.out.println("4. Display the information of countries sorted name "
                + "in ascending order");
        System.out.println("5. Exit");
        System.out.println("===================================================="
                + "======================");
        System.out.println("Enter your choice :");
    }

    // Check if country code is duplicate
    public boolean checkCodeDuplicate(String code) {
        // traverse from the first country to the last country in the list
        for (int i = 0; i < countryList.size(); i++) {
            EastAsiaCountries get = countryList.get(i);
            // if this country has the same code with another country
            if (get.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    // Check if country name is duplicate
    public boolean checkNameDuplicate(String name) {
        // traverse from the first country to the last country in the list
        for (int i = 0; i < countryList.size(); i++) {
            EastAsiaCountries get = countryList.get(i);
            // if this country has the same name with another country
            if (get.getCountryName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // Input information for a country
    public void inputCountryInformation() {
        // if the list is full of countries
        if (countryList.size() >= 3) {
            System.out.println("The number of countries is enough!");
        } // if the list is not full of countries
        else {
            System.out.println("Enter code of country:");
            String code = get.inputStringNotEmpty();
            // loop until user enter country code not duplicate with another country
            while (checkCodeDuplicate(code)) {
                System.err.println("This code of country already exists. Please "
                        + "enter again: ");
                code = get.inputStringNotEmpty();
            }
            System.out.println("Enter name of country:");
            String name = get.inputStringNotEmpty();
            // loop until user enter country name not duplicate with another country
            while (checkNameDuplicate(name)) {
                System.err.println("This name of country already exists. Please "
                        + "enter again: ");
                name = get.inputStringNotEmpty();
            }
            System.out.println("Enter total Area:");
            double area;
            // loop until user enter a positive double
            while (true) {
                try {
                    area = Double.parseDouble(get.inputStringNotEmpty());
                    // if user enter a negative number
                    if (area <= 0) {
                        System.err.println("You must enter a positive number. "
                                + "Please enter again: ");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("You must enter a number. Please enter "
                            + "again: ");
                }
            }
            System.out.println("Enter terrain of country:");
            String terrain = get.inputStringNotEmpty();
            EastAsiaCountries country = new EastAsiaCountries(code, name, area, terrain);
            countryList.add(country);
        }
    }

    // Displays information of recently entered countries
    public void displayRecentlyEnteredInformation() {
        // if database is empty
        if (countryList.isEmpty()) {
            System.out.println("Database is empty");
            return;
        }
        System.out.printf("%-16s%-16s%-16s%-16s", "ID", "Name", "Total Area", "Terrain");
        countryList.get(countryList.size() - 1).display();
    }

    // Search information of countries by user-entered name
    public void searchInformationByName() {
        // if database is empty
        if (countryList.isEmpty()) {
            System.out.println("Database is empty");
            return;
        }
        ArrayList<EastAsiaCountries> searchList = new ArrayList<>();
        System.out.println("Enter the name you want to search for:");
        String name = get.inputStringNotEmpty();
        // traverse from the firt country to the last country in the list
        for (int i = 0; i < countryList.size(); i++) {
            EastAsiaCountries get = countryList.get(i);
            // if the country has the same name as user-entered name
            if (get.getCountryName().toLowerCase().contains(name.toLowerCase())) {
                searchList.add(get);
            }
        }
        // check if name of country is exist
        if (searchList.size() > 0) {
            System.out.printf("%-16s%-16s%-16s%-16s", "ID", "Name", "Total Area", "Terrain");
        }
        // traverse from the firt country to the last country in the search list
        for (int i = 0; i < searchList.size(); i++) {
            EastAsiaCountries get1 = searchList.get(i);
            get1.display();
        }
        // if does not have country has name like the name user iput
        if (searchList.size() < 1) {
            System.out.println("There is no country named " + name);
        }
    }

    // Displays the information of countries by name ascending
    public void displayInformationByNameAscending() {
        // if database is empty
        if (countryList.isEmpty()) {
            System.out.println("Database is empty");
            return;
        }
        System.out.printf("%-16s%-16s%-16s%-16s", "ID", "Name", "Total Area", "Terrain");
        ArrayList<EastAsiaCountries> sortedList = new ArrayList<>();
        // traverse from the firt country to the last country in the list before sorted
        for (int i = 0; i < countryList.size(); i++) {
            EastAsiaCountries get = countryList.get(i);
            sortedList.add(get);
        }
        Collections.sort(sortedList, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries t, EastAsiaCountries t1) {
                return t.getCountryName().compareTo(t1.getCountryName());
            }
        });
        // traverse from the firt country to the last country in the list after sorted
        for (int i = 0; i < sortedList.size(); i++) {
            EastAsiaCountries get = sortedList.get(i);
            get.display();
        }
    }
}
