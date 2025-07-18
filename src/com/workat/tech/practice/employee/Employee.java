package com.workat.tech.practice.employee;

import java.util.Objects;

public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same instance
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Null or different class
        }
        Employee other = (Employee) obj;
        return Double.compare(other.salary, salary) == 0 && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary); // Ensure consistency with equals
    }
}
