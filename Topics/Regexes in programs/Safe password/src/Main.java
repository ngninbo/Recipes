import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        System.out.println(isSafePassword(password) ? "YES" : "NO");
    }

    private static boolean isSafePassword(String password) {

        return password.matches(".{12,}") && password.matches(".*[A-Z]+.*") &&
                password.matches(".*[a-z]+.*") && password.matches(".*\\d+.*");
    }
}