package com.workat.tech.practice.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseStringJava8 {

    /*
        Reversed 1.......
        Original: a-java-program-for-reverse-string
        Reversed: gnirts-esrever-rof-margorp-avaj-a

        Reversed 2.......
        Original: a-java-program-for-reverse-string
        Reversed: gnirts-esrever-rof-margorp-avaj-a

        Reversed 3.......
        Original: a-java-program-for-reverse-string
        Reversed: a-avaj-margorp-rof-esrever-gnirts

        Reversed 4.......
        Original: a-java-program-for-reverse-string
        eversed: gnirts-esrever-rof-margorp-avaj-a

        Reversed 5.......
        Original: a-java-program-for-reverse-string
        Reversed: gnirts-esrever-rof-margorp-avaj-a
     */

    public static void main(String[] args) {
        String input = "a-java-program-for-reverse-string";

        System.out.println("\nReversed 1....... ");
        String reversed1 = reverseStringJava8(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed1);

        System.out.println("\nReversed 2....... ");
        String reversed2 = reverseStringJava8UsingCollections(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed2);

        System.out.println("\nReversed 3....... ");
        String reversed3 = reverseStringDelimiterUsingJava8(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed3);

        System.out.println("\nReversed 4....... ");
        String reversed4 = reverseStringDelimiterSamePlaceUsingJava8(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed4);

        System.out.println("\nReversed 5....... ");
        String reversed5 = reverseStringWithoutStringBuilder(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed5);
    }

    public static String reverseStringJava8(String input) {
        return IntStream.range(0, input.length())
                .mapToObj(i -> input.charAt(input.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static String reverseStringJava8UsingCollections(String input) {
        List<Character> charList = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.reverse(charList);
        return charList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    // String reverse method but delimiter will be same as original string
    public static String reverseStringDelimiterUsingJava8(String str) {
        // Reverse string using java 8 streams with splitting by delimiter
        // After reverse string delimiter will be same as original string
        String result = Arrays.stream(str.split("-"))
                .map(part -> new StringBuilder(part)
                .reverse()
                .toString())
                .collect(Collectors.joining("-"));
        return result;
    }

    public static String reverseStringDelimiterSamePlaceUsingJava8(String str) {
        List<String> parts = Arrays.stream(str.split("-"))
                .map(part -> new StringBuilder(part)
                 .reverse()
                 .toString())
                .collect(Collectors.toList());
        Collections.reverse(parts);
        return String.join("-", parts);
    }

    public static String reverseStringWithoutStringBuilder(String str) {
        List<String> parts = Arrays.stream(str.split("-"))
                .map(ReverseStringJava8::reverseManually)
                .collect(Collectors.toList());
        Collections.reverse(parts);
        return String.join("-", parts);
    }

    private static String reverseManually(String input) {
        return getString(input);
    }

    static String getString(String input) {
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
