package com.workat.tech.practice.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharacters {
    public static void main(String[] args) {
        String input = "Java is the Best";


        System.out.println("Duplicate characters in Java 7 Implementation.....");
        findDuplicateCharUsingJava7(input);
        System.out.println("Duplicate characters in Java 8 Implementation.....");
        findDuplicateCharUsingJava8(input);
    }

    private static void findDuplicateCharUsingJava8(String input) {
        Map<Character, Long> duplicateChars = input.chars() // Step 1
                .mapToObj(c -> (char) c)                      // Step 2: convert int to Character
                .collect(Collectors.groupingBy(               // Step 3: group by char
                        Function.identity(),                      // key: character
                        LinkedHashMap::new,                       // maintain order
                        Collectors.counting()                     // count occurrences
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)                // Step 4: keep only duplicates
                .collect(Collectors.toMap(                    // Step 5: collect to map
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new                        // maintain original order
                ));

        System.out.println("Duplicate characters and counts: " + duplicateChars);
    }

    private static void findDuplicateCharUsingJava7(String input) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> duplicateChars = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateChars.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println("Duplicate characters and counts: " + duplicateChars);
    }
}
