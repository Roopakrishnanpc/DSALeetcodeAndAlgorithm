package main.java.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private int counter = 0;
    private Lock lock = new ReentrantLock();
    Lock fairLock = new ReentrantLock(true); // true = fair lock
//    Threads acquire lock in order of request
//    Avoids starvation
    public void increment() {
        lock.lock();  // acquire lock
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " Counter: " + counter);
        } finally {
            lock.unlock(); // always release lock
        }
        //another way to do is below
        if (lock.tryLock()) {
            try {
                // do critical work
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Could not acquire lock, skip task");
        }

    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

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
