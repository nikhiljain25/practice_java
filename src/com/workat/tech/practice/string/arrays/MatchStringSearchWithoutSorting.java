package com.workat.tech.practice.string.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class MatchStringSearchWithoutSorting {

    private static String getCharFrequencyKey(String str) {
        int[] freq = new int[50]; // Assuming ASCII characters
        for(char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        return Arrays.toString(freq);
    }

    public static void findMatchingStringsWithoutSortingUsingJava7(String[] arr) {
        System.out.println("\nFinding matching strings using Java 7 style without sorting...");
        Map<String, List<String>> map = new HashMap<>();

        for(String str : arr) {
            String key = getCharFrequencyKey(str);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for(List<String> group : map.values()) {
            if(group.size() > 1) {
                System.out.println(group + " => contains same character");
            }
        }
    }

    // Finds matching strings using Java 8 style without sorting
    public static void findMatchingStringsWithoutSortingUsingJava8(String[] arr) {
        System.out.println("\nFinding matching strings using Java 8 style without sorting...");
        Arrays.stream(arr)
                .collect(Collectors.groupingBy(MatchStringSearchWithoutSorting::getCharFrequencyKey))
                .values()
                .stream()
                .filter(group -> group.size() > 1)
                .forEach(group -> System.out.println(group + " => contains same character"));
    }

    public static void main(String[] args) {
        String arr[] = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
        findMatchingStringsWithoutSortingUsingJava7(arr);
        findMatchingStringsWithoutSortingUsingJava8(arr);
    }
}
