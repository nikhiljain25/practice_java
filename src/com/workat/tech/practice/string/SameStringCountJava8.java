package com.workat.tech.practice.string;

import java.util.*;
import java.util.stream.Collectors;


/*
Input:
 String arr[] = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
Output:
Finding same string count...
Strings: java ajav | Count: 2
Strings: xyz | Count: 1
Strings: epam pame aepm | Count: 3
Strings: abcd dcba | Count: 2
 */
public class SameStringCountJava8 {

    public static void main(String[] args) {
        String arr[] = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
        findSameStringCountsWithSingleStringUsingListJava8(arr);
        findSameStringCountsUsingStreamsJava8(arr);
        printSameStringCountsUsingJava8(arr);
        printSameStringKeyAndCountsUsingJava8(arr);
        printGroupedStringsAndCountsUsingJava8(arr);
        printGroupedStringsAndCountsWithoutForEachJava8(arr);
        printGroupedStringsAndCountsJava8(arr);
    }

    // Using java 8 streams
    public static void findSameStringCountsWithSingleStringUsingListJava8(String[] arr) {
        System.out.println("Finding same string count using java 8...");
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : arr) {
            String key = getCharFrequencyKey(str);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            groupMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        groupMap.forEach((key, strings) ->
                System.out.println("Strings: " + String.join(" ", strings) + " | Count: " + countMap.get(key))
        );
    }

    public static void findSameStringCountsUsingStreamsJava8(String[] arr) {
        System.out.println("Finding same string count...");
        Map<String, List<String>> groupMap = Arrays.stream(arr)
                .collect(Collectors.groupingBy(SameStringCountJava8::getCharFrequencyKey));

        groupMap.forEach((key, strings) ->
                System.out.println("Strings: " + String.join(" ", strings) + " | Count: " + strings.size())
        );
    }

    public static void printSameStringCountsUsingJava8(String[] arr) {
        System.out.println("Finding same string count...");
        Arrays.stream(arr)
                .collect(Collectors.groupingBy(SameStringCountJava8::getCharFrequencyKey, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println("Count: " + entry.getValue()));
    }

    public static void printSameStringKeyAndCountsUsingJava8(String[] arr) {
        System.out.println("Finding same string key and count...");
        Arrays.stream(arr)
                .collect(Collectors.groupingBy(SameStringCountJava8::getCharFrequencyKey, Collectors.counting()))
                .forEach((key, count) -> System.out.println("Key: " + key + " | Count: " + count));
    }

    public static void printGroupedStringsAndCountsUsingJava8(String[] arr) {
        System.out.println("Finding same string count...");
        Arrays.stream(arr)
                .collect(Collectors.groupingBy(SameStringCountJava8::getCharFrequencyKey))
                .forEach((key, strings) -> {
                    if (strings.size() > 1) {
                        System.out.println("Strings: " + String.join(" ", strings) + " | Count: " + strings.size());
                    }
                });
    }

    public static void printGroupedStringsAndCountsWithoutForEachJava8(String[] arr) {
        System.out.println("Finding same string count...");
        Map<String, List<String>> groupMap = Arrays.stream(arr)
                .collect(Collectors.groupingBy(SameStringCountJava8::getCharFrequencyKey));

        for (Map.Entry<String, List<String>> entry : groupMap.entrySet()) {
            List<String> strings = entry.getValue();
            if (strings.size() > 1) {
                System.out.println("Strings: " + String.join(" ", strings) + " | Count: " + strings.size());
            }
        }
    }

    public static void printGroupedStringsAndCountsJava8(String[] arr) {
        System.out.println("Finding same string count...");
        Arrays.stream(arr)
                .collect(Collectors.groupingBy(SameStringCountJava8::getCharFrequencyKey, Collectors.mapping(s -> s, Collectors.toList())))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1) // We can remove this filter if we want to print all groups
                .map(entry -> "Strings: " + String.join(" ", entry.getValue()) + " | Count: " + entry.getValue().size())
                .forEach(System.out::println);
    }

    // Generates a key based on character frequency
    public static String getCharFrequencyKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}