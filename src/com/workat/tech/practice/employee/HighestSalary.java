package com.workat.tech.practice.employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class HighestSalary {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Alice", 50000),
                new Employee("Bob", 70000),
                new Employee("Charlie", 60000),
                new Employee("David", 70000),
                new Employee("Eve", 40000)
        };
        System.out.println("\nJava 7 Implementation..");
        System.out.println("***********************");
        int highestSalaryJava7 = findHighestSalaryUsingJava7(employees);
        System.out.println("The Highest salary is: " + highestSalaryJava7);

        System.out.println("\nJava 8 Implementation..");
        System.out.println("***********************E");
        Optional<Double> highestSalaryJava8 = findHighestSalaryUsingJava8(employees);
        System.out.println("The Highest salary is: " + highestSalaryJava8.orElse(null));
    }

    private static Optional<Double> findHighestSalaryUsingJava8(Employee[] employees) {
        List<Employee> employee = Arrays.asList(employees);
        Optional<Double> highestSalary = employee.stream()
                .map(Employee::getSalary)
                .max(Comparator.naturalOrder()).map(salary -> salary.doubleValue());
        return highestSalary;
    }

    public static int findHighestSalaryUsingJava7(Employee[] employees) {
        int highest = Integer.MIN_VALUE;

        for (Employee employee : employees) {
            if (employee.getSalary() > highest) {
                highest = employee.getSalary();
            }
        }
        return highest;
    }
}
