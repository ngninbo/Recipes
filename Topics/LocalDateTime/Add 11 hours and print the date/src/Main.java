import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long hours = 11;
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(dateTime.plusHours(hours).toLocalDate());
    }
}