import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime firstDate = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime secondDate = LocalDateTime.parse(scanner.nextLine());

        System.out.println(firstDate.until(secondDate, ChronoUnit.HOURS));
    }
}