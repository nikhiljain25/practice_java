package com.workat.tech.practice;

public class FibonacciSeriesUsingRecursion {

    // Fibbonacci series using recursion
    public static int fib(int n) {
        if (n <= 1) {
            return n; // Base case: return n if it's 0 or 1
        }
        return fib(n - 1) + fib(n - 2); // Recursive case: sum of the two preceding numbers
    }
    public static void main(String[] args) {
        int n = 10; // Length of the Fibonacci series
        System.out.print("Fibonacci Series using recursion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " "); // Print Fibonacci numbers using the recursive function
        }
    }
}
