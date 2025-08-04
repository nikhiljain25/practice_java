package com.workat.tech.practice.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RetrieveNonDuplicateElementLists {
    public static void main(String[] args) {
        List<String> list1 = List.of("Apple", "Banana", "Mango");
        List<String> list2 = Arrays.asList("Tomato", "Onion", "Apple");
//        getNonDuplicateElementFromList(list1, list2);
//        getNonDuplicateElementFromListOptimized1(list1, list2);
        getNonDuplicateElementFromListOptimized2(list1, list2);
    }


    private static void getNonDuplicateElementFromList(List<String> list1, List<String> list2) {
        Set<String> common = list1.stream()
                .map(String::toLowerCase)
                .filter(e ->
                        list2.stream()
                                .map(String::toLowerCase)
                                .anyMatch(e::equals))
                .collect(Collectors.toSet());

        List<String> result = Stream.concat(list1.stream(), list2.stream())
                .filter(item -> !common.contains(item.toLowerCase()))
                .toList();
        System.out.println("Result (excluding common elements): \n " + result);
    }


    private static void getNonDuplicateElementFromListOptimized1(List<String> list1, List<String> list2) {
        List<String> result = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println("Result (excluding common elements): \n " + result);
    }


    private static void getNonDuplicateElementFromListOptimized2(List<String> list1, List<String> list2) {
        List<String> result = Stream.concat(list1.stream(), list2.stream())
                .filter(item -> list1.stream()
                        .map(String::toLowerCase)
                        .noneMatch(e ->
                                list2.stream()
                                        .anyMatch(t ->
                                                t.equalsIgnoreCase(e)) && e.equals(item.toLowerCase())))
                .toList();
        System.out.println("Result (excluding common elements): \n " + result);

    }
}
