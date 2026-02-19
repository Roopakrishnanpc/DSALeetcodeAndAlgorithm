package main.java.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    private int value = 0;
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // Read method
    public void read() {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Reading value: " + value);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    // Write method
    public void write(int newValue) {
        rwLock.writeLock().lock();
        try {
            value = newValue;
            System.out.println(Thread.currentThread().getName() + " Writing value: " + value);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReadWriteLockExample example = new ReadWriteLockExample();

        Runnable readTask = () -> {
            for (int i = 0; i < 3; i++) {
                example.read();
            }
        };

        Runnable writeTask = () -> {
            for (int i = 0; i < 3; i++) {
                example.write((int) (Math.random() * 100));
            }
        };

        Thread t1 = new Thread(readTask, "Reader-1");
        Thread t2 = new Thread(readTask, "Reader-2");
        Thread t3 = new Thread(writeTask, "Writer-1");

        t1.start();
        t2.start();
        t3.start();
        
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit read tasks
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                example.read();
            });
        }

        // Submit write tasks
        for (int i = 0; i < 2; i++) {
            int newValue = i * 100;
            executor.submit(() -> {
                example.write(newValue);
            });
        }

        // Submit more read tasks
        for (int i = 0; i < 3; i++) {
            executor.submit(() -> example.read());
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("All tasks completed!");
    }
}
