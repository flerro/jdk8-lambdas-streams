package java8.playground.func.snippets;

import java.util.Random;

/**
 * Working with a stream of random integers
 *
 */

public class GenerateRandomIntegers {

    public GenerateRandomIntegers() {
        System.out.println("Print some random integers");

        new Random()
                .ints()                         // generate the stream
                .limit(5)                       // limit the stream
                .forEach(System.out::println);  // print the ints
    }

    public static void main(String args[]) {
        new GenerateRandomIntegers();
    }
}
