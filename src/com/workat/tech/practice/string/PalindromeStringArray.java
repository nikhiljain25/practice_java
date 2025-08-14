package com.workat.tech.practice.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This code checks if each string in an array is a palindrome.
 * A palindrome reads the same backward as forward, ignoring spaces and case.
 */
public class PalindromeStringArray {
    public static void main(String[] args) {
        String[] strings = {"Madam", "Hello", "Racecar", "World", "Level"};
        usingForLoop(strings);
        usingStream(strings);
    }

    private static void usingStream(String[] strings) {
        List<String> palindromes = Arrays.stream(strings)
                .filter(PalindromeStringArray::isPalindrome)
                .collect(Collectors.toList());

        System.out.println("Palindromes: " + palindromes);
    }

    private static void usingForLoop(String[] strings) {
        for (String str : strings) {
            boolean isPalindrome = isPalindrome(str);
            System.out.println("Palindrome: " + str + (isPalindrome));// ? " is a palindrome." : " is NOT a palindrome."));
        }
    }

    public static boolean isPalindrome(String str) {
        String clean = str.replaceAll("\\s+", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }
}
