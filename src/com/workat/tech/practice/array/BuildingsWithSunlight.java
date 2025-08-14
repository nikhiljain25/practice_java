package com.workat.tech.practice.array;

/**
 * Given an array of building heights, find the number of buildings that can receive sunlight.
 * A building receives sunlight if it is taller than all the buildings to its left.
 * Example: Input: [3, 2, 1] Output: 1 (only the first building receives sunlight)
 * Example: Input: [1, 2, 3] Output: 3 (all buildings receive sunlight)
 * Example: Input: [2, 1, 3] Output: 2 (the first and third buildings receive sunlight)
 */
public class BuildingsWithSunlight {
    public static void main(String[] args) {
        int[] array1 = {3, 2, 1};
        int[] array2 = {1, 2, 3};
        int[] array3 = {2, 1, 3};

        System.out.println("First Building: " + getBuildingsWithSunlight(array1)); // 1
        System.out.println("Second Building: " + getBuildingsWithSunlight(array2)); // 3
        System.out.println("Third Building: " + getBuildingsWithSunlight(array3)); // 2
    }

    public static int getBuildingsWithSunlight(int[] heights) {
        int count = 0;
        int maxSoFar = 0;

        for (int height : heights) {
            if (height > maxSoFar) {
                count++;
                maxSoFar = height; // update tallest so far
            }
        }
        return count;
    }
}
