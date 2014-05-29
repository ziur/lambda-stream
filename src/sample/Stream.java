package sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by alejandro^ruiz on 5/21/14.
 */
public class Stream {

    public static List<Employee> employees = Arrays.asList(
            new Employee(20, "Juan Juarez", 1000),
            new Employee(20, "Juan Perez", 1000),
            new Employee(1, "Maria Perez", 1500),
            new Employee(100, "Luis Gomez", 500),
            new Employee(200, "Ana Campos", 600)
    );

    public static void main(String[] args) throws InterruptedException {

        Predicate<Employee> goodSalary = employee -> employee.getSalary() >= 1000;
        Predicate<Employee> perezFamily = employee -> employee.getName().contains("Perez");

        System.out.println(findByCriteria(employees, Arrays.asList(goodSalary, perezFamily)));
    }

    private static Employee findByCriteria(List<Employee> employees, List<Predicate<Employee>> predicates) {
        for (Employee employee : employees) {
            boolean isValid = true;
            for (Predicate<Employee> predicate : predicates) {
                isValid = isValid && predicate.test(employee);
            }
            if (isValid) {
                return employee;
            }

        }
        return null;
    }

}
