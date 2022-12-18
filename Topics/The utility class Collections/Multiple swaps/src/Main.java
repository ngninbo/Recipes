import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s")).collect(Collectors.toList());
        Collections.addAll(list);
        int numOfSwaps = Integer.parseInt(scanner.nextLine());

        IntStream.range(0, numOfSwaps)
                .forEach(i -> Collections.swap(list,
                        Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next())));

        list.forEach(s -> System.out.print(s + " "));
    }
}