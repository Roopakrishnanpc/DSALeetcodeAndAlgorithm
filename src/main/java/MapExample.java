package main.java;

import java.util.*;

class Employee {
    private String name;
    private double salary;

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Override equals() and hashCode() for identity comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0 && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + '}';
    }
}

public class MapExample {
    public static void main(String[] args) {
        // Create a map to store employee objects with an ID
        Map<Integer, Employee> employeeMap = new HashMap<>();

        // Create Employee objects
        Employee e1 = new Employee("Alice", 50000);
        Employee e2 = new Employee("Bob", 60000);
        Employee e3 = new Employee("Alice", 50000); // Same name and salary as e1 (but different object)

        // Add employees to the map using their ID as key
        employeeMap.put(1, e1);
        employeeMap.put(2, e2);
        employeeMap.put(3, e3); // Adding e3, which has the same name and salary as e1 but is a different object

        // Print map to see what happens
        System.out.println("Employee Map: " + employeeMap);

        // Accessing keySet(), entrySet(), values() to check
        System.out.println("\nKey Set (IDs): " + employeeMap.keySet());
        System.out.println("\nEntry Set (ID and Employee): ");
        for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        System.out.println("\nValues (Employees): " + employeeMap.values());
    }
}