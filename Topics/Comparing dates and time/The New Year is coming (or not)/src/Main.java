import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.next());
        int numOfDays = Integer.parseInt(scanner.next());

        System.out.println(date.until(LocalDate.ofYearDay(date.plusYears(1).getYear(), 1),
                ChronoUnit.DAYS) == numOfDays);
    }
}