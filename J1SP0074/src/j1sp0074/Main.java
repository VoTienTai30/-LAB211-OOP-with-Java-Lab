package j1sp0074;

public class Main {

    public static void main(String[] args) {
        int[][] matrix1;
        int[][] matrix2;
        int[][] result;
        int row1, row2;
        int column1, column2;
        Calculation calculation = new Calculation();
        // Loop until user choose exit program
        while (true) {
            // 1. Display menu and ask user select option
            calculation.displayMenu();
            // 2. User input option
            int option = calculation.inputOption();
            switch (option) {
                // 3. If user choose option 1: Addition matrices
                case 1:
                    // 4. Input number of rows of matrix 1
                    row1 = calculation.inputNumberRow1("-------- Addition --------");
                    // 5. Input number of columns of matrix 1
                    column1 = calculation.inputNumberColumn1();
                    // 6. Input values of matrix 1
                    matrix1 = calculation.inputMatrix(1, row1, column1);
                    // 7. Input number of rows of matrix 2
                    row2 = calculation.inputNumberRow2("addition", row1, column1);
                    // 8. Input number of columns of matrix 2
                    column2 = calculation.inputNumberColumn2("addition", column1);
                    // 9. Input values of matrix 2
                    matrix2 = calculation.inputMatrix(2, row2, column2);
                    // 10. Perform addition matrices
                    result = calculation.additionMatrix(matrix1, matrix2);
                    // 11. Display result
                    calculation.displayMatrix(result);
                    break;
                // 12. If user choose option 2: Subtraction matrices
                case 2:
                    // 13. Input number of rows of matrix 1
                    row1 = calculation.inputNumberRow1("-------- Subtraction --------");
                    // 14. Input number of columns of matrix 1
                    column1 = calculation.inputNumberColumn1();
                    // 15. Input values of matrix 1
                    matrix1 = calculation.inputMatrix(1, row1, column1);
                    // 16. Input number of rows of matrix 2
                    row2 = calculation.inputNumberRow2("subtraction", row1, column1);
                    // 17. Input number of columns of matrix 2
                    column2 = calculation.inputNumberColumn2("subtraction", column1);
                    // 18. Input values of matrix 2
                    matrix2 = calculation.inputMatrix(2, row2, column2);
                    // 19. Perform subtraction matrices
                    result = calculation.subtractionMatrix(matrix1, matrix2);
                    // 20. Display result
                    calculation.displayMatrix(result);
                    break;
                // 21. If user choose option 3: Multiplication matrices
                case 3:
                    // 22. Input number of rows of matrix 1
                    row1 = calculation.inputNumberRow1("-------- Multiplication --------");
                    // 23. Input number of columns of matrix 1
                    column1 = calculation.inputNumberColumn1();
                    // 24. Input values of matrix 1
                    matrix1 = calculation.inputMatrix(1, row1, column1);
                    // 25. Input number of rows of matrix 2
                    row2 = calculation.inputNumberRow2("multiplication", row1, column1);
                    // 26. Input number of columns of matrix 2
                    column2 = calculation.inputNumberColumn2("multiplication", column1);
                    // 27. Input values of matrix 2
                    matrix2 = calculation.inputMatrix(2, row2, column2);
                    // 28. Perform multiplication matrices
                    result = calculation.multiplicationMatrix(matrix1, matrix2);
                    // 29. Display result
                    calculation.displayMatrix(result);
                    break;
                // 30. If user choose option 4: Exit program
                case 4:
                    break;
            } // If user choose exit program
            if (option == 4) {
                break;
            }
        }

    }

}
