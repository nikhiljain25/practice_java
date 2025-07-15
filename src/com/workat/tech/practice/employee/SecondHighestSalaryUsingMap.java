package com.workat.tech.practice.employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class SecondHighestSalaryUsingMap {
    public static void main(String[] args) {
        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, new Employee("Alice", 50000));
        map.put(2, new Employee("Bob", 70000));
        map.put(3, new Employee("Charlie", 60000));
        map.put(4, new Employee("David", 70000));
        map.put(5, new Employee("Eve", 20000));
        map.put(6, new Employee("Frank", 80000));

        //GetSecondHighestSalaryOfEmployeeUsingCompareTo(map);
        GetSecondHighestSalaryOfEmployeeUsingStream(map);
    }


    private static void GetSecondHighestSalaryOfEmployeeUsingCompareTo(Map<Integer, Employee> map) {
        map.values().stream()
            .map(Employee::getSalary)
            .distinct()
            .sorted((a, b) -> b.compareTo(a)) // Sort in descending order
            .skip(1) // Skip the highest salary
            .findFirst() // Get the second highest salary
            .ifPresentOrElse(
                salary -> System.out.println("The second highest salary is: " + salary),
                () -> System.out.println("No second highest salary found.")
            );
    }

    private static void GetSecondHighestSalaryOfEmployeeUsingStream(Map<Integer, Employee> map) {
        List<Integer> empList = map.values().stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
               // .skip(1)
                //.ifPresent(salary -> System.out.println("The second highest salary is: " + salary));

        //One approach to print the second highest salary
//        map.entrySet().stream()
//                .filter(entry -> entry.getValue().getSalary() == empList.get(1))
//                .forEach(entry -> {
//                 int id = entry.getKey();
//                 Employee emp = entry.getValue();
//                    System.out.println("Id: " + id + ", Name: " + emp.getName() + ", Salary: " + emp.getSalary());
//                });

        // Second Approach to print the second highest salary
       String result = map.entrySet().stream()
                .filter(entry -> entry.getValue().getSalary() == empList.get(1))
                .map(entry -> {
                 int id = entry.getKey();
                 Employee emp = entry.getValue();
                 return  "\nId: " + id + ", Name: " + emp.getName() + ", Salary: " + emp.getSalary();
//                 String s =  "Id: " + id + ", Name: " + emp.getName() + ", Salary: " + emp.getSalary();
//                 return s;
                })
                .collect(Collectors.joining());

        System.out.println("\n" + result);
    }
}
