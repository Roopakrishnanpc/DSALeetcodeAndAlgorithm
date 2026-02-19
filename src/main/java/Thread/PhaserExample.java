package main.java.Thread;

import java.util.concurrent.*;

public class PhaserExample {

    public static void main(String[] args) {

        int threadCount = 3;
        Phaser phaser = new Phaser(threadCount); // 3 threads

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println(threadName + " Phase 1 working...");
                Thread.sleep((long) (Math.random() * 1000));
                phaser.arriveAndAwaitAdvance(); // wait for others
                System.out.println(threadName + " Phase 1 complete!");

                System.out.println(threadName + " Phase 2 working...");
                Thread.sleep((long) (Math.random() * 1000));
                phaser.arriveAndAwaitAdvance();
                System.out.println(threadName + " Phase 2 complete!");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        for (int i = 0; i < threadCount; i++) {
            executor.submit(task);
        }

        executor.shutdown();
    }
}
