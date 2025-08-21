package com.workat.tech.practice.array;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        // Using Java 7 approach to find the longest common prefix
        System.out.println("Longest Common Prefix Using Java 7:");
        longestCommonPrefixJava7(strs);
        System.out.println("Longest Common Prefix Using Java 8:");
        longestCommonPrefixJava8(strs);
    }


    private static void longestCommonPrefixJava7(String[] strs) {
        if (strs == null || strs.length == 0) {
            System.out.println("");
            return;
        }
        // Take the first string as reference
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Reduce prefix until it matches the start of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    System.out.println("");
                }
            }
        }
        System.out.println(prefix) ;
    }

    public static void longestCommonPrefixJava8(String[] strs) {
        if (strs == null || strs.length == 0) {
            System.out.println("");
            return;
        }
        // Find the shortest string
        String shortest = Arrays.stream(strs)
                .min((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .get();

        int end = shortest.length();
        for (int i = 0; i < end; i++) {
            final int idx = i; // effectively final
            final char c = shortest.charAt(i);

            if (!Arrays.stream(strs).allMatch(s -> s.charAt(idx) == c)) {
                System.out.println(shortest.substring(0, i));
                return;
            }
        }
        // If no mismatch, whole shortest string is the prefix
        System.out.println(shortest);
    }
}
