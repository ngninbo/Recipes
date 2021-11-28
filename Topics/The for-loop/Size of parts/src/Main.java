import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        // put your code here
        int shippable = 0;
        int fixable = 0;
        int rejected = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int sequence = scanner.nextInt();
            if (sequence == 0) {
                shippable++;
            } else if (sequence == 1) {
                fixable++;
            } else {
                rejected++;
            }
        }

        System.out.print(shippable + " ");
        System.out.print(fixable + " ");
        System.out.println(rejected);

    }
}