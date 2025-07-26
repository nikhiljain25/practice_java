package com.workat.tech.practice.sorting;

import com.workat.tech.practice.stream.Employee;

import java.util.Comparator;

public class CustomerComparators {
    public static Comparator<Customer> byName  =
            Comparator.comparing(Customer::getName);
    public static Comparator<Customer> byAge   =
            Comparator.comparingInt(Customer::getAge);
    public static Comparator<Customer> byNameThenAge =
            Comparator.comparing(Customer::getName)
                      .thenComparingInt(Customer::getAge);
}
