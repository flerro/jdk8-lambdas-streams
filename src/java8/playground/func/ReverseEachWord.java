package java8.playground.func;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A float comparator
 *
 * Created by francesco.lerro on 09/04/2015.
 */
public class ReverseEachWord {

    public ReverseEachWord() {

        String input = "I am very happy to see you here";

        String allWordsReversed = Arrays.stream(input.split(" "))
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));

        System.out.print(input);
        System.out.print(" -> ");
        System.out.println(allWordsReversed);
    }

    public static void main(String args[]) {
        new ReverseEachWord();
    }
}
