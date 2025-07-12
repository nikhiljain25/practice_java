package com.workat.tech.practice.string;

import java.util.StringJoiner;

public class ReverseStringJava7 {

    public static void main(String[] args) {
        String input = "a-java-program-for-reverse-string";
//        String reversed = reverseStringUsingStringBuilderJava7(input);
//        String reversed = reverseStringUsingStringBufferJava7(input);
//        String reversed = reverseStringJava7(input);
//        String reversed = reverseStringInSamePlaceUsingJava7(input);
        String reversed = reverseStringSameDelimiterPositionUsingJava7(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }

    public static String reverseStringUsingStringBuilderJava7(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseStringJava7(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static String reverseStringUsingStringBufferJava7(String input) {
        StringBuffer sb = new StringBuffer();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseStringInSamePlaceUsingJava7(String input) {
        String str = "a-java-program-for-reverse-string";
        String[] parts = str.split("-");
        StringJoiner result = new StringJoiner("-");
        for (String part : parts) {
            result.add(new StringBuilder(part).reverse().toString());
        }
        return result.toString();
    }

    public static String reverseStringSameDelimiterPositionUsingJava7(String str) {
        String[] parts = str.split("-");
        // Reverse each part
        for (int i = 0; i < parts.length; i++) {
            parts[i] = reverseManually(parts[i]);
        }
        // Reverse the order of parts
        StringJoiner result = new StringJoiner("-");
        for (int i = parts.length - 1; i >= 0; i--) {
            result.add(parts[i]);
        }
        return result.toString();
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
