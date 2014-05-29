package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by alejandro^ruiz on 5/21/14.
 */
public class LambdaConsumer {

    public static List<Employee> employees = Arrays.asList(
            new Employee(20, "Juan Perez", 1000),
            new Employee(1, "Maria Perez", 1500),
            new Employee(100, "Luis Gomez", 500),
            new Employee(200, "Ana Campos", 600)
    );

    public static void main(String[] args) throws InterruptedException {
        Predicate<Employee> perezFamily =  employee -> employee.getName().contains("Perez");
        Predicate<Employee> elderOne =  employee -> employee.getId()== 1;

           List<Predicate<Employee>> criteria = new ArrayList<>();
        criteria.add(perezFamily);
        criteria.add(elderOne);
        Consumer<Employee> action = employee -> employee.setSalary(employee.getSalary() + 2000) ;

        raiseSalary(employees, perezFamily.or(elderOne), action);

        /*
        raiseSalaryToElders(employees, 800);
        raiseSalaryToCommoners(employees, 300);
        */
        System.out.println(employees);
    }



    private static void raiseSalary(List<Employee> employees, Predicate<Employee> criteria, Consumer<Employee> action) {
        employees.stream()
                .filter(criteria)
                .forEach(employee -> action.accept(employee));
        /*
        for (Employee employee : employees) {
            boolean isValid = true;
            for (Predicate<Employee> employeePredicate : criteria) {
                isValid =  isValid && employeePredicate.test(employee);

            }
            if (isValid) {
                action.accept(employee);
            }

        }
        */
    }

     /*
    private static void raiseSalaryToElders(List<Employee> employees, int amount) {
        raiseSalary(employees, employee -> employee.getId() <= 20,
                employee -> employee.setSalary(employee.getSalary() + amount) );
    }

    private static void raiseSalaryToCommoners(List<Employee> employees, int amount) {
        for (Employee employee : employees) {
            if (employee.getId() > 20) {
                employee.setSalary(employee.getSalary() + amount);
            }
        }
    }  */
}
