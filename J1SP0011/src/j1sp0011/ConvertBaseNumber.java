package j1sp0011;

import java.math.BigInteger;
import java.util.Scanner;

public class ConvertBaseNumber {

    static Scanner sc = new Scanner(System.in);

    // User choose the base number input (2 is binary, 10 is decimal, 16 is hexadecimal)
    public int baseNumberInput() {
        System.out.print("\nChoose the base number input (2 is binary, 10 is decimal, "
                + "16 is hexadecimal): ");
        int base;
        // loop until user choose valid base number
        while (true) {
            try {
                base = Integer.parseInt(sc.nextLine().trim());
                // if user does not input 2 or 10 or 16 then prompt user to enter again 
                if (base != 2 && base != 10 && base != 16) {
                    System.err.print("Base number input must be 2 or 10 or 16. "
                            + "Please enter again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.print("Base number input must be integer. "
                        + "Please enter again: ");
            }
        }
        return base;
    }

    // User choose the base number output (2 is binary, 10 is decimal, 16 is hexadecimal)
    public int baseNumberOutput() {
        System.out.print("Choose the base number output (2 is binary, 10 is decimal, "
                + "16 is hexadecimal): ");
        int base;
        // loop until user choose valid base number
        while (true) {
            try {
                base = Integer.parseInt(sc.nextLine().trim());
                // if user does not input 2 or 10 or 16  
                if (base != 2 && base != 10 && base != 16) {
                    // prompt user to enter again
                    System.err.print("Base number output must be 2 or 10 or 16. "
                            + "Please enter again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.print("Base number output must be integer. "
                        + "Please enter again: ");
            }
        }
        return base;
    }

    // Check if string is decimal number or not
    public boolean checkDecimalNumber(String value) {
        // if value is empty return false
        if (value.isEmpty()) {
            return false;
        }
        // traverse from the first character to the last character of value
        for (int i = 0; i < value.length(); i++) {
            // if character is not a number return false
            if (value.charAt(i) < '0' || value.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    // Check if string is binary number or not
    public boolean checkBinaryNumber(String value) {
        // if value is empty return false
        if (value.isEmpty()) {
            return false;
        }
        // traverse from the first character to the last character of value
        for (int i = 0; i < value.length(); i++) {
            // if character is not a number return false
            if (value.charAt(i) < '0' || value.charAt(i) > '1') {
                return false;
            }
        }
        return true;
    }

    // Check if string is hexadecimal number or not
    public boolean checkHexadecimalNumber(String value) {
        String limit = "0123456789ABCDEF";
        // if value is empty return false
        if (value.isEmpty()) {
            return false;
        }
        // traverse from the first character to the last character of value
        for (int i = 0; i < value.length(); i++) {
            // if character is not a hexadecimal number return false
            if (limit.contains(value.charAt(i) + "") == false) {
                return false;
            }
        }
        return true;
    }

    // User enter the input value
    public String inputValue(int baseNumber) {
        System.out.print("Enter the input value: ");
        String value = sc.nextLine().trim();
        // if base number input is binary
        if (baseNumber == 2) {      
            // loop until user enter binary number
            while (checkBinaryNumber(value) == false) {
                System.err.print("Input value must be binary number. "
                        + "Please enter again: ");
                value = sc.nextLine().trim();
            }
            return value;
        } // if base number input is decimal
        else if (baseNumber == 10) {
            // loop until user enter decimal number
            while (checkDecimalNumber(value) == false) {
                System.err.print("Input value must be decimal number. "
                        + "Please enter again: ");
                value = sc.nextLine().trim();
            }
            return value;
        } // if base number input is hexadecimal
        else {
            // loop until user enter hexadecimal number
            while (checkHexadecimalNumber(value) == false) {
                System.err.print("Input value must be hexadecimal number. "
                        + "Please enter again: ");
                value = sc.nextLine().trim();
            }
            return value;
        }
    }

    // Convert binary to decimal
    public String numberBinToDec(String value) {
        BigInteger result = new BigInteger("0");
        // traverse from last charater to first character of value 
        for (int i = value.length() - 1; i >= 0; i--) {
            result = result.add(BigInteger.valueOf(2).pow(value.length() - 1 - i)
                    .multiply(BigInteger.valueOf(Integer.parseInt(value
                            .charAt(i) + ""))));
        }
        return result.toString();
    }

    // Convert decimal to binary
    public String numberDecToBin(String value) {
        String result = "";
        BigInteger number = new BigInteger(value);
        // loop until number == 0
        while (number != BigInteger.valueOf(0)) {
            result = number.mod(BigInteger.valueOf(2)) + result;
            number = number.divide(BigInteger.valueOf(2));
        }
        return result;
    }

    // Convert decimal to hexadecimal
    public String numberDecToHex(String value) {
        String result = "";
        BigInteger number = new BigInteger(value);
        int remainder;
        // loop until number == 0
        while (number != BigInteger.valueOf(0)) {
            remainder = Integer.parseInt(number.mod(BigInteger.valueOf(16)).toString());
            // if number divided 16 has a remainder greater than 9 
            if (remainder > 9) {
                switch (remainder) {
                    // if remainder == 10
                    case 10:
                        result = "A" + result;
                        break;
                    // if remainder == 11
                    case 11:
                        result = "B" + result;
                        break;
                    // if remainder == 12
                    case 12:
                        result = "C" + result;
                        break;
                    // if remainder == 13
                    case 13:
                        result = "D" + result;
                        break;
                    // if remainder == 14
                    case 14:
                        result = "E" + result;
                        break;
                    // if remainder == 15
                    case 15:
                        result = "F" + result;
                        break;
                }
            } else {
                result = remainder + result;
            }
            number = number.divide(BigInteger.valueOf(16));
        }
        return result;
    }

    // Convert hexadecimal to decimal
    public String numberHexToDec(String value) {
        BigInteger result = new BigInteger("0");
        // traverse from last charater to first character of value 
        for (int i = value.length() - 1; i >= 0; i--) {
            // if the character is a number between 0 and 9
            if (value.charAt(i) >= '0' && value.charAt(i) <= '9') {
                result = result.add(BigInteger.valueOf(16).pow(value
                        .length() - 1 - i).multiply(BigInteger.valueOf(Integer
                                .parseInt(value.charAt(i) + ""))));
            }
            switch (value.charAt(i)) {
                // if character is 'A'
                case 'A':
                    result = result.add(BigInteger.valueOf(16).pow(value
                            .length() - 1 - i).multiply(BigInteger.valueOf(10)));
                    break;
                // if character is 'B'
                case 'B':
                    result = result.add(BigInteger.valueOf(16).pow(value
                            .length() - 1 - i).multiply(BigInteger.valueOf(11)));
                    break;
                // if character is 'C'
                case 'C':
                    result = result.add(BigInteger.valueOf(16).pow(value
                            .length() - 1 - i).multiply(BigInteger.valueOf(12)));
                    break;
                // if character is 'D'
                case 'D':
                    result = result.add(BigInteger.valueOf(16).pow(value
                            .length() - 1 - i).multiply(BigInteger.valueOf(13)));
                    break;
                // if character is 'E'
                case 'E':
                    result = result.add(BigInteger.valueOf(16).pow(value
                            .length() - 1 - i).multiply(BigInteger.valueOf(14)));
                    break;
                // if character is 'F'
                case 'F':
                    result = result.add(BigInteger.valueOf(16).pow(value
                            .length() - 1 - i).multiply(BigInteger.valueOf(15)));
                    break;
            }
        }
        return result.toString();
    }

    // Convert hexadecimal to binary
    public String numberHexToBin(String value) {
        return numberDecToBin(numberHexToDec(value));
    }

    // Convert binary to hexadecimal
    public String numberBinToHex(String value) {
        return numberDecToHex(numberBinToDec(value));
    }

    // Change base number system of value of users entered
    public String changeBaseNumber(int baseInput, int baseOutput, String value) {
        // if base number input is binary and base number output is decimal
        if (baseInput == 2 && baseOutput == 10) {
            return numberBinToDec(value);
        } // if base number input is decimal and base number output is binary
        else if (baseInput == 10 && baseOutput == 2) {
            return numberDecToBin(value);
        } // if base number input is hexadecimal and base number output is decimal
        else if (baseInput == 10 && baseOutput == 16) {
            return numberDecToHex(value);
        } // if base number input is decimal and base number output is hexadecimal
        else if (baseInput == 16 && baseOutput == 10) {
            return numberHexToDec(value);
        } // if base number input is binary and base number output is hexadecimal
        else if (baseInput == 2 && baseOutput == 16) {
            return numberBinToHex(value);
        } // if base number input is hexadecimal and base number output is binary
        else if (baseInput == 16 && baseOutput == 2) {
            return numberHexToBin(value);
        } // if base number input same as base number output
        else if (baseInput == baseOutput) {
            return value;
        }
        return null;
    }

    // Display output value
    public void displayResult(String result) {
        System.out.println("Value after change base number system:");
        System.out.println(result);
    }

    // User enters the choice to continue or stop the program
    public String inputUserChoice() {
        System.out.print("Do you want to continue running the program (Y/N)? ");
        String choice = sc.nextLine().trim().toUpperCase();
        // loop until user choose Y or N
        while (choice.equals("Y") == false && choice.equals("N") == false) {
            System.err.print("Your choice must be Y or N. Please enter again: ");
            choice = sc.nextLine().trim().toUpperCase();
        }
        return choice;
    }
}
