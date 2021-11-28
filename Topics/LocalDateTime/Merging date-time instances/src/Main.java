import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime merge(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        // write your code here
        int maxYear = Math.max(dateTime1.getYear(), dateTime2.getYear());
        int maxMonth = Math.max(dateTime1.getMonthValue(), dateTime2.getMonthValue());
        int maxDay = Math.max(dateTime1.getDayOfMonth(), dateTime2.getDayOfMonth());
        int maxHour = Math.max(dateTime1.getHour(), dateTime2.getHour());
        int maxMin = Math.max(dateTime1.getMinute(), dateTime2.getMinute());
        int maxSecond = Math.max(dateTime1.getSecond(), dateTime2.getSecond());
        int maxNano = Math.max(dateTime1.getNano(), dateTime2.getNano());

        return LocalDateTime.of(maxYear, maxMonth, maxDay, maxHour, maxMin, maxSecond, maxNano);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(merge(firstDateTime, secondDateTime));
    }
}