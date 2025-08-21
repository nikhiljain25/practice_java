package com.workat.tech.practice.string.immutable;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PalindromeSubString {
    public static void main(String[] args) {
        String str = "Madam Arora teaches malayalam to her students";
        System.out.println("Palindrome substrings using Java 7:-");
        findPalindromeSubstringsUsingJava7(str);
        System.out.println("Palindrome substrings using Java 8:-");
        findPalindromeSubstringsUsingJava8(str);
    }

    private static void findPalindromeSubstringsUsingJava7(String str) {
        String[] words = str.toLowerCase().split("\\s+"); // split by space
        for (String word : words) {
            if (word.length() > 1 && isPalindromeForJava7(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean isPalindromeForJava7(String word) {
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

   public static void findPalindromeSubstringsUsingJava8(String str) {
       String[] palindromes = Arrays.stream(str.split("\\s+"))
               .filter(word -> word.length() > 1)
               .filter(PalindromeSubString::isPalindromeForJava8)
               .toArray(String[]::new);

       System.out.println("Palindrome words:");
       Arrays.stream(palindromes).forEach(System.out::println);
       System.out.println("Total count: " + palindromes.length);
    }

    private static boolean isPalindromeForJava8(String word) {
//        String lower = word.toLowerCase();
        return new StringBuilder(word.toLowerCase()).reverse().toString().equals(word.toLowerCase());
    }


}
