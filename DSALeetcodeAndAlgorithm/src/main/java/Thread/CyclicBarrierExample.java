package main.java.Thread;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    public static void main(String[] args) {

        int threadCount = 3;

        // Barrier waits for 3 threads, then prints a message
        CyclicBarrier barrier = new CyclicBarrier(threadCount, () ->
                System.out.println("All threads reached the barrier!"));

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is performing task...");
                Thread.sleep((long) (Math.random() * 2000)); // simulate work

                System.out.println(Thread.currentThread().getName() + " waiting at barrier...");
                barrier.await(); // wait for other threads

                System.out.println(Thread.currentThread().getName() + " crossed the barrier!");

            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
            }
        };

        for (int i = 0; i < threadCount; i++) {
            executor.submit(task);
        }

        executor.shutdown();
    }
}

