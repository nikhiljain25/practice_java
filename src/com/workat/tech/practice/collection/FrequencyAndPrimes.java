package com.workat.tech.practice.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencyAndPrimes {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2, 3, 5};

        // Step 1: Convert int[] to List<Integer>
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        // Step 2: Find frequency of each number
        Map<Integer, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        // Print frequency
        System.out.println("Occurrences:");
        frequencyMap.forEach((num, count) ->
                System.out.println(num + " occurs " + count + " time(s)"));

        // Step 3: Extract prime numbers from the list (distinct only)
        List<Integer> primes = list.stream()
                .distinct()
                .filter(FrequencyAndPrimes::isPrime)
                .collect(Collectors.toList());

        System.out.println("\nPrime Numbers: " + primes);
    }

    // Prime number check
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        return IntStream.rangeClosed(2, (int)Math.sqrt(n))
                .allMatch(i -> n % i != 0);
    }
}