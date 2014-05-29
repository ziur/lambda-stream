package sample;

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

    interface Criteria {
        boolean test(Employee employee);
        default void doIt() {
            System.out.println("i am default");
        }



    }


        public static void main(String[] args) throws InterruptedException {
        System.out.println(findBySalary(employees, e -> e.getSalary() > 1000));
    }


    private static Employee findBySalary(List<Employee> employees, Criteria predicate) {
        for (Employee employee : employees) {
            predicate.doIt();
            if (predicate.test(employee)) {
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
