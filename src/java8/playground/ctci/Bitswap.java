package java8.playground.ctci;

/**
 * Created by francesco.lerro on 10/11/2015.
 */
public class Bitswap {

    private static String b(int a) {
        return Integer.toBinaryString(a);
    }

    /**
     * Write a function to determine the number of bits
     * required to convert integer A to integer B.
     */
    public static int bitSwapReuired(int a, int b){
        System.out.println("a: " + b(a) + ", b: " + b(b));
        int count = 0;
        for (int c = a ^ b; c != 0; c = (c >> 1)) {
            System.out.println("c: " + b(c) + " count: " + count );
            count = count + (c & 1);
        }

        return count;
    }

    public static int swapOddEvenBits(int x) {
        System.out.println("x: " + b(x));
        return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) );
    }

    public static void main(String args[]) {
        System.out.println("Bit swap required 10 -> 15 : " + bitSwapReuired(10, 15));

        System.out.println("Swap Bit: " + b(swapOddEvenBits(125)));
    }
}
