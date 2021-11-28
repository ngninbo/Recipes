import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime beginYear = LocalDateTime.of(LocalDate.ofYearDay(dateTime.getYear(), 1),
                LocalTime.of(0, 0));
        System.out.println(beginYear.until(dateTime, ChronoUnit.HOURS));

        LocalDateTime dt = LocalDateTime.parse("2017-11-30T20:30");
        System.out.println(dt.isAfter(LocalDateTime.parse("2017-11-30T20:30")));
        System.out.println(dt.isAfter(LocalDateTime.parse("2017-11-30T20:20")));
        System.out.println(dt.isBefore(LocalDateTime.parse("2017-11-30T21:20")));
        System.out.println(dt.isEqual(LocalDateTime.parse("2017-11-30T20:20")));
    }
}