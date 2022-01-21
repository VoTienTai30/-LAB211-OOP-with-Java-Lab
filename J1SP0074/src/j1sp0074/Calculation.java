package j1sp0074;

import java.util.Scanner;

public class Calculation {

    Scanner sc = new Scanner(System.in);

    // Input number is an integer and return it
    int inputInt(String prompt, String error) {
        int number;
        // loop until user input integer
        while (true) {
            try {
                System.out.print(prompt);
                number = Integer.parseInt(sc.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
        return number;
    }

    // Display menu
    public void displayMenu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    // User input option
    public int inputOption() {
        int option = inputInt("Your choice:", "Your choice must be integer");
        // loop until user choose valid option
        while (option < 1 || option > 4) {
            System.out.println("Your choice must be 1 -> 4");
            option = inputInt("Your choice:", "Your choice must be integer");
        }
        return option;
    }

    // Input number of rows of matrix 1
    public int inputNumberRow1(String title) {
        System.out.println(title);
        int numberRow1 = inputInt("Enter Row Matrix 1:", "Number of rows of"
                + " matrix must be integer");
        // loop until user input number of rows > 0
        while (numberRow1 < 1) {
            System.out.println("Number of rows of matrix must be > 0");
            numberRow1 = inputInt("Enter Row Matrix 1:", "Number of rows of"
                    + " matrix must be integer");
        }
        return numberRow1;
    }

    // Input number of rows of matrix 2
    public int inputNumberRow2(String calculation, int numberRow1, int numberColumn1) {
        int numberRow2 = inputInt("Enter Row Matrix 2:", "Number of rows of "
                + "matrix must be integer");
        // loop until user input number of rows > 0
        while (numberRow2 < 1) {
            System.out.println("Number of rows of matrix must be > 0");
            numberRow2 = inputInt("Enter Row Matrix 2:", "Number of rows of"
                    + " matrix must be integer");
        }
        /* loop until number of rows entered by user satisfies the condition 
        to perform the matrix calculation */
        while (true) {
            // if performing matrix addition or subtraction
            if (calculation.equals("addition") || calculation.equals("subtraction")) {
                // check if number of rows of matrix 2 != number of rows of matrix 1
                if (numberRow2 != numberRow1) {
                    System.out.println("The number of rows of matrix 2 must "
                            + "be equal to the number of rows of matrix 1");
                    numberRow2 = inputInt("Enter Row Matrix 2:", "Number of rows"
                            + " of matrix must be integer");
                } else {
                    break;
                }
            } // if performing matrix multiplication
            else {
                /* check if number of rows of matrix 2 != number of columns 
                of matrix 1 */
                if (numberRow2 != numberColumn1) {
                    System.out.println("The number of rows of matrix 2 must "
                            + "be equal to the number of columns of matrix 1");
                    numberRow2 = inputInt("Enter Row Matrix 2:", "Number of rows"
                            + " of matrix must be integer");
                } else {
                    break;
                }
            }

        }
        return numberRow2;
    }

    // Input number of columns of matrix 1
    public int inputNumberColumn1() {
        int numberColumn1 = inputInt("Enter Column Matrix 1:", "Number of "
                + "columns of matrix must be integer");
        // loop until user input number of columns > 0
        while (numberColumn1 < 1) {
            System.out.println("Number of columns of matrix must be > 0");
            numberColumn1 = inputInt("Enter Column Matrix 1:", "Number of "
                    + "columns of matrix must be integer");
        }
        return numberColumn1;
    }

    // Input number of columns of matrix 2
    public int inputNumberColumn2(String calculation, int numberColumn1) {
        int numberColumn2 = inputInt("Enter Column Matrix 2:", "Number of "
                + "columns of matrix must be integer");
        // loop until user input number of columns > 0
        while (numberColumn2 < 1) {
            System.out.println("Number of columns of matrix must be > 0");
            numberColumn2 = inputInt("Enter Column Matrix 2:", "Number of "
                    + "columns of matrix must be integer");
        }
        /* loop until number of columns entered by user satisfies the condition 
        to perform the matrix calculation */
        while (true) {
            // if performing matrix addition or subtraction
            if (calculation.equals("addition") || calculation.equals("subtraction")) {
                /* check if number of columns of matrix 2 != number of columns 
                of matrix 1 */
                if (numberColumn2 != numberColumn1) {
                    System.out.println("The number of columns of matrix 2 must "
                            + "be equal to the number of columns of matrix 1");
                    numberColumn2 = inputInt("Enter Column Matrix 2:", "Number "
                            + "of columns of matrix must be integer");
                } else {
                    break;
                }
            } // if performing matrix multiplication
            else {
                break;
            }
        }
        return numberColumn2;
    }

    // User input values of matrix
    public int[][] inputMatrix(int ordinal, int row, int column) {
        int[][] matrix = new int[row][column];
        // traverse from first row to last row
        for (int i = 0; i < row; i++) {
            // traverse from first column to last column
            for (int j = 0; j < column; j++) {
                matrix[i][j] = inputInt("Enter Matrix" + ordinal + "["
                        + (i + 1) + "][" + (j + 1) + "]:", "Value of matrix is digit");
            }
        }
        return matrix;
    }

    // Display matrix
    public void displayMatrix(int[][] matrix) {
        // traverse from first row to last row
        for (int i = 0; i < matrix.length; i++) {
            // traverse from first column to last column
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        int[][] result = new int[matrix1.length][matrix1[0].length];
        // traverse from first row to last row of matrix result
        for (int i = 0; i < result.length; i++) {
            // traverse from first column to last column of matrix result
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int[][] result = new int[matrix1.length][matrix1[0].length];
        // traverse from first row to last row of matrix result
        for (int i = 0; i < result.length; i++) {
            // traverse from first column to last column of matrix result
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int[][] result = new int[matrix1.length][matrix2[0].length];
        // traverse from first row to last row of matrix result
        for (int row = 0; row < result.length; row++) {
            // traverse from first column to last column of matrix result
            for (int column = 0; column < matrix2[0].length; column++) {
                // traverse from first column to last column of matrix 1
                for (int i = 0; i < matrix1[0].length; i++) {
                    result[row][column] += matrix1[row][i] * matrix2[i][column];
                }
            }
        }
        return result;
    }
}
