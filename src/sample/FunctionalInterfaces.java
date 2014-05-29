package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by alejandro^ruiz on 5/21/14.
 */
public class FunctionalInterfaces {
    @FunctionalInterface
    interface Formatter {
        void format(String name);
    }
    public static void main(String[] args) throws InterruptedException {
        List<String> names = Arrays.asList(new String[]{"Juan", "Pedro", "Carlos"});
        for (String name : names) {
            System.out.println("Name:" + name);
        }

    }
}
