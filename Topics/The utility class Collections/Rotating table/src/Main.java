import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] tableDims = scanner.nextLine().split("\\s");
        int row = Integer.parseInt(tableDims[0]);

        List<String> list = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            list.add(scanner.nextLine());
        }

        int distance = scanner.nextInt();

        Collections.rotate(list, distance);
        for (int i = 0; i < row; i++) {
            System.out.println(list.get(i));
        }
    }
}