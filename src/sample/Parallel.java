package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by alejandro^ruiz on 5/21/14.
 */
public class Parallel {


    public static void main(String[] args) throws InterruptedException {

        File home = new File("./out/production/lambda-stream/sample");
        File[] files = home.listFiles();
       /*for (File file : files) {
            processFile(file);
        }
         */
        Stream.of(files).parallel().forEach(Parallel::processFile);
    }

    private static void processFile(File file) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println(file);
    }
}
