import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int startTime = LocalTime.parse(scanner.nextLine()).toSecondOfDay();
        int endTime = LocalTime.parse(scanner.nextLine()).toSecondOfDay();
        System.out.println(Math.abs(endTime - startTime));
    }
}