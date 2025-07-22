package com.workat.tech.practice.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateWord {
    public static void main(String[] args) {
        String input = "This is a test This is only a test";
        System.out.println("Input: " + input);
        System.out.println("Duplicate words: " + findDuplicateWords(input));
        System.out.println("Duplicate words using Java 8: ");
        findDuplicateWordsUsingJava8(input);
        System.out.println("Duplicate words using using Map in Java 8: ");
        findDuplicateWordsUsingMapJava8(input);
    }

    private static void findDuplicateWordsUsingJava8(String input) {
        List<String> duplicates = Arrays.stream(input.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .sorted() // Output will be sorted
                .collect(Collectors.toList());
        System.out.println("Duplicate words: " + duplicates);
    }

    public static void findDuplicateWordsUsingMapJava8 (String input) {
        Map<String, Long> duplicateCounts = Arrays.stream(input.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new// In case of key collision, keep the first one
                ));

        // Print outside the logic
        for (Map.Entry<String, Long> entry : duplicateCounts.entrySet()) {
            System.out.println("Word: '" + entry.getKey() + "', Count: " + entry.getValue());
        }
    }

    /**
     * Finds duplicate words in a given string, ignoring case.
     *
     * @param input the input string
     * @return a string containing the duplicate words separated by spaces
     */
   /* public static String findDuplicateWords(String input) {
        String[] words = input.split("\\s+");
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            if (!seen.add(lowerWord)) {
                duplicates.add(word);
            }
        }
        return String.join(" ", duplicates);
    }*/
    public static String findDuplicateWords(String string) {
        //Initialize count
        int count;
        //Converts the string into lowercase
        string = string.toLowerCase();
        //Split the string into words using built-in function
        String words[] = string.split(" ");
        System.out.println("Duplicate words in a given string : ");
        for (int i = 0; i < words.length; i++) {
            count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                    //Set words[j] to 0 to avoid printing visited word
                    words[j] = "0";
                }
            }
            //Displays the duplicate word if count is greater than 1
            if (count > 1 && words[i] != "0")
                System.out.println(words[i]);
        }
        return string;
    }
}
