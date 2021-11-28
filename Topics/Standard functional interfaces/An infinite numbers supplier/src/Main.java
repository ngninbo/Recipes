import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        // write your code here
        return new Supplier<>() {
            int i = -1;

            @Override
            public Integer get() {
                i += 1;
                return i;
            }
        };
    }
}