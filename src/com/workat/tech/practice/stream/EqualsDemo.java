package com.workat.tech.practice.stream;

public class EqualsDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 50000);
        Employee emp2 = new Employee("Alice", 50000);
        Employee emp3 = new Employee("Bob", 50000);

        // Using equals method to compare objects
        System.out.println(emp1==emp2); // Should return true if equals is overridden
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2)); // Should return true if equals is overridden
        System.out.println("emp1 equals emp3: " + emp1.equals(emp3)); // Should return false
    }
}
