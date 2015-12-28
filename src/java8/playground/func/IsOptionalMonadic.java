package java8.playground.func;

/**
 * ```
 * Does JDK8's Optional class satisfy the Monad laws?
 * =================================================
 *   1.  Left identity:  true
 *   2.  Right identity: true
 *   3.  Associativity:  true
 *
 * Yes, it does.
 * ```
 *
 * For more info on the monad laws, see:
 *   [1] http://learnyouahaskell.com/a-fistful-of-monads#monad-laws
 *   [2] http://eed3si9n.com/learning-scalaz/Monad+laws.html
 *   [3] http://en.wikipedia.org/wiki/Monad_(functional_programming)#Monad_laws
 *
 * Adapted from Marc Siegel's version based on the Java 8 Early Access
 *  builds which still did not include lambdas
 *
 * @author Marc Siegel <marc.siegel@timgroup.com>
 * @author Francesco Lerro
 */
import java.util.function.Function;
import java.util.Optional;

class IsOptionalMonadic {

    public static void main (String[] args) throws java.lang.Exception {
        System.out.println("");
        System.out.println("Does JDK8's Optional class satisfy the Monad laws?");
        System.out.println("=================================================");
        System.out.println("  1.  Left identity:  " + satisfiesLaw1LeftIdentity());
        System.out.println("  2.  Right identity: " + satisfiesLaw2RightIdentity());
        System.out.println("  3.  Associativity:  " + satisfiesLaw3Associativity());
        System.out.println("");
        System.out.println(satisfiesLaw1LeftIdentity()
                && satisfiesLaw2RightIdentity()
                && satisfiesLaw3Associativity()
                ? "Yes, it does."
                : "No, it doesn't.");
    }

    // Input values for the monad law tests below
    static int value = 42;
    static Optional<Integer> monadicValue = Optional.of(value);

    static Function<Integer, Optional<Integer>> f = n -> Optional.of(n * 2);
    static Function<Integer, Optional<Integer>> g = n -> Optional.of(n * 5);
    static Function<Integer, Optional<Integer>> f_flatMap_g =  n -> f.apply(n).flatMap(g);

    /**
     * Monad law 1, Left Identity
     *
     * From LYAHFGG [1] above:
     *   The first monad law states that if we take a value, put it in a default context
     *   with return and then feed it to a function by using >>=, it’s the same as just
     *   taking the value and applying the function to it
     */
    public static boolean satisfiesLaw1LeftIdentity() {
        return monadicValue.flatMap(f)
                .equals(f.apply(value));
    }

    /**
     * Monad law 2, Right Identity
     *
     * From LYAHFGG [1] above:
     *   The second law states that if we have a monadic value and we use >>= to feed
     *   it to return, the result is our original monadic value.
     */
    public static boolean satisfiesLaw2RightIdentity() {
        return monadicValue.flatMap(Optional::of)
                .equals(monadicValue);
    }

    /**
     * Monad law 3, Associativity
     *
     * From LYAHFGG [1] above:
     *   The final monad law says that when we have a chain of monadic function
     *   applications with >>=, it shouldn’t matter how they’re nested.
     */
    public static boolean satisfiesLaw3Associativity() {
        return monadicValue.flatMap(f).flatMap(g)
                .equals(monadicValue.flatMap(f_flatMap_g));
    }
}
