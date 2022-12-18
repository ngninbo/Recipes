import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tableDims = scanner.nextLine().split("\\s");
        int row = Integer.parseInt(tableDims[0]);

        List<String> list = IntStream.range(0, row)
                .mapToObj(i -> scanner.nextLine())
                .collect(Collectors.toList());

        int distance = scanner.nextInt();

        Collections.rotate(list, distance);

        IntStream.range(0, row)
                .mapToObj(list::get)
                .forEach(System.out::println);

    }
}