import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine(); // a valid or invalid registration number
        String regex = "[ABEKMHOPCTYX][\\d]{3}[ABEKMHOPCTYX]{2}";
        /* write your code here */
        System.out.println(regNum.matches(regex));
    }
}