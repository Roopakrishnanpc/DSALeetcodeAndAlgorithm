package main.java.Thread;

import java.util.concurrent.*;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 5;
        CountDownLatch latch = new CountDownLatch(threadCount);

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 1; i <= threadCount; i++) {
            int taskNum = i;
            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is running task " + taskNum);
                    Thread.sleep(1000); // simulate work
                    System.out.println(Thread.currentThread().getName() + " finished task " + taskNum);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown(); // reduce count
                }
            });
        }

        System.out.println("Main thread waiting for tasks to complete...");
        latch.await(); // wait for all tasks
        System.out.println("All tasks completed, main thread proceeds!");

        executor.shutdown();
//        Latch count = 5 → waiting for 5 threads.
//        Each thread calls countDown() when done.
//        Main thread blocks on await() until all threads finish.
    }
}
