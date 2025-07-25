package com.workat.tech.practice.string;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingChar {
    public static void main(String[] args) {
        String str = "java is the best";

        System.out.println("First Non Repeating Char in Java 7 Implementation.....");
        findNonRepeatingCharUsingJava7(str);
        System.out.println("First Non Repeating Char in Java 8 Implementation.....");
        findNonRepeatingCharUsingJava8(str);
        System.out.println("All Non Repeating Char in Java 8 Implementation.....");
        findAllNonRepeatingCharUsingJava8(str);
    }

    private static void findNonRepeatingCharUsingJava8(String str) {
        Optional<Character> nonRepeatingChar = str.chars()
                .mapToObj(c-> (char)c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(e-> e.getValue() == 1)
                .map(Map.Entry :: getKey)
                .findFirst();
        System.out.println(nonRepeatingChar.orElse(null));
    }


    private static void findAllNonRepeatingCharUsingJava8(String str) {
        List<Character> nonRepeatingChar = str.chars()
                .mapToObj(c-> (char)c)
                .collect(
                        Collectors.groupingBy(
                        Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(e-> e.getValue() == 1)
                .map(Map.Entry :: getKey)
                .collect(Collectors.toList());
                //.findFirst();

        System.out.println(nonRepeatingChar);
    }

    private static void findNonRepeatingCharUsingJava7(String str) {
        Map<Character, Long> charCountMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0L) + 1);
        }

        for (Map.Entry<Character, Long> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("No non-repeating character found.");
    }
}
