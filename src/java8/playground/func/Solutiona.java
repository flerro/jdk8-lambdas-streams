package java8.playground.func;

import com.sun.corba.se.spi.orb.Operation;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.IntStream;

import static java8.playground.func.FactorialDigitsAdder.Support.factorial;

/**
 * A float comparator
 *
 * Created by francesco.lerro on 09/04/2015.
 */
public class Solutiona {

    final static Long MAX_ALLOWED_VALUE_IN_STACK = new BigInteger("11111111111",2).longValue();

    public static void main(String args[]) {
        int[] a = {1,5,3,3,7};
        solution(a);
//        solution("11++");
    }

    public static boolean solution(int[] A) {
        int totIncreasing = 0;
        int pivot = A[0];
        for (int i = 1; i < (A.length -1) ; i++) {
            int current = A[i];
            if (current > pivot && i < A.length) {
                pivot = current;
                totIncreasing++;
            }
        }


        return totIncreasing == 1 || totIncreasing == (A.length - 1);
    }
//    public static int solution(String S) throws EmptyStackException, OperationOverflowException {
//
//        Stack<Long> queue = new Stack<>();
//
//        long a = 0;
//        long b = 0;
//
//        for (char c : S.toCharArray()) {
//            switch (c) {
//                case '+':
//                    a = queue.pop();
//                    b = queue.pop();
//                    queue.push(guardOverflow(a + b));
//                    break;
//                case '*':
//                    a = queue.pop();
//                    b = queue.pop();
//                    queue.push(guardOverflow(a * b));
//                    break;
//                default: // number
//                    queue.push(Long.parseLong(Character.toString(c)));
//                    break;
//            }
//        }
//        queue.getClass().getName()
//        return (int)queue.pop().longValue();
//
//    }
//
//    private static Long guardOverflow(long l) {
//        if (l >= MAX_ALLOWED_VALUE_IN_STACK) {
//            throw new OperationOverflowException();
//        }
//        return l;
//    }
//
//    private static class OperationOverflowException extends RuntimeException {
//        public OperationOverflowException() {
//            super("Overflow in operation");
//        }
//    }
}
