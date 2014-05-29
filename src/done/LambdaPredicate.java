package done;

import sample.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by alejandro^ruiz on 5/21/14.
 */
public class LambdaPredicate {

    public static List<Employee> employees = Arrays.asList(
            new Employee(20, "Juan Perez", 1000),
            new Employee(1, "Maria Perez", 1500),
            new Employee(100, "Luis Gomez", 500),
            new Employee(200, "Ana Campos", 600)
    );

    public static void main(String[] args) throws InterruptedException {
        System.out.println(findBySalary(employees, 1000));
        System.out.println(findByName(employees, "Campos"));
        System.out.println("-----------------");
        System.out.println(findByCriteria(employees, employee -> employee.getSalary() >= 1000));
        System.out.println(findByCriteria(employees, employee -> employee.getName().contains("Campos")));

    }

    private static Employee findByCriteria(List<Employee> employees, Predicate<Employee> predicate) {
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                return employee;
            }
        }
        return null;
    }

    private static Employee findBySalary(List<Employee> employees, int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                return employee;
            }
        }
        return null;
    }

    private static Employee findByName(List<Employee> employees, String name) {
        for (Employee employee : employees) {
            if (employee.getName().contains(name)) {
                return employee;
            }
        }
        return null;
    }
}
