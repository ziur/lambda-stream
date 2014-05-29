package done;

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
public class Start {
    public static void main(String[] args) throws InterruptedException {

        JButton button = new JButton();
        button.addActionListener(e -> System.out.println("Button clicked"));
        button.doClick();

        List<Integer> numbers = Arrays.asList(4, 3, 1, 2);
        Collections.sort(numbers, (o1, o2) -> o2 - o1);
        System.out.println(numbers);

        Thread thread = new Thread(() -> System.out.println("THREAD: Do something"));
        thread.start();
        thread.join();

    }
}
