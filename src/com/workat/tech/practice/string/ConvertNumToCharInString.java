package com.workat.tech.practice.string;

/*
  Input: Welcome to Mis2is2ip2i Bla4k Adam
  Output:Welcome to Mississippi Blaaaak Adam
 */

import java.util.stream.IntStream;

public class ConvertNumToCharInString {
    public static void main(String[] args) {
        String input = "Welcome to Mis2is2ip2i Bla4k Adam";
        convertNumToCharInStringUsingJava7(input);
        convertNumToCharInStringUsingJava8(input);
    }

    private static void convertNumToCharInStringUsingJava7(String input) {
        StringBuilder result = new StringBuilder();
        final int MAX_REPEAT = 50; // Prevent out-of-memory from large numbers

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (Character.isDigit(current) && i > 0) {
                int repeatCount = Character.getNumericValue(current);
                repeatCount = Math.min(repeatCount, MAX_REPEAT); // safety cap

                char prevChar = input.charAt(i - 1);

                for (int j = 0; j < repeatCount; j++) {
                    result.append(prevChar);
                }
            } else if (!Character.isDigit(current)) {
                result.append(current);
            }
        }
        System.out.println("Result: " + result.toString());
    }

    private static void convertNumToCharInStringUsingJava8(String input) {
        StringBuilder result = new StringBuilder();
        final int MAX_REPEAT = 50; // safety limit

        IntStream.range(0, input.length()).forEach(i -> {
            char current = input.charAt(i);

            if (Character.isDigit(current) && i > 0) {
                int repeatCount = Character.getNumericValue(current);

                // Clamp repeatCount to avoid heap issues
                repeatCount = Math.min(repeatCount, MAX_REPEAT);

                char prevChar = input.charAt(i - 1);
                IntStream.range(0, repeatCount).forEach(j -> result.append(prevChar));

            } else if (!Character.isDigit(current)) {
                result.append(current);
            }
        });
        System.out.println("Result: " + result.toString());
    }
}