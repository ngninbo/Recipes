import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        // write your code here
        Set<Integer> set = new LinkedHashSet<>();
        for (String s : str.split(" ")) {
            set.add(Integer.parseInt(s));
        }
        return set;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        // write your code here
        set.removeIf(value -> value > 10);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}