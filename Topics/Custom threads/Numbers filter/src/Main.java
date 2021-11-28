import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);
    boolean isNull = false;

    @Override
    public void run() {
        // implement this method
        while (!isNull) {
            int intVal = scanner.nextInt();
            if (intVal != 0) {
                if (intVal % 2 == 0) {
                    System.out.println(intVal);
                }
            } else {
                isNull = true;
            }
        }
    }
}