package com.workat.tech.practice.string;

/*
     Input:
     ******
     String input = "I love my india";
     Output:
     *******
    The character 'i' occurs 2 times in the string "I love my india".
 */

public class FindAnyCharCountFromString {

    public static void main(String[] args) {
        String input = "I love my india";
        char characterToCount = 'i';
        int count = countCharacterOccurrences(input, characterToCount);
        System.out.println("The character '" + characterToCount + "' occurs " + count + " times in the string \"" + input + "\".");
    }

    public static int countCharacterOccurrences(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }
}
