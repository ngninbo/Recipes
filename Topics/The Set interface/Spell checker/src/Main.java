import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Set<String> record = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);
        int d = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < d; i++) {
            String word = scanner.nextLine();
            record.add(word.toLowerCase());
        }

        int l = Integer.parseInt(scanner.nextLine());

        Set<String> erroneous = new HashSet<>();

        for (int j = 0; j < l; j++) {
            String[] word = scanner.nextLine().split(" ");
            for (String s : word) {
                if (!record.contains(s.toLowerCase())) {
                    erroneous.add(s);
                }
            }
        }

        erroneous.forEach(System.out::println);
    }
}