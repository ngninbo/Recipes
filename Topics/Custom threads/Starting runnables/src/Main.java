class Starter {

    public static void startRunnables(Runnable[] runnables) {
        // implement the method
        for (Runnable runnable : runnables) {
            Thread tread = new Thread(runnable);
            tread.start();
        }
    }
}