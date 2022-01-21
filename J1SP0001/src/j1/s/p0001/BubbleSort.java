package j1.s.p0001;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    public static Scanner sc = new Scanner(System.in);

    // display a screen to ask users to enter a positive integer
    public static void displayEnterPositiveInt() {
        System.out.println("Enter number of array: ");
    }

    // user enters number of array and checks if it is a positive integer or not
    public static int inputNumberOfArray() {
        // loop until user input correct
        while (true) {
            try {
                int numberOfArray = Integer.parseInt(sc.nextLine().trim());
                // if user enters an integer <= 0,  
                if (numberOfArray <= 0) {
                    System.out.print("Please input a positive integer, enter again: ");
                } // if user enters a valid integer 
                else {
                    return numberOfArray;
                }
            } catch (NumberFormatException e) {
                System.out.print("Please input an integer, enter again: ");
            }
        }
    }

    // generate random integer in number range for each array element
    public static int[] generateRandomValue(int numberOfArray) {
        Random rand = new Random();
        int[] array = new int[numberOfArray];
        // traverse from the beginning to the end of the array 
        for (int i = 0; i < numberOfArray; i++) {
            array[i] = rand.nextInt(numberOfArray) + 1;
        }
        return array;
    }

    // display array
    public static void displayArray(int[] array, String s1, String s2) {
        System.out.print(s1);
        // traverse from the beginning to the end of the array 
        for (int i = 0; i < array.length; i++) {
            // if it is the beginning of the array then add "["
            if (i == 0) {
                System.out.print("[" + array[i] + ", ");
            } // if it is the end of the array then add "]"
            else if (i == array.length - 1) {
                System.out.print(array[i] + "]");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print(s2);
    }

    // sort array by bubble sort
    public static void sortArrayByBubbleSort(int[] array) {
        boolean swap;
        // traverse from the beginning to the end of the array
        for (int i = 0; i < array.length; i++) {
            swap = false;
            // traverse from the first element to the last element that has not been sorted
            for (int j = 0; j < array.length - i - 1; j++) {
                displayArray(array, "", " \t");
                // if each pair of adjacent elements are in reversed order
                if (array[j] > array[j + 1]) {
                    System.out.println(array[j] + " > " + array[j + 1] + ", swap");
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                } // if the order is correct, the position will not change
                else if (array[j] < array[j + 1]) {
                    System.out.println(array[j] + " < " + array[j + 1] + ", ok");
                } // if the order is correct, the position will not change
                else {
                    System.out.println(array[j] + " = " + array[j + 1] + ", ok");
                }
            }
            // if no swap has been done, the loop will stop
            if (swap == false) {
                break;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        // 1. Display a screen to ask users to enter a positive integer
        displayEnterPositiveInt();

        // 2. Users input number of array
        int numberOfArray = inputNumberOfArray();

        // 3. Generate random integer in number range for each array element
        int[] array = generateRandomValue(numberOfArray);
//        int[] array = {5, 1, 12, -5, 16};

        // 4. Display array before sort by bubble sort method
        displayArray(array, "Unsorted array: ", "\n\n");

        // 5. Sort array by bubble sort method
        sortArrayByBubbleSort(array);

        // 6. Display array after sort by bubble sort method
        displayArray(array, "\nSorted array: ", "");
    }

}
