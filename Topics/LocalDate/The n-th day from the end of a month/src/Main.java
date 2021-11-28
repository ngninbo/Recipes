import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int remainingDays = scanner.nextInt();

        LocalDate date = LocalDate.of(year, month, 1);
        int lengthOfMonth = date.lengthOfMonth();
        System.out.println(date.plusDays(lengthOfMonth - remainingDays));
    }
}