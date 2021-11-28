import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.next());
        int plusDays = scanner.nextInt();
        int minusHours = scanner.nextInt();

        System.out.println(dateTime.plusDays(plusDays).minusHours(minusHours));
    }
}