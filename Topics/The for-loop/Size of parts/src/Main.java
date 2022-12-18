import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfParts = Integer.parseInt(scanner.nextLine());

        List<Integer> sequenceOfIntegers =  IntStream.range(0, numOfParts)
                .map( i -> Integer.parseInt(scanner.nextLine()))
                .boxed()
                .collect(Collectors.toList());

        long shipped = sequenceOfIntegers.stream().filter(integer -> integer == 0).count();
        long fixed = sequenceOfIntegers.stream().filter(integer -> integer == 1).count();
        long rejected = sequenceOfIntegers.stream().filter(integer -> integer == -1).count();

        System.out.printf("%s %s %s\n", shipped, fixed, rejected);
    }
}