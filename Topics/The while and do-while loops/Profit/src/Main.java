import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextInt();
        double percent = scanner.nextInt();
        double kMoney = scanner.nextInt();

        int numYear = 0;

        do {
            if (money == kMoney) {
                break;
            }
            money += money * percent / 100;
            ++numYear;
        } while (money < kMoney);

        System.out.println(numYear);
    }
}