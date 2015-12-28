package java8.playground.func.snippets;

import java.util.Comparator;

/**
 * A float comparator
 *
 * Created by francesco.lerro on 09/04/2015.
 */
public class FloatComparator {

    public FloatComparator() {

        Comparator<Float> cmp = (x, y) -> (x < y) ? -1 : ((x > y) ? 1 : 0);

        final float ten = 10;
        final float twenty = 20;
        boolean tenGreaterThanTwenty = cmp.compare(ten, twenty) == 1;

        System.out.println("Comparator: " + ten + " > " + twenty + " ? " + tenGreaterThanTwenty);
    }

    public static void main(String args[]) {
        new FloatComparator();
    }
}
