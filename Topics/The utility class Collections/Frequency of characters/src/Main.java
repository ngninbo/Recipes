import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> sequence = List.of(scanner.nextLine().split("\\s+"));
        String character = scanner.nextLine();
        System.out.println(Collections.frequency(sequence, character));
    }
}