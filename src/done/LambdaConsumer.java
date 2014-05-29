package done;

import sample.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
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
        raiseSalary(employees, e -> e.getId() <= 20, e -> e.setSalary(e.getSalary() + 800));
        raiseSalary(employees, e -> e.getId() > 20, e -> e.setSalary(e.getSalary() + 300));
        System.out.println(employees);
        raiseSalary(employees, e -> e.getName().contains("Perez"), e -> e.setSalary(e.getSalary() + 800));
        System.out.println("----------------");
        raiseSalaryWithStream(employees, e -> e.getName().contains("Perez"), e -> {e.setSalary(e.getSalary() + 800); return e;});
        System.out.println("--------------");
        System.out.println(employees);
    }


    private static void raiseSalary(List<Employee> employees, Predicate<Employee> ageCriteria, Consumer<Employee> raiseLogic) {
        for (Employee employee : employees) {
                if (ageCriteria.test(employee)) {
                    raiseLogic.accept(employee);
                }
        }
    }

    private static void raiseSalaryWithStream(List<Employee> employees, Predicate<Employee> ageCriteria, Function<Employee, Employee> raiseLogic) {
        employees.stream().filter(ageCriteria).map(raiseLogic).forEach(System.out::println);
    }

}
