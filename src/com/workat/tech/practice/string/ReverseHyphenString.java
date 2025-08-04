package com.workat.tech.practice.string;

/*
   Reverse String with Hyphen Delimiter
   Input: a-java-program-for-reverse-string
   output: g-nirt-sesreve-rro-fmargor-pavaja
 */

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseHyphenString {

    public static void main(String[] args) {
        String input = "a-java-program-for-reverse-string";

        //reverseHyphenStringUsingJava7(input);
//        reverseHyphenStringUsingJava8(input);
        optimizedReverseHyphenStringUsingJava8(input);
    }

    private static void reverseHyphenStringUsingJava7(String input) {
        // Store hyphen positions (true = hyphen, false = character)
        boolean[] hyphenPositions = new boolean[input.length()];
        StringBuilder charactersOnly = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-') {
                hyphenPositions[i] = true;
            } else {
                charactersOnly.append(input.charAt(i));
            }
        }
        // Reverse only the characters (not hyphens)
        charactersOnly.reverse();
        // Build final output with hyphens at original positions
        StringBuilder result = new StringBuilder();
        int charIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            if (hyphenPositions[i]) {
                result.append('-');
            } else {
                result.append(charactersOnly.charAt(charIndex++));
            }
        }
        System.out.println("Output: " + result.toString());
    }

    private static void reverseHyphenStringUsingJava8(String input) {
        // Step 1: Collect only characters (skip hyphens)
        String charactersOnly = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != '-')
                .map(String::valueOf)
                .collect(Collectors.joining());
        // Step 2: Reverse the collected characters
        String reversedCharacters = new StringBuilder(charactersOnly)
                .reverse().toString();
        // Step 3: Rebuild the output while preserving hyphen positions
        StringBuilder result = new StringBuilder();
        final int[] charIndex = {0}; // use array for mutable integer in lambda

        IntStream.range(0, input.length())
                .mapToObj(i ->
                        input.charAt(i) == '-' ? "-" : String.valueOf(
                                reversedCharacters.charAt(charIndex[0]++)))
                .forEach(result::append);
        // Output result
        System.out.println("Output: " + result.toString());
    }

    private static void optimizedReverseHyphenStringUsingJava8(String input) {
        // Extract and reverse all non-hyphen characters
        String reversedLetters = new StringBuilder(
                input.replaceAll("-", "")
        ).reverse().toString();
        // Rebuild output with hyphens at original positions
        final int[] index = {0}; // mutable index for lambda
        String result = input.chars()
                .mapToObj(c ->
                        (char) c == '-' ? "-" : String.valueOf(
                                reversedLetters.charAt(index[0]++)))
                .collect(Collectors.joining());

        System.out.println("Output: " + result);
    }
}

