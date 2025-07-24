package com.workat.tech.practice.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringFinder {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "pineapple", "kiwi tastes good",
                "grapefruit", "orange", "strawberry", "blueberry", "watermelon is good for health");

        System.out.println("\nJava 7 Implementation..");
        findLongestStringUsingJava7(strings);
        System.out.println("\nJava 8 Implementation..");
        findLongestStringUsingJava8(strings);
    }


    public static void findLongestStringUsingJava7(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            System.out.println("The list is empty or null.");
            return;
        }
        String longest = "";
        for (String str : strings) {
            if (str.length() > longest.length()) {
                longest = str;
            }
        }
        System.out.println("Longest string is: " + longest);
    }

    public static void findLongestStringUsingJava8(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            System.out.println("The list is empty or null.");
            return;
        }
        String longest = strings.stream()
                .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .orElse("");
        System.out.println("\nLongest string is : " + longest);
        String longest1 = strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("\nLongest string using Comparator logic : " + longest1);
    }
}
