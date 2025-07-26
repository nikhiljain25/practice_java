package com.workat.tech.practice.sorting;

import java.util.Arrays;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {
        List<Customer> customers = Arrays.asList(
                new Customer("Alice", 30, "123 Main St"),
                new Customer("Bob", 25, "456 Elm St"),
                new Customer("Charlie", 35, "789 Oak St"),
                new Customer("Alice", 28, "321 Maple St"),
                new Customer("David", 30, "654 Pine St")
        );

        System.out.println("Original: ");
         customers.forEach(System.out::println);

         // Sort by name
        customers.sort(CustomerComparators.byName);
        System.out.println("\nSorted by Name: ");
        customers.forEach(System.out::println);

        // Sort by age
        customers.sort(CustomerComparators.byAge);
        System.out.println("\nSorted by Age: ");
        customers.forEach(System.out::println);

        // Sort by name then age
        customers.sort(CustomerComparators.byNameThenAge);
        System.out.println("\nSorted by Name then Age: ");
        customers.forEach(System.out::println);
    }
}
