package com.workat.tech.practice.string;

/*
String arr[] = { "abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm" };
Kindly write a java program for following output
Output:
[epam, pame, aepm] contains same character
[java, ajav] contains same character
[abcd, dcba] contains same character
 */

import java.util.*;
import java.util.stream.Collectors;

public class AnagramStringWithSorting {
    public static void main(String[] args) {
        String arr[] = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
        findMatchingStringsWithSortingUsingJava7(arr);
        findMatchingStringsWithSortingUsingJava8(arr);
    }

    // Finds matching strings using Java 7 style with sorting
    public static void findMatchingStringsWithSortingUsingJava7(String[] arr) {
        System.out.println("\nFinding matching strings using Java 7 style...");
        Map<String, List<String>> map = new HashMap<>();
        for(String str : arr) {
            String key = sortChars(str);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            if(entry.getValue().size() > 1) {
                System.out.println(entry.getValue() + " => contains same character");
            }
        }
    }

    // Finds matching strings using Java 8 style with streams
    public static void findMatchingStringsWithSortingUsingJava8(String[] arr) {
        System.out.println("\nFinding matching strings using Java 8 style...");
       Arrays.stream(arr)
               .collect(Collectors.groupingBy(str->sortChars(str)))
                       .values()
                       .stream()
                       .filter(group -> group.size() > 1)
                       .forEach(group -> System.out.println(group + "  => contains same character"));
    }

    public static String sortChars(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
