import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime startDateTime;
        LocalDateTime endDateTime;

        LocalDateTime lowerDate = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime upperDate = LocalDateTime.parse(scanner.nextLine());

        startDateTime = lowerDate.compareTo(upperDate) < 0 ? lowerDate : upperDate;
        endDateTime = upperDate.compareTo(lowerDate) > 0 ? upperDate : lowerDate;

        int numDateTime = Integer.parseInt(scanner.nextLine());
        int numDateTimeInRange = 0;

        int i = 0;
        while (i < numDateTime) {
            LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
            if (dateTime.compareTo(startDateTime) >= 0 && dateTime.isBefore(endDateTime)) {
                numDateTimeInRange++;
            }
            i++;
        }

        System.out.println(numDateTimeInRange);
    }
}