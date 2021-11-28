import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        Collections.addAll(list, scanner.nextLine().split("\\s"));
        int numOfSwaps = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfSwaps; i++) {
            Collections.swap(list, Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
        }

        list.forEach(s -> System.out.print(s + " "));
    }
}