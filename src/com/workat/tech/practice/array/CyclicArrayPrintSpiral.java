package com.workat.tech.practice.array;

/*
input:
int[][] = {1, 2, 3, 4, 5},
          {6,7, 8, 9, 10},
		  {11, 12, 13, 14, 15},
		  {16, 17, 18, 19, 20}

OutPut:
1 2 3 4 5 10 15 20 19 18 17 16 11 6 7 8 9 14 13 12
# Cyclic Array Spiral Print
 */
public class CyclicArrayPrintSpiral {

    public static void main(String[] args) {
        int[][] arr = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        spiralPrint(arr);
    }

    public static void spiralPrint(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Print top row
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            // Print right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // Print bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
            // Print left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
}
