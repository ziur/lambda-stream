package done;

import java.io.File;
import java.util.stream.Stream;

/**
 * Created by alejandro^ruiz on 5/21/14.
 */
public class Parallel {


    public static void main(String[] args) throws InterruptedException {

        File home = new File("./out/production/lambda-stream/sample");
        File[] files = home.listFiles();

        Stream.of(files).parallel().forEach(f -> processFile(f));


    }

    private static void processFile(File file) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println(file);
    }
}
