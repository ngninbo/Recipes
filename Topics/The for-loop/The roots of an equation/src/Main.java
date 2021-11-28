import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int numRoots = 0;
        int maxRoots = 3;
        int n = 1000;

        for (int i = 0; i <= n; i++) {

            int y = a * i * i * i + b * i * i + c * i + d;

            if (y == 0 && numRoots < maxRoots) {
                System.out.println(i);
                numRoots += 1;
            }
        }
    }
}