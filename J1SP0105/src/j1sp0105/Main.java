package j1sp0105;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        GetInput get = new GetInput();
        ManageProduct manager = new ManageProduct();
        // Loop until user choose exit
        while (true) {
            // 1. Display menu
            manager.displayMenu();
            // 2. Input option
            int option = get.inputOption();
            switch (option) {
                case 1:
                    // 3. Add new storekeeper
                    manager.addStorekeeper();
                    break;
                case 2:
                    // 4. Add new product
                    manager.addProduct();
                    break;
                case 3:
                    // 5. Update product
                    manager.updateProduct();
                    break;
                case 4:
                    // 6. Search product by Name, Category, Storekeeper, ReceiptDate
                    manager.searchProduct();
                    break;
                case 5:
                    // 7. Sort product by Expiry date, Date of manufacture
                    manager.sortByName();
                    break;
                case 6:
                    break;
            }

        }
    }

}
