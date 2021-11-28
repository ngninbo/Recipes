import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int numOfDates = Integer.parseInt(scanner.nextLine());
        LocalDateTime[] dateTimes = new LocalDateTime[numOfDates];

        for (int i = 0; i < numOfDates; i++) {
            dateTimes[i] = LocalDateTime.parse(scanner.nextLine());
        }

        LocalDateTime lastDateTime = dateTimes[0];
        for (LocalDateTime dateTime : dateTimes) {
            if (dateTime.compareTo(lastDateTime) > 0) {
                lastDateTime = dateTime;
            }
        }

        System.out.println(lastDateTime);
    }
}