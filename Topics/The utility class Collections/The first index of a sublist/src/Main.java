import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> list = List.of(scanner.nextLine().split("\\s+"));
        List<String> sublist = List.of(scanner.nextLine().split("\\s+"));
        System.out.printf("%s %s\n",
                Collections.indexOfSubList(list, sublist),
                Collections.lastIndexOfSubList(list, sublist));

    }
}