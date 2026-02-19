package main.java.Thread;

class SynchronizedBlockExample {

    private int counter = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized (lock) { // only this block is locked
            counter++;
            System.out.println(Thread.currentThread().getName() + " Counter: " + counter);
        }
    }
}
public class SynchronizedExample {

    private int counter = 0;

    public synchronized void increment() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " Counter: " + counter);
    }

    public static void main(String[] args) {

        SynchronizedExample example = new SynchronizedExample();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                example.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

