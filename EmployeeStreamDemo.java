package com.test;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    int age;
    String gender;
    int yoj; 
    double salary;

    public Employee(int id, String name, int age, String gender, int yoj, double salary) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.yoj = yoj;
        this.salary = salary;
    }

    @Override
    public String toString() 
    {
        return "Employee" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Gender='" + gender + '\'' +
                ", Year_of_Joining=" + yoj +
                ", Salary=" + salary 
                ;
    }
}

public class EmployeeStreamDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Arnab", 30, "Female", 2018, 55000),
                new Employee(102, "Somnath", 35, "Male", 2021, 65000),
                new Employee(103, "Payel", 28, "Feale", 2019, 60000),
                new Employee(104, "Balai", 27, "Male", 2022, 50000),
                new Employee(105, "Mousumi", 25, "Female", 2023, 48000)
        );

        
        char specificChar = 'A';
        System.out.println("Employees whose name starts with '" + specificChar + "':");
        employees.stream() .filter(emp -> emp.name.startsWith(String.valueOf(specificChar))).forEach(System.out::println);

      
        System.out.println("\nEmployees who joined after 2020:");
        List<Employee> joinedAfter2020 = employees.stream().filter(emp -> emp.yoj > 2020).collect(Collectors.toList());

        joinedAfter2020.forEach(System.out::println);

        
        List<Employee> sortedJoinedAfter2020 = employees.stream()
                .filter(emp -> emp.yoj > 2020)
                .sorted(Comparator.comparingInt(emp -> emp.yoj))
                .collect(Collectors.toList());

        System.out.println("\nSorted Employees who joined after 2020:");
        sortedJoinedAfter2020.forEach(System.out::println);
    }
}
