package main.java;


import java.util.*;
import java.util.stream.Collectors;

class Employee1 {
    int id;
    String name;
    String department;
    double salary;

    public Employee1(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}

public class HighestPainSalaryOfAnEmployeeBasedOnEachDepartment {

    public static void main(String[] args) {

        List<Employee1> employees = Arrays.asList(
                new Employee1(1, "John", "IT", 60000),
                new Employee1(2, "Alice", "HR", 50000),
                new Employee1(3, "Bob", "IT", 80000),
                new Employee1(4, "David", "HR", 75000),
                new Employee1(5, "Mike", "Finance", 90000)
        );

        Map<String, Optional<Employee1>> highestPaidByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee1::getDepartment,
                                Collectors.maxBy(Comparator.comparingDouble(Employee1::getSalary))
                        ));

        highestPaidByDept.forEach((dept, emp) -> {
            System.out.println(dept + " -> " + emp.get().getName() + " : " + emp.get().getSalary());
        });
    }
}