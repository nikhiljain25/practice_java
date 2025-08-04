package com.workat.tech.practice.string;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    * This program demonstrates how to find the occurrence of each character in a string.
    * Input: "I love my india"
    * Output: a: 1 d: 1 e: 1 v: 1 i: 2 y: 1 I: 1 l: 1 m: 1 n: 1 o: 1
    * If case sensitivity is required, use the second method.
    * Output: a: 1 d: 1 e: 1 v: 1 i: 3 y: 1 l: 1 m: 1 n: 1 o: 1
 */

public class CharOccurrenceInString {
    public static void main(String[] args) {
        String input = "I love my india";

        /*
             Output :
             a: 1, d: 1, e: 1, v: 1, i: 2, y: 1, I: 1, l: 1, m: 1, n: 1, o: 1
         */
        System.out.println("\n--------------------OUTPUT-1-----------------------------");
        GetOccurrenceOfCharFromStringUsingMapCharacter(input);
        System.out.println("\n\n--------------------OUTPUT-2-----------------------------");
        /*
             Output :
             a: 1, d: 1, e: 1, v: 1, i: 3, y: 1,, l: 1, m: 1, n: 1, o: 1
        * */
        GetOccurrenceOfCharFromStringUsingMapCharCaseSensitive(input);
    }


    private static void GetOccurrenceOfCharFromStringUsingMapCharacter(String input) {
        Map<Character, Long> frequencyMap = input.chars()
                .filter(ch -> ch != ' ') // ignore spaces
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        frequencyMap.forEach((k, v) -> System.out.print(k + ": " + v + " "));
    }

    private static void GetOccurrenceOfCharFromStringUsingMapCharCaseSensitive(String input) {
        Map<Character, Long> frequencyMap = input.toLowerCase().chars()
                .filter(ch -> ch != ' ') // ignore spaces
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        frequencyMap.forEach((k, v) -> System.out.print(k + ": " + v + " "));
        System.out.println("\n");
    }
}
