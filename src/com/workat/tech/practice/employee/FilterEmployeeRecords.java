package com.workat.tech.practice.employee;

import java.util.List;
import java.util.stream.Collectors;

public class FilterEmployeeRecords {

    public static void main(String[] args) {
        List<Employees> employeeList = List.of(
                new Employees("Alice", "Female", "IT", 600000),
                new Employees("Bob", "Male", "HR", 500000),
                new Employees("Charlie", "Male", "IT", 700000),
                new Employees("Diana", "Female", "Finance", 800000),
                new Employees("Eve", "Female", "IT", 550000),
                new Employees("Frank", "Male", "IT", 600000)
        );
        filterEmployeRecordBasedOnSalaryDepartmentGender(employeeList);
    }

    private static void filterEmployeRecordBasedOnSalaryDepartmentGender(List<Employees> employeeList) {
        List<Employees> filtered = employeeList.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase("IT"))
                .filter(emp -> emp.getSalary() > 500000)
                .filter(emp -> emp.getGender().equalsIgnoreCase("male") || emp.getGender().equalsIgnoreCase("female"))
                .collect(Collectors.toList());

        System.out.println("Filtered Employees (IT department, salary > 5L):");
        if (filtered.isEmpty()) {
            System.out.println("No matching employees found.");
        } else {
            filtered.forEach(System.out::println);
        }
        /*List<Employees> filteredEmp = employeeList
                .stream()
                .filter(emp ->
                        (emp.getGender().equalsIgnoreCase("male") ||
                         emp.getGender().equalsIgnoreCase("female")) &&
                         emp.getDepartment().equalsIgnoreCase("IT") &&
                         emp.getSalary() > 500000
                )
                .collect(Collectors.toList());
        System.out.println("Filtered Employees (IT, salary > 5L, Male/Female):");
        filteredEmp.forEach(System.out::println);*/
    }


    static class Employees {
        private String name;
        private String gender;
        private String department;
        private double salary;

        public Employees(String name, String gender, String department, double salary) {
            this.name = name;
            this.gender = gender;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employees{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}