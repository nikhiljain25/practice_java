package com.workat.tech.practice.array;

/**
 * Rearrange an array such that all zeros are moved to the end while maintaining the order of non-zero elements.
 * Example: Input: [0, 1, 0, 2, 3] Output: [1, 2, 3, 0, 0]
 */
public class RearrangeArray {
    public static void main(String[] args) {
        int[] arry = {0, 1, 0, 2, 3};
        int index = 0;

        for(int i=0; i<arry.length; i++) {
            if(arry[i] != 0) {
                arry[index++] = arry[i];
            }
        }

        while(index < arry.length) {
            arry[index++] = 0;
        }

        for(int num : arry) {
            System.out.print(num + " ");
        }

    }
}
