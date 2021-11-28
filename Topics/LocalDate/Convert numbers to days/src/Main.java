import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        List<Integer> days = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            days.add(scanner.nextInt());
        }

        days.forEach(day -> System.out.println(LocalDate.ofYearDay(year, day)));
    }
}