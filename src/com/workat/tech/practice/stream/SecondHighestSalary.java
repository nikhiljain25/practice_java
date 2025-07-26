package com.workat.tech.practice.stream;

import java.util.*;

public class SecondHighestSalary {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Alice", 50000),
            new Employee("Bob", 70000),
            new Employee("Charlie", 60000),
            new Employee("David", 70000),
            new Employee("Eve", 40000)
        };
        System.out.println("\nJava 7 Implementation..");
        System.out.println("*********************");
        int secondHighestSalaryJava7 = findSecondHighestSalaryUsingJava7(employees);
        System.out.println("The second highest salary is: " + secondHighestSalaryJava7);

        System.out.println("\nJava 8 Implementation..");
        System.out.println("***********************");
        Optional<Double> secondHighestSalaryJava8 = findSecondHighestSalaryUsingJava8(employees);
        System.out.println("The second highest salary is: " + secondHighestSalaryJava8.orElse(null));
    }

     private static Optional<Double> findSecondHighestSalaryUsingJava8(Employee[] employees) {
        List<Employee> employee = Arrays.asList(employees);
        Optional<Double> secondHighestSalary = employee.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1) // Skip the highest salary
                .findFirst().map(salary -> salary.doubleValue());

        return secondHighestSalary;
    }

    public static int findSecondHighestSalaryUsingJava7(Employee[] employees) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (Employee employee : employees) {
            if (employee.getSalary() > highest) {
                secondHighest = highest;
                highest = employee.getSalary();
            } else if (employee.getSalary() > secondHighest && employee.getSalary() < highest) {
                secondHighest = employee.getSalary();
            }
        }
        return secondHighest;
    }
}
