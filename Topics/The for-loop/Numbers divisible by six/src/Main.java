import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int sumNumberDivisibleBySix = 0;

        Scanner scanner = new Scanner(System.in);

        int numElement = scanner.nextInt();

        // int[] sequence = new int[numElement];

        for (int i = 0; i < numElement; i++) {
            // sequence[i] = scanner.nextInt();
            int nextInt = scanner.nextInt();

            if (nextInt % 6 == 0) {
                sumNumberDivisibleBySix += nextInt;
            }
        }
        System.out.println(sumNumberDivisibleBySix);
    }
}