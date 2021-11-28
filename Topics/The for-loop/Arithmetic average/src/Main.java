import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int lower = scanner.nextInt();
        int upper = scanner.nextInt();
        int count = 0;
        int sum = 0;

        for (int i = lower; i <= upper; i++) {
            if (i % 3 == 0) {
                sum += i;
                count += 1;
            }
        }
        double avg = (double) sum / count;

        System.out.println(avg);
    }
}