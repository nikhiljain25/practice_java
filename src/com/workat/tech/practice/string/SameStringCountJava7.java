package com.workat.tech.practice.string;

import java.util.*;

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
public class SameStringCountJava7 {

    public static void main(String[] args) {
        String arr[] = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
        findSameStringCount(arr);
        findSameStringCounts(arr);
        findSameStringCountsUsingList(arr);
        findSameStringCountsUsingListJava7(arr);
        findSameStringCountsWithSingleStringUsingListJava7(arr);
    }

    public static void findSameStringCount(String[] arr) {
        System.out.println("Finding same string count...");
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : arr) {
            String key = getCharFrequencyKey(str);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Count: " + entry.getValue());
            }
        }
    }

    // Using StringBuilder to group same strings
    public static void findSameStringCounts(String[] arr) {
        System.out.println("Finding same string count...");
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, StringBuilder> groupMap = new HashMap<>();
        for (String str : arr) {
            String key = getCharFrequencyKey(str);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            groupMap.computeIfAbsent(key, k -> new StringBuilder()).append(str).append(" ");
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Strings: " + groupMap.get(entry.getKey()).toString().trim() +
                        " | Count: " + entry.getValue());
            }
        }
    }

    // Without using StringBuilder
    public static void findSameStringCountsUsingList(String[] arr) {
        System.out.println("Finding same string count...");
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : arr) {
            String key = getCharFrequencyKey(str);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            groupMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Strings: " + String.join(" ", groupMap.get(entry.getKey())) +
                        " | Count: " + entry.getValue());
            }
        }
    }

    // Same using java 7
    public static void findSameStringCountsUsingListJava7(String[] arr) {
        System.out.println("Finding same string count...");
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        Map<String, List<String>> groupMap = new HashMap<String, List<String>>();
        for (String str : arr) {
            String key = getCharFrequencyKey(str);
            if (!countMap.containsKey(key)) {
                countMap.put(key, 0);
            }
            countMap.put(key, countMap.get(key) + 1);
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());
            }
            groupMap.get(key).add(str);
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Strings: " + joinStrings(groupMap.get(entry.getKey())) +
                        " | Count: " + entry.getValue());
            }
        }
    }

    private static String joinStrings(List<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            sb.append(strings.get(i));
            if (i < strings.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void findSameStringCountsWithSingleStringUsingListJava7(String[] arr) {
        System.out.println("Finding same string count...");
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        Map<String, List<String>> groupMap = new HashMap<String, List<String>>();
        for (String str : arr) {
            String key = getCharFrequencyKey(str);
            if (!countMap.containsKey(key)) {
                countMap.put(key, 0);
            }
            countMap.put(key, countMap.get(key) + 1);
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());
            }
            groupMap.get(key).add(str);
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println("Strings: " + joinStrings(groupMap.get(entry.getKey())) +
                    " | Count: " + entry.getValue());
        }
    }

    // Generates a key based on character frequency
    public static String getCharFrequencyKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
