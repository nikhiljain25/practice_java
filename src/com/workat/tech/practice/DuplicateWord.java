package com.workat.tech.practice;

import java.util.HashSet;
import java.util.Set;

public class DuplicateWord {
    public static void main(String[] args) {
        String input = "This is a test This is only a test";
        System.out.println("Input: " + input);
        System.out.println("Duplicate words: " + findDuplicateWords(input));
    }

    /**
     * Finds duplicate words in a given string, ignoring case.
     *
     * @param input the input string
     * @return a string containing the duplicate words separated by spaces
     */
   /* public static String findDuplicateWords(String input) {
        String[] words = input.split("\\s+");
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            if (!seen.add(lowerWord)) {
                duplicates.add(word);
            }
        }
        return String.join(" ", duplicates);
    }*/
    public static String findDuplicateWords(String string) {
        //Initialize count
        int count;
        //Converts the string into lowercase
        string = string.toLowerCase();
        //Split the string into words using built-in function
        String words[] = string.split(" ");
        System.out.println("Duplicate words in a given string : ");
        for (int i = 0; i < words.length; i++) {
            count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                    //Set words[j] to 0 to avoid printing visited word
                    words[j] = "0";
                }
            }
            //Displays the duplicate word if count is greater than 1
            if (count > 1 && words[i] != "0")
                System.out.println(words[i]);
        }
        return string;
    }
}
