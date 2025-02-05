import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

public class StreamEmployeeEx{
    public static void main(String[] args) {
    
        List<Employee> employees = Arrays.asList(
            new Employee("Arun", 29, 60000),
            new Employee("Venkat", 35, 70000),
            new Employee("Viswa", 40, 80000),
            new Employee("Kumar", 25, 45000),
            new Employee("Prasad", 30, 75000)
        );

        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getAge() > 30)
                .collect(Collectors.toList());

        List<String> names = filteredEmployees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        double averageSalary = filteredEmployees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("Employees older than 30: " + names);
        System.out.println("Average salary: " + averageSalary);
    }
}
