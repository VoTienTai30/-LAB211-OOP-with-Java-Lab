package j1sp0059;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HandleFile {

    GetInput get = new GetInput();

    void displayMenu() {
        System.out.println("========== File Processing =========");
        System.out.println("   1. Find person info");
        System.out.println("   2. Copy Text to new file");
        System.out.println("   3. Exit");
        System.out.print("Your choice: ");
    }

    void exitProgram() {
        System.exit(0);
    }

    ArrayList<Person> getListPerson(String pathFile) throws IOException {
        ArrayList<Person> listPerson = new ArrayList<>();
        try {
            FileReader fr = new FileReader(pathFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            // loop over each line in file until end file
            while ((line = br.readLine()) != null) {
                double money;
                String name, address, moneyString;

                try {
                    String[] element = line.split(";");
                    name = element[0].trim();
                    address = element[1].trim();
                    moneyString = element[2].trim();
                } catch (Exception e) {
                    System.out.println("Can't read file");
                    return null;
                }
                try {
                    money = Double.parseDouble(moneyString);
                    // if salary of this person < 0
                    if (money < 0) {
                        money = 0;
                    }
                } catch (NumberFormatException e) {
                    money = 0;
                }
                listPerson.add(new Person(name, address, money));
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't read file");
            return null;
        }
        return listPerson;
    }

    void findPerson() throws IOException {
        System.out.println("--------- Person info ---------");
        System.out.print("Enter Path:");
        String pathFile = get.getPathFile();
        ArrayList<Person> listPerson = getListPerson(pathFile);
        // if list person is null value
        if (listPerson == null) {
            return;
        }
        System.out.print("Enter Money:");
        double money = get.getMoney();
        ArrayList<Person> listPersonFound = new ArrayList<>();
        // if list person dont empty
        if (!listPerson.isEmpty()) {
            System.out.println("------------- Result --------------");
            // traverse from the first person to the last person in list
            for (Person person : listPerson) {
                // if person has money greater than or equal to money input by user
                if (person.getMoney() >= money) {
                    listPersonFound.add(person);
                }
            }
            /* if list person doesn't have person has money greater than or equal
            to money user input */
            if (listPersonFound.isEmpty()) {
                System.out.println("Doesn't exist any person has money greater "
                        + "than or equal to money you input");
            } // if list person has person has money greater than or equal to money user input
            else {
                System.out.printf("%-15s%-15s%-10s\n", "Name", "Address", "Money");
                // traverse from the first person to the last person in list person found
                for (Person person : listPersonFound) {
                    System.out.println(person);
                }
                System.out.println("");
                double min = listPersonFound.get(0).getMoney();
                double max = 0;
                // traverse from the first person to the last person in list person found
                for (Person person : listPersonFound) {
                    // if this person has salary less than salary min
                    if (person.getMoney() < min) {
                        min = person.getMoney();
                    }
                }
                // traverse from the first person to the last person in list person found
                for (Person person : listPersonFound) {
                    // if this person has salary greater than salary max
                    if (person.getMoney() > max) {
                        max = person.getMoney();
                    }
                }
                // traverse from the first person to the last person in list person found
                for (Person person : listPersonFound) {
                    // if this person has salary equals to salary max
                    if (person.getMoney() == max) {
                        System.out.println("Max: " + person.getName());
                    }
                }
                // traverse from the first person to the last person in list person found
                for (Person person : listPersonFound) {
                    // if this person has salary equals to salary min
                    if (person.getMoney() == min) {
                        System.out.println("Min: " + person.getName());
                    }
                }
            }
        }

    }

    String getTextFromFile(String source) {
        String contentFile = "";
        try {
            FileReader fr = new FileReader(source);
            BufferedReader br = new BufferedReader(fr);
            String line;
            // loop over each line in file until end file
            while ((line = br.readLine()) != null) {
                contentFile += line + " ";
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Can't read file");
        }
        return contentFile;
    }

    void copyText() throws IOException {
        System.out.println("------------- Copy text -------------");
        System.out.print("Enter Source: ");
        String source = get.getPathFile();
        File filePaste;
        // loop until can create a non-duplicated file
        while (true) {
            System.out.print("Enter new file name: ");
            String fileNew = get.getStringNonEmpty();
            filePaste = new File(fileNew);
            // if file want to paste doesn't exist
            if (!filePaste.exists()) {
                filePaste.createNewFile();
                break;
            } // if file want to paste already exist
            else {
                System.out.print("Do you want to overwrite to this file ?(Y/N): ");
                String YN = get.getYN();
                // if user want to overwrite in this file
                if (YN.equals("Y")) {
                    break;
                }
            }
        }
        String contentFile = getTextFromFile(source);
        String[] word = contentFile.split("\\s+");
        ArrayList<String> content = new ArrayList<>();
        String newContent = "";
        // traverse from the first element to the last element of word array 
        for (int i = 0; i < word.length; i++) {
            // if content list doesn't contain this word
            if (!content.contains(word[i])) {
                content.add(word[i]);
            }
        }
        // traverse from the first element to the last element of content list 
        for (String string : content) {
            newContent += string + " ";
        }
        newContent = newContent.trim();
        try {
            FileWriter writer = new FileWriter(filePaste);
            writer.write(newContent);
            writer.close();
            System.out.println("Copy done...");
        } catch (IOException e) {
            System.out.println("Can't write file");
        }
    }
}
