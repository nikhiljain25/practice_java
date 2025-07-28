package com.workat.tech.practice.collection;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
     printing only those months that do not end with "ber"
 */
public class MonthDemo {
    public static void main(String[] args) {
        List<String> list = List.of(
                "January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October",
                "November", "December"
        );

        List<String>result = list.stream()
                .filter(month -> !month.endsWith("ber") )
                .collect(Collectors.toList());
        System.out.println("Months that do not end with 'ber':");
        if (result.isEmpty()) {
            System.out.println("No months found that do not end with 'ber'.");
        } else {
            result.forEach(System.out::println);
        }
    }
}
