import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static final int SLEEP_TIMES = 2000;
    private static long mainThreadId = Thread.currentThread().getId();

    // Fix this method
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        SlowStringProcessor processor = new SlowStringProcessor(str);
        processor.start();
        processor.join();

        System.out.println(processor.getNumberOfUniqueCharacters());
    }

    //Don't change the code below
    static class SlowStringProcessor extends Thread {

        private final String s;
        private volatile long numberOfUniqueCharacters = 0;

        public SlowStringProcessor(String s) {
            super();
            this.s = s;
        }

        @Override
        public void run() {

            final long currentId = Thread.currentThread().getId();

            if (currentId == mainThreadId) {
                throw new RuntimeException("You must start a new thread!");
            }

            try {
                Thread.sleep(SLEEP_TIMES);
            } catch (Exception e) {
                throw new RuntimeException("Do not interrupt the processor", e);
            }

            this.numberOfUniqueCharacters = Arrays.stream(s.split("")).distinct().count();
        }

        public long getNumberOfUniqueCharacters() {
            return numberOfUniqueCharacters;
        }
    }
}