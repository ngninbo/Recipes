import java.util.List;
import java.util.Stack;
import java.util.Vector;

class ClassCountingInstances {

    private static long numberOfInstances;

    public ClassCountingInstances() {
        // write the increment here
        synchronized (ClassCountingInstances.class) {
            numberOfInstances += 1L;
        }
    }

    public static synchronized long getNumberOfInstances() {
        return numberOfInstances;
    }
}

class ChooseCollection {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = createSynchronizedList();
        Thread thread1 = new Thread(() -> addNumbers(numbers));
        Thread thread2 = new Thread(() -> addNumbers(numbers));

        thread1.start();
        thread2.start();
        addNumbers(numbers);

        thread1.join();
        thread2.join();

        System.out.println(numbers.size()); // 300_000
    }

    private static void addNumbers(List<Integer> numbers) {
        for (int i = 0; i < 100_000; ++i) {
            numbers.add(i);
        }
    }

    // choose the collection
    private static List<Integer> createSynchronizedList() {
        return new Stack<>();
    }
}