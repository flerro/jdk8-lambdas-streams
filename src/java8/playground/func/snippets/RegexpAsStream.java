package java8.playground.func.snippets;

import java.util.regex.Pattern;

/**
 * Regexp to stream
 *
 */

public class RegexpAsStream {

    public RegexpAsStream() {

        String str = "Ken,Jeff,Lee";
        Pattern.compile(",")
                .splitAsStream(str)
                .forEach(System.out::println);

    }

    public static void main(String args[]) {
        new RegexpAsStream();
    }
}
