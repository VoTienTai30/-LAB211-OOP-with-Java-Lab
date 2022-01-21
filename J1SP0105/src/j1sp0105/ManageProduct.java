package j1sp0105;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class ManageProduct {

    GetInput get = new GetInput();
    static Scanner sc = new Scanner(System.in);
    ArrayList<Storekeeper> storekeeperList = new ArrayList<>();
    ArrayList<Product> productList = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Display menu
    public void displayMenu() {
        System.out.println("\n                               MENU");
        System.out.println("======================================================================");
        System.out.println("1. Add Storekeeper");
        System.out.println("2. Add product");
        System.out.println("3. Update product");
        System.out.println("4. Search product by Name, Category, Storekeeper, ReceiptDate");
        System.out.println("5. Sort product by Expiry date, Date of manufacture");
        System.out.println("6. Exit");
        System.out.println("======================================================================");
        System.out.print("Enter your choice: ");
    }

    // Check exist storekeeper
    public boolean checkExistStorekeeper(String name) {
        // traverse from the first storekeeper to the last storekeeper
        for (int i = 0; i < storekeeperList.size(); i++) {
            Storekeeper get = storekeeperList.get(i);
            // if this storekeeper has name same as storekeeper name user just input
            if (get.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // Add new storekeeper
    public void addStorekeeper() {
        System.out.print("Enter Storekeeper Name: ");
        String name = get.inputNonEmptyString();
        // loop until user input a name that does not exist in the list 
        while (checkExistStorekeeper(name)) {
            System.err.print("This Storekeeper already exists in the list. Enter again: ");
            name = get.inputNonEmptyString();
        }
        storekeeperList.add(new Storekeeper(name));
        System.out.println("Add Storekeeper successful!");
    }

    // Display storekeeper list
    public void displayStorekeeperList() {
        System.out.println("Storekeeper list:");
        // traverse from the first storekeeper to the last storekeeper
        for (int i = 0; i < storekeeperList.size(); i++) {
            Storekeeper get1 = storekeeperList.get(i);
            System.out.println(get1.getName());
        }
    }

    // Check exist product ID
    public boolean checkExistProductId(String id) {
        // traverse from the first product to the last product
        for (int i = 0; i < productList.size(); i++) {
            Product get = productList.get(i);
            // if this product has ID same as product ID user just input
            if (get.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    // Check date user input if it is correct format [dd/mm/yyyy]
    public boolean checkFormatDate(String date) {
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
        } // if date user input is in the past
        else if (now.compareTo(dateCompare) < 0) {
            return false;
        } // if date user input is today 
        else {
            return true;
        }
    }

    // Compare 2 dates
    public int compareDates(Date date1, Date date2) {
        try {
            // if date 1 before date 2
            if (date1.before(date2)) {
                return -1;
            } // if date 1 after date 2
            else if (date1.after(date2)) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            System.err.println("Error!");
        }
        return 0;
    }

    // Add new product
    public void addProduct() {
        // if storekeeper list is empty
        if (storekeeperList.isEmpty()) {
            System.out.println("Storekeeper list is empty!");
        } // if storekeeper list is not empty
        else {
            System.out.print("Enter Product ID: ");
            String id = get.inputNonEmptyString();
            // loop until user input ID that does not exist in the product list
            while (checkExistProductId(id)) {
                System.err.print("This Product ID already exists in the product list. "
                        + "Enter again: ");
                id = get.inputNonEmptyString();
            }
            System.out.print("Enter Product Name: ");
            String name = get.inputNonEmptyString();
            System.out.print("Enter Location: ");
            String location = get.inputNonEmptyString();
            System.out.print("Enter Price: ");
            int price = get.inputPositiveInt();
            System.out.print("Enter Expiry Date: ");
            String strExpiryDate = get.inputNonEmptyString();
            // loop until user input a date correct date format and in the future
            while (true) {
                // if Expiry Date incorrect date format
                if (!checkFormatDate(strExpiryDate)) {
                    System.out.print("Enter again: ");
                    strExpiryDate = get.inputNonEmptyString();
                } // if Expiry Date not in the future
                else if (checkDatePast(strExpiryDate)) {
                    System.err.println("Expiry Date must be in the future");
                    System.out.print("Enter again: ");
                    strExpiryDate = get.inputNonEmptyString();
                } else {
                    break;
                }
            }
            Date expiryDate = null;
            try {
                expiryDate = sdf.parse(strExpiryDate);
            } catch (ParseException ex) {
                System.err.println("Error!");
            }
            System.out.print("Enter Date of manufacture: ");
            String strDateOfManufacture = get.inputNonEmptyString();
            /* loop until user input a date correct date format, in the past 
            or today */
            while (true) {
                // if Date of manufacture incorrect date format
                if (!checkFormatDate(strDateOfManufacture)) {
                    System.out.print("Enter again: ");
                    strDateOfManufacture = get.inputNonEmptyString();
                } // if Date of manufacture not in the past or today
                else if (checkDatePast(strDateOfManufacture) == false) {
                    System.err.println("Date of manufacture must be in the past or today");
                    System.out.print("Enter again: ");
                    strDateOfManufacture = get.inputNonEmptyString();
                } else {
                    break;
                }
            }
            Date dateOfManufacture = null;
            try {
                dateOfManufacture = sdf.parse(strDateOfManufacture);
            } catch (ParseException ex) {
                System.err.println("Error!");
            }
            System.out.print("Enter Category: ");
            String category = get.inputNonEmptyString();
            displayStorekeeperList();
            System.out.print("Enter Storekeeper: ");
            String storekeeper = get.inputNonEmptyString();
            // loop until user input a storekeeper that exist in the storekeeper list
            while (!checkExistStorekeeper(storekeeper)) {
                System.out.println("This Storekeeper does not exist in the list. ");
                displayStorekeeperList();
                System.out.print("Enter again: ");
                storekeeper = get.inputNonEmptyString();
            }
            System.out.print("Enter Receipt Date: ");
            String strReceiptDate = get.inputNonEmptyString();
            /* loop until user input a date correct date format, in the past and
            not before Date of manufacture */
            while (true) {
                // if Receipt Date incorrect date format
                if (!checkFormatDate(strReceiptDate)) {
                    System.out.print("Enter again: ");
                    strReceiptDate = get.inputNonEmptyString();
                } // if Receipt Date not in the past or today
                else if (checkDatePast(strReceiptDate) == false) {
                    System.err.println("Receipt Date must be in the past or today");
                    System.out.print("Enter again: ");
                    strReceiptDate = get.inputNonEmptyString();
                } // if Receipt Date before Date of manufacture
                else {
                    try {
                        if (compareDates(sdf.parse(strReceiptDate), dateOfManufacture) == -1) {
                            System.err.println("Receipt Date must not be before "
                                    + "Date of manufacture");
                            System.out.print("Enter again: ");
                            strReceiptDate = get.inputNonEmptyString();
                        } else {
                            break;
                        }
                    } catch (ParseException ex) {
                        System.err.print("Error!");
                    }
                }
            }
            Date receiptDate = null;
            try {
                receiptDate = sdf.parse(strReceiptDate);
            } catch (ParseException ex) {
                System.err.print("Error!");
            }
            Product product = new Product(id, name, location, price, expiryDate,
                    dateOfManufacture, category, new Storekeeper(storekeeper), receiptDate);
            productList.add(product);
            System.out.println("Add product successful!");
        }
    }

    // Update product by ID
    public void updateProduct() {
        // if product list is empty
        if (productList.isEmpty()) {
            System.out.println("Product list is empty!");
        } // if product list is not empty
        else {
            System.out.print("Enter Product ID to update: ");
            String idUpdate = get.inputNonEmptyString();
            // if ID user input does not exist in the product list
            if (!checkExistProductId(idUpdate)) {
                System.out.println("There are no products with the same ID as the "
                        + "ID you just entered!");
            } // if ID user input exists in the product list
            else {
                int position = -1;
                // traverse from the first product to the last product in the product list
                for (int i = 0; i < productList.size(); i++) {
                    Product get = productList.get(i);
                    // if this product has ID same as ID of product need to update
                    if (get.getId().equalsIgnoreCase(idUpdate)) {
                        position = i;
                    }
                }
                Product clear = new Product("", "", "", -1, null, null, "", null, null);
                productList.set(position, clear);
                System.out.print("Enter new Product ID: ");
                String id = get.inputNonEmptyString();
                // loop until user input ID that does not exist in the product list
                while (checkExistProductId(id)) {
                    System.err.print("This Product ID already exists in the product list. "
                            + "Enter again: ");
                    id = get.inputNonEmptyString();
                }
                System.out.print("Enter new Product Name: ");
                String name = get.inputNonEmptyString();
                System.out.print("Enter new Location: ");
                String location = get.inputNonEmptyString();
                System.out.print("Enter new Price: ");
                int price = get.inputPositiveInt();
                System.out.print("Enter new Expiry Date: ");
                String strExpiryDate = get.inputNonEmptyString();
                // loop until user input a date correct date format and in the future
                while (true) {
                    // if Expiry Date incorrect date format
                    if (!checkFormatDate(strExpiryDate)) {
                        System.out.print("Enter again: ");
                        strExpiryDate = get.inputNonEmptyString();
                    } // if Expiry Date not in the future
                    else if (checkDatePast(strExpiryDate)) {
                        System.err.println("Expiry Date must be in the future");
                        System.out.print("Enter again: ");
                        strExpiryDate = get.inputNonEmptyString();
                    } else {
                        break;
                    }
                }
                Date expiryDate = null;
                try {
                    expiryDate = sdf.parse(strExpiryDate);
                } catch (ParseException ex) {
                    System.err.println("Error!");
                }
                System.out.print("Enter new Date of manufacture: ");
                String strDateOfManufacture = get.inputNonEmptyString();
                /* loop until user input a date correct date format, in the past 
                or today */
                while (true) {
                    // if Date of manufacture incorrect date format
                    if (!checkFormatDate(strDateOfManufacture)) {
                        System.out.print("Enter again: ");
                        strDateOfManufacture = get.inputNonEmptyString();
                    } // if Date of manufacture not in the past or today
                    else if (checkDatePast(strDateOfManufacture) == false) {
                        System.err.println("Date of manufacture must be in the past or today");
                        System.out.print("Enter again: ");
                        strDateOfManufacture = get.inputNonEmptyString();
                    } else {
                        break;
                    }
                }
                Date dateOfManufacture = null;
                try {
                    dateOfManufacture = sdf.parse(strDateOfManufacture);
                } catch (ParseException ex) {
                    System.err.println("Error!");
                }
                System.out.print("Enter new Category: ");
                String category = get.inputNonEmptyString();
                displayStorekeeperList();
                System.out.print("Enter new Storekeeper: ");
                String storekeeper = get.inputNonEmptyString();
                // loop until user input a storekeeper that exist in the storekeeper list
                while (!checkExistStorekeeper(storekeeper)) {
                    System.out.println("This Storekeeper does not exist in the list. ");
                    displayStorekeeperList();
                    System.out.print("Enter again: ");
                    storekeeper = get.inputNonEmptyString();
                }
                System.out.print("Enter new Receipt Date: ");
                String strReceiptDate = get.inputNonEmptyString();
                /* loop until user input a date correct date format, in the past and
                not before Date of manufacture */
                while (true) {
                    // if Receipt Date incorrect date format
                    if (!checkFormatDate(strReceiptDate)) {
                        System.out.print("Enter again: ");
                        strReceiptDate = get.inputNonEmptyString();
                    } // if Receipt Date not in the past or today
                    else if (checkDatePast(strReceiptDate) == false) {
                        System.err.println("Receipt Date must be in the past or today");
                        System.out.print("Enter again: ");
                        strReceiptDate = get.inputNonEmptyString();
                    } // if Receipt Date before Date of manufacture
                    else {
                        try {
                            if (compareDates(sdf.parse(strReceiptDate), dateOfManufacture) == -1) {
                                System.err.println("Receipt Date must not be before "
                                        + "Date of manufacture");
                                System.out.print("Enter again: ");
                                strReceiptDate = get.inputNonEmptyString();
                            } else {
                                break;
                            }
                        } catch (ParseException ex) {
                            System.err.print("Error!");
                        }
                    }
                }
                Date receiptDate = null;
                try {
                    receiptDate = sdf.parse(strReceiptDate);
                } catch (ParseException ex) {
                    System.err.print("Error!");
                }
                Product product = new Product(id, name, location, price, expiryDate,
                        dateOfManufacture, category, new Storekeeper(storekeeper), receiptDate);
                productList.set(position, product);
                System.out.println("Update product successful!");
            }
        }
    }

    // Search product by Name, Category, Storekeeper, ReceiptDate
    public void searchProduct() throws ParseException {
        // if product list is empty
        if (productList.isEmpty()) {
            System.out.println("Product list is empty!");
        } // if product list is not empty
        else {
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Category");
            System.out.println("3. Search by Storekeeper");
            System.out.println("4. Search by Receipt Date");
            System.out.print("Enter your choice: ");
            int searchType = get.inputSearchType();
            System.out.print("Enter search value: ");
            String searchValue = get.inputNonEmptyString().toLowerCase();
            ArrayList<Product> searchList = new ArrayList<>();
            switch (searchType) {
                case 1:
                    // traverse from the first product to the last product in the product list
                    for (int i = 0; i < productList.size(); i++) {
                        Product get = productList.get(i);
                        // if this product has Name same as search value 
                        if (get.getName().toLowerCase().contains(searchValue)) {
                            searchList.add(get);
                        }
                    }
                    break;
                case 2:
                    // traverse from the first product to the last product in the product list
                    for (int i = 0; i < productList.size(); i++) {
                        Product get = productList.get(i);
                        // if this product has Category same as search value
                        if (get.getCategory().toLowerCase().contains(searchValue)) {
                            searchList.add(get);
                        }
                    }
                    break;
                case 3:
                    // traverse from the first product to the last product in the product list
                    for (int i = 0; i < productList.size(); i++) {
                        Product get = productList.get(i);
                        // if this product has Storekeeper same as search value 
                        if (get.getStoreKeeper().getName().toLowerCase().contains(searchValue)) {
                            searchList.add(get);
                        }
                    }
                    break;
                case 4:
                    // traverse from the first product to the last product in the product list
                    for (int i = 0; i < productList.size(); i++) {
                        Product get = productList.get(i);
                        // if this product has ReceiptDate same as search value 
                        if (sdf.format(get.getReceiptDate()).contains(searchValue)) {
                            searchList.add(get);
                        }
                    }
                    break;
            }
            /* if does not exist any product has Name or Categoryor Storekeeper or 
            ReceiptDate same as search value */
            if (searchList.isEmpty()) {
                System.out.println("Can't find any product!");
            } /* if exists product has Name or Category or Storekeeper or ReceiptDate
            same as search value */ else {
                displayAnyProductList(searchList);
            }
        }
    }

    // Display any product list
    public void displayAnyProductList(ArrayList<Product> list) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-25s%-15s%-15s%-15s\n", "Product ID",
                "Product Name", "Location", "Price", "Expiry Date", "Date of Manufacture",
                "Category", "Sorekeeper", "Receipt Date");
        for (Product product : list) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-25s%-15s%-15s%-15s\n",
                    product.getId(), product.getName(), product.getLocation(),
                    product.getPrice(), sdf.format(product.getExpiryDate()),
                    sdf.format(product.getDateOfManufacture()), product.getCategory(),
                    product.getStoreKeeper(), sdf.format(product.getReceiptDate()));
        }
    }

    // Sort product by Expiry date, Date of manufacture
    public void sortByName() {
        // if product list is empty
        if (productList.isEmpty()) {
            System.out.println("Product list is empty!");
        } // if product list is not empty
        else {
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product t, Product t1) {
                    return compareDates(t.getDateOfManufacture(), t1.getDateOfManufacture());
                }
            });
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product t, Product t1) {
                    return compareDates(t.getExpiryDate(), t1.getExpiryDate());
                }
            });
            displayAnyProductList(productList);
        }

    }

}
