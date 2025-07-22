package com.workat.tech.practice.collection;

import java.util.*;
import java.util.stream.Collectors;

public class FindSecondHighestNumberAndCount {
    public static void main(String[] args) {
        int[] arr = {10, 9, 9, 8, 9, 10, 5};

        // Step 1: Convert int[] to List<Integer>
        findSecondHighestValueAndCountFromArray(arr);
        System.out.println("Optimized Way:");
        findSecondHighestValueAndCountFromArrayOptimizedWay(arr);
    }

    private static void findSecondHighestValueAndCountFromArray(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        // Step 2: Find second highest number
        int secondHighest = list.get(1);
        System.out.println("Second Highest Number: " + secondHighest);

        // Step 3: Find frequency
        long count = Arrays.stream(arr)
                .filter(num -> num == secondHighest)
                .count();
        System.out.println("\"" + secondHighest + " - " + count + "\"" );
    }

    private static void findSecondHighestValueAndCountFromArrayOptimizedWay(int[] arr) {
        Map<Integer, Long> frequencyMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        Optional<Map.Entry<Integer, Long>> secondHighestEntry = frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByKey().reversed())
                .skip(1)
                .findFirst();

        secondHighestEntry.ifPresent(entry ->
                System.out.println("\"" + entry.getKey() + " - " + entry.getValue() + "\"")
        );
    }
}
