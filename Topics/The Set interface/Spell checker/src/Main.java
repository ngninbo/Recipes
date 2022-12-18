import java.util.*;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int d = Integer.parseInt(scanner.nextLine());
        Set<String> dictionary = new HashSet<>();
        Set<String> words = new HashSet<>();

        IntStream.range(0, d).forEach(i -> dictionary.add(scanner.nextLine().toLowerCase()));

        int l = Integer.parseInt(scanner.nextLine());

        IntStream.range(0, l)
                .forEach(i -> words.addAll(List.of(scanner.nextLine().toLowerCase().split("\\s+"))));

        words.stream()
                .filter(s -> !dictionary.contains(s))
                .forEach(System.out::println);
    }
}