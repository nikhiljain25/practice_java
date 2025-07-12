package com.workat.tech.practice.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseStringJava8 {

    public static void main(String[] args) {
        String input = "a-java-program-for-reverse-string";
//        String reversed = reverseStringJava8(input);
//        String reversed = reverseStringJava8UsingCollections(input);
//        String reversed = reverseStringInSamePlaceUsingJava8(input);
//        String reversed = reverseStringDelimiterUsingJava8(input);
//        String reversed = reverseStringDelimiterSamePlaceUsingJava8(input);
        String reversed = reverseStringWithoutStringBuilder(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
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

    // Reverse string using java 8 streams with splitting by delimiter
    // After reverse sting delimiter will be same as original string
    public static String reverseStringInSamePlaceUsingJava8(String str) {
        String result = Arrays.stream(str.split("-"))
                .map(part-> new StringBuilder(part)
                        .reverse()
                        .toString())
                .collect(Collectors.joining("-"));
        return result;
    }


    // String reverse method but delimiter will be same as original string
    public static String reverseStringDelimiterUsingJava8(String str) {
        // Reverse string using java 8 streams with splitting by delimiter
        // After reverse string delimiter will be same as original string
        String result = Arrays.stream(str.split("-"))
                .map(part -> new StringBuilder(part).reverse().toString())
                .collect(Collectors.joining("-"));
        return result;
    }

    public static String reverseStringDelimiterSamePlaceUsingJava8(String str) {
        List<String> parts = Arrays.stream(str.split("-"))
                .map(part -> new StringBuilder(part).reverse().toString())
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
