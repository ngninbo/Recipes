class Main {

    public static void main(String []args) {
        System.out.println("Hello Main");

        HelloThread2 t2 = new HelloThread2();
        t2.start();

        HelloThread1 t1 = new HelloThread1();
        t1.start();
    }
}

class HelloThread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from Thread-1");
        HelloThread2 t = new HelloThread2();
        t.start();
    }
}

class HelloThread2 extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from Thread-2");
    }
}
