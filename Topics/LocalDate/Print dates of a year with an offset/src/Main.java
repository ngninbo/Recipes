import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        int offset = scanner.nextInt();

        System.out.println(date);
        LocalDate nextDate = date.plusDays(offset);

        while (nextDate.getYear() == date.getYear()) {
            System.out.println(nextDate);
            nextDate = nextDate.plusDays(offset);
        }
    }
}