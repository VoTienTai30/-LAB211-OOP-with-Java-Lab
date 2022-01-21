package j1sp0052;

public class Main {

    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        GetInput get = new GetInput();
        // loop until user choose exit
        while (true) {
            // Step 1: Display menu
            manager.displayMenu();
            // Step 2: Input an option
            int option = get.inputOption();
            switch (option) {
                // Step 3: Input the information of country in East Asia
                case 1:
                    manager.inputCountryInformation();
                    break;
                // Step 4: Displays information of recently entered countries
                case 2:
                    manager.displayRecentlyEnteredInformation();
                    break;
                // Step 5: Search information of countries by name
                case 3:
                    manager.searchInformationByName();
                    break;
                // Step 6: Displays the information of countries by name ascending
                case 4:
                    manager.displayInformationByNameAscending();
                    break;
                // Step 7: Exit program
                case 5:
                    break;
            }
            // if user choose exit
            if (option == 5) {
                break;
            }
        }
    }

}
