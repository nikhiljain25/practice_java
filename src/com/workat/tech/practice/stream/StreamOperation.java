package com.workat.tech.practice.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperation {
    public static void main(String[] args) {
        List<Employee1> employeeList = new ArrayList<>();
        employeeList.add(new Employee1(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee1(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee1(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee1(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee1(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee1(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee1(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee1(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee1(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee1(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee1(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee1(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));

        // Calculate max age of employees
        Optional<Employee1> maxAgeEmp = employeeList.stream()
                .max(Comparator.comparing(Employee1::getAge));
        maxAgeEmp.ifPresent(emp->
                System.out.println("Max Age Employee: " + emp.getName() + ", Age: " + emp.getAge()));

        // Calculate min age of employees
        Optional<Employee1> minAgeEmp = employeeList.stream()
                .min(Comparator.comparing(Employee1::getAge));
        minAgeEmp.ifPresent(emp ->
                System.out.println("Min Age Employee: " + emp.getName() + ", Age: " + emp.getAge()));

        // Calculate average age of employees
        double averageAge = employeeList.stream()
                .mapToInt(Employee1::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Average Age of Employees: " + averageAge);

        // Get name starting with 'J'
        List<String> namesStartingWithJ = employeeList.stream()
                .map(Employee1:: getName)
                .filter(name-> name.toLowerCase().startsWith("j"))
                .collect(Collectors.toList());
        System.out.println("Names starting with 'J': " + namesStartingWithJ);

        // Group employees by department
        Map<String, List<Employee1>> empByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee1::getDepartment));
        empByDept.forEach((department, employees) -> {
            System.out.println("Department: " + department);
            employees.forEach(emp ->
                    System.out.println(" - " + emp.getName() + ", Age: " + emp.getAge() + ", Salary: " + emp.getSalary()));
        });
    }
}

class Employee1 {
    private final int id;
    private final String name;
    private int age;
    private String gender;
    private String department;
    private int yearOfJoining;
    private double salary;

    public Employee1(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDepartment() { return department; }
    public int getYearOfJoining() { return yearOfJoining; }
    public double getSalary() { return salary; }
}
