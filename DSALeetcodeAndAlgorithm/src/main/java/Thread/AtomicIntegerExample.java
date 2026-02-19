package main.java.Thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger counter = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                int value = counter.incrementAndGet(); // atomic increment
                System.out.println(Thread.currentThread().getName() + " Counter: " + value);
            }
        };

        for (int i = 0; i < 5; i++) {
            executor.submit(task);
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Final Counter Value: " + counter.get());
    }
}
