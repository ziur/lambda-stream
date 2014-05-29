package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by alejandro^ruiz on 5/21/14.
 */
public class General {
    public static void main(String[] args) throws InterruptedException {
        // Cannot modify a variable declared in the outer scope
        List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
        int factor = 2;
        primes.forEach(element -> { System.out.println(factor * element); });


        //Method Reference
        primes.forEach(n -> System.out.println(n));
        primes.forEach(System.out::println);  // using method reference

        // Lambda is translated to invokedynamic byte code instruction




    }
}
