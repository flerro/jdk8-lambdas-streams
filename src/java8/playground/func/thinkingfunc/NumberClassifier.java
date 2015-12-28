package java8.playground.func.thinkingfunc;

import java.util.stream.IntStream;

/**
 * A natural number classifier according to Nicomachus theory
 *  Perfect:    Sum of factors = number
 *  Abundant:   Sum of factors > number
 *  Deficient:  Sum of factors < number
 *
 */

public class NumberClassifier {

    /**
     * Find factors of a given number
     *
     * @param number input number
     * @return all number factors
     */
    public static IntStream allFactors(int number) {
        return IntStream.range(1, number + 1).filter( i -> number % i == 0);
    }

    public static int aliquotSum(int number) {
        return allFactors(number).sum() - number;
    }

    public static String classify(int number) {
        if (aliquotSum(number) > number) {
            return "Abundant";
        } else if (aliquotSum(number) < number) {
            return "Deficient";
        } else {
            return "Perfect";
        }
    }

    public static void main(String args[]) {
        System.out.println(" 28 ? " + classify(28));
        System.out.println(" 3 ? " + classify(3));
        System.out.println(" 6 ? " + classify(6));
        System.out.println(" 42 ? " + classify(42));
    }
}
