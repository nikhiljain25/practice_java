package com.workat.tech.practice.string;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ReplaceVowelsWithIncreasingNumbers {
    public static void main(String[] args) {
        String input = "hello world";
        String result = replaceVowelsWithIncreasingNumbers(input);
        System.out.println(result); // Output: h1ll2 w3rld

        System.out.print("Second approach Using AtomicInteger: ");
        replaceVowelsWithIncreasingNumberUsingAtomicInteger(input);
    }

    // First approach: Using a loop to replace vowels with increasing numbers
    private static String replaceVowelsWithIncreasingNumbers(String input) {
        StringBuilder result = new StringBuilder();
        int vowelCount = 1; // Start counting vowels from 1

        for (char c : input.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowelCount++); // Append the current count and increment
            } else {
                result.append(c); // Append the character as is
            }
        }

        return result.toString();
    }

    private static boolean isVowel(char c) {
        // Check if the character is a vowel (case-insensitive)
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    // Second approach: Using regex to replace vowels with increasing numbers
    private static void replaceVowelsWithIncreasingNumberUsingAtomicInteger(String input) {
        AtomicInteger counter = new AtomicInteger(1);

        // Process string using Java 8 streams
        String result = input.chars()
                .mapToObj(c -> {
                    char ch = (char) c;
                    if ("aeiouAEIOU".indexOf(ch) != -1) {
                        // If vowel → replace with increasing number
                        return String.valueOf(counter.getAndIncrement());
                    } else {
                        return String.valueOf(ch);
                    }
                })
                .collect(Collectors.joining());

        System.out.println("Input  : " + input);
        System.out.println("Output : " + result);

    }
}
