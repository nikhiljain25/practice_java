package com.workat.tech.practice.string;

/*
 * This code checks if a given string is a palindrome.
 * A palindrome reads the same backward as forward, ignoring spaces and case.
 */
public class PalindromeString {
    public static void main(String[] args) {
       String str = "Madam";
        boolean isPalindrome = isPalindrome(str);
        System.out.println(str + (isPalindrome ? " is a palindrome." : " is NOT a palindrome."));
    }

    public static boolean isPalindrome(String str) {
        String clean = str.replaceAll("\\s+", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }
}
