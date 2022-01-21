package j1sp0011;

public class Main {

    public static void main(String[] args) {
        ConvertBaseNumber convert = new ConvertBaseNumber();
        String choice;
        // Loop until user choose No
        do {        
            // 1. User choose the base number input
            int baseInput = convert.baseNumberInput();
            // 2. User choose the base number output
            int baseOutput = convert.baseNumberOutput();
            // 3. User enter the input value need to change base number system
            String value = convert.inputValue(baseInput);
            // 4. Change base number system of value of users entered 
            String result = convert.changeBaseNumber(baseInput, baseOutput, value);
            // 5. Display output value 
            convert.displayResult(result);
            // 6. User inputs the choice to continue or stop the program
            choice = convert.inputUserChoice();
        } while (choice.equals("Y")); 
    }

}
