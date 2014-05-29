package done;

import java.util.Arrays;
import java.util.List;

/**
 * Created by alejandro^ruiz on 5/21/14.
 */
public class FunctionalInterfaces {
    interface Formatter {
        void format(String name);
        default String toUpperCase(String name) {
            return name.toUpperCase();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        List<String> names = Arrays.asList(new String[]{"Juan", "Pedro", "Carlos"});
        names.forEach(name -> processName(name));
        System.out.println("--------------");
        names.forEach(FunctionalInterfaces::processName);
        Formatter formatter = n -> System.out.println("<" + n + ">");
        names.forEach(n -> formatter.format(n));
        names.forEach(n -> formatter.format(formatter.toUpperCase(n)));

    }

    private static void processName(String name) {
        System.out.println("Name:" + name);
    }
}
