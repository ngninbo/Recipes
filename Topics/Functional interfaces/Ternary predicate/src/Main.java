
class Predicate {
    public static final TernaryIntPredicate ALL_DIFFERENT = (a, b, c) -> a != b && b != c & a != c;

    @FunctionalInterface
    public interface TernaryIntPredicate {
        // Write a method here
        boolean test(int a, int b, int c);
    }
}