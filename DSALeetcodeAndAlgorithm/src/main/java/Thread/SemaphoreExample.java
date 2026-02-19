package main.java.Thread;

import java.util.concurrent.*;

public class SemaphoreExample {

    private static Semaphore semaphore = new Semaphore(3); // max 3 threads at a time

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting for permit...");
                semaphore.acquire();  // acquire a permit
                System.out.println(Thread.currentThread().getName() + " acquired permit, running task");
                
                Thread.sleep(1000); // simulate work
                
                System.out.println(Thread.currentThread().getName() + " releasing permit");
                semaphore.release();  // release the permit
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Submit 10 tasks
        for (int i = 0; i < 10; i++) {
            executor.submit(task);
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("All tasks completed!");
    }
}

