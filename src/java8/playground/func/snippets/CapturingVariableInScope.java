package java8.playground.func.snippets;

import java.util.Comparator;

/**
 * A lambda expression capturing variables defined in scope
 *
 */

public class CapturingVariableInScope {

    public CapturingVariableInScope() {

        final int lesser = -1;
        final int greater = 1;
        final int equal = 0;
        Comparator<Integer> integerComparator = (x, y) -> (x < y) ? lesser : ((x > y) ? greater : equal);

        final int five = 5;
        final int three = 3;
        boolean threeLessThanFive = integerComparator.compare(three, five) == lesser;

        System.out.println("Comparator (capture): " + three + " < " + five + " ? " + threeLessThanFive);
    }

    public static void main(String args[]) {
        new CapturingVariableInScope();
    }
}
