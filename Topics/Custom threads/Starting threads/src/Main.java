public class Main {

    public static void main(String[] args) {

        // create threads and start them using the class RunnableWorker
        RunnableWorker worker1 = new RunnableWorker();
        RunnableWorker worker2 = new RunnableWorker();
        RunnableWorker worker3 = new RunnableWorker();

        Thread thread1 = new Thread(worker1, "worker-JetBrian");
        Thread thread2 = new Thread(worker2, "worker-HyperSkill");
        Thread thread3 = new Thread(worker3, "worker-isFun");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

// Don't change the code below       
class RunnableWorker implements Runnable {

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (name.startsWith("worker-")) {
            System.out.println("too hard calculations...");
        } else {
            return;
        }
    }
}