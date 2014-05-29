package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alejandro^ruiz on 5/21/14.
 */
public class Start {
    public static void main(String[] args) throws InterruptedException {
        JButton button = new JButton();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked!!!");
            }
        });


        button.addActionListener(e -> System.out.println("clicked with lambda"));
        button.doClick();

        Thread t = new Thread(() -> System.out.println("a thread!!!"));
        t.start();
    }
}
