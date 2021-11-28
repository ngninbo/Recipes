import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate startDate = LocalDate.of(year, month, 1);
        int numDay = startDate.lengthOfMonth();
        LocalDate endDate = startDate.withDayOfMonth(numDay);

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            if ("Monday".equalsIgnoreCase(date.getDayOfWeek().toString())) {
                System.out.println(date);
            }
        }

        int time = LocalTime.of(0, 0, 2).plusSeconds(6078).getSecond();
        System.out.println(time);
    }
}