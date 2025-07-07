package com.workat.tech.practice;

public class FibonacciSeries {

    // Fibbonacci series
    public static void main(String[] args) {
        int n = 10; // Length of the Fibonacci series
        int a = 0, b = 1; // Starting values

        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b; // Calculate the next number
            a = b; // Update a to the next number
            b = next; // Update b to the next number
        }
    }
}
