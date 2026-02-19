package main.java.Thread;

public class VolatileExample {

    private static volatile boolean flag = true;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("Thread-1 waiting for flag to turn false...");
            while (flag) {
                // busy wait
            }
            System.out.println("Thread-1 detected flag = false, exiting");
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("Thread-2 sleeping for 2 seconds...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            flag = false; // change visible to t1 immediately
            System.out.println("Thread-2 set flag = false");
        });

        t2.start();
    }
}
