import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input
    boolean containLetterInLowercase = true;

    @Override
    public void run() {
        // implement this method
        while (containLetterInLowercase) {
            String input = scanner.nextLine();
            if (!input.equals(input.toUpperCase())) {
                System.out.println(input.toUpperCase());
            } else {
                containLetterInLowercase = false;
                System.out.println("FINISHED");
            }
        }
    }
}