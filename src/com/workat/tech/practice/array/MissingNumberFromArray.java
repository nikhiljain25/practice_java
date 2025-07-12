package com.workat.tech.practice.array;

import java.util.ArrayList;
import java.util.List;

public class MissingNumberFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 13, 18, 23, 30, 21}; // Example array with missing number
        int n = arr.length + 1; // Since one number is missing
        System.out.println("Missing number: " + findMissingNumber(arr, n));

        System.out.println("All missing numbers: " + findAllMissingNumber(arr, n));
    }

    /**
     * Finds the missing number in an array containing numbers from 1 to n.
     *
     * @param arr the input array
     * @param n   the size of the array including the missing number
     * @return the missing number
     */
    public static int findMissingNumber(int[] arr, int n) {
        int totalSum = n * (n + 1) / 2; // Sum of first n natural numbers
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num; // Calculate sum of elements in the array
        }
        return totalSum - arraySum; // The difference is the missing number
    }
    /**
     * Finds all missing numbers in an array containing numbers from 1 to n.
     *
     * @param arr the input array
     * @param n   the size of the array including the missing numbers
     * @return a list of all missing numbers
     */
    public static List<Integer> findAllMissingNumber(int[] arr, int n) {
        boolean[] present = new boolean[n + 1];
        for (int num : arr) {
            if (num >= 1 && num <= n) {
                present[num] = true;
            }
        }
        List<Integer> missing = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                missing.add(i);
            }
        }
        return missing;
    }
}
