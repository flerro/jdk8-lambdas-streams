package java8.playground.func;

import static java8.playground.func.FactorialDigitsAdder.Support.factorial;

/**
 * A float comparator
 *
 * Created by francesco.lerro on 09/04/2015.
 */
public class FactorialDigitsAdder {

    static class Support {
        public static Long factorial(Integer n) {
            return factorialAcc(n, 1l);
        }

        private static Long factorialAcc(Integer n, Long acc){
            if (acc < 0) throw new RuntimeException("Number overflow!");
            if(n == 0) return acc;
            else return factorialAcc(n - 1, n * acc);
        }

    }

    public FactorialDigitsAdder() {

        int input = 14;

        int sumOfDigits = factorial(input).toString().chars()
                            .map(c -> Integer.parseInt(Character.toString((char) c)))
                            .reduce(0, (i, j) -> i + j);

        System.out.println(" SUM " + input + "! >> " + sumOfDigits);
    }


    public static void main(String args[]) {
        new FactorialDigitsAdder();
    }
}
