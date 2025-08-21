package com.workat.tech.practice.array;
/*
Print the following pattern:
1
2 4
3 5 7
6 8 10 12
9 11 13 15 17
*/
public class Pattern {
    public static void main(String[] args) {
        int rows = 5;
        int odd = 1, even = 2;

        for (int i = 1; i <= rows; i++) {
            if ((i & 1) == 1) {          // odd row -> use odd numbers
                for (int j = 0; j < i; j++) {
                    System.out.print(odd + " ");
                    odd += 2;
                }
            } else {                      // even row -> use even numbers
                for (int j = 0; j < i; j++) {
                    System.out.print(even + " ");
                    even += 2;
                }
            }
            System.out.println();
        }
    }
}
