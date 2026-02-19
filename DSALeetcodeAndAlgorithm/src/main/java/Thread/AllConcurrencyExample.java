package main.java.Thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

public class AllConcurrencyExample {

    static volatile boolean flag = true;
    static AtomicInteger atomicCounter = new AtomicInteger(0);

    static ReentrantLock reentrantLock = new ReentrantLock();
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Semaphore semaphore = new Semaphore(3);
    static CountDownLatch latch = new CountDownLatch(5);
    static CyclicBarrier barrier = new CyclicBarrier(5);
    static Phaser phaser = new Phaser(5);

    public static void main(String[] args) throws Exception {

        // 1️⃣ Basic Thread
        Thread t = new Thread(() -> System.out.println("Basic Thread Running"));
        t.start();

        // 2️⃣ ExecutorService (Fixed Pool)
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 3️⃣ Runnable
        executor.submit(() -> System.out.println("Runnable Task"));

        // 4️⃣ Callable + Future
        Future<Integer> future = executor.submit(() -> 100);
        System.out.println("Future Result: " + future.get());

        // 5️⃣ CompletableFuture
        CompletableFuture.supplyAsync(() -> 10)
                .thenApply(x -> x * 2)
                .thenAccept(result -> System.out.println("CompletableFuture: " + result));

        // 6️⃣ ThreadPoolExecutor (Custom)
        ThreadPoolExecutor customPool = new ThreadPoolExecutor(
                2, 4,
                60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10)
        );
        customPool.submit(() -> System.out.println("Custom ThreadPoolExecutor"));
        customPool.shutdown();

        // 7️⃣ Virtual Threads (Java 21)
        try (ExecutorService virtualExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            virtualExecutor.submit(() -> System.out.println("Virtual Thread"));
        }

        // 8️⃣ Start 5 threads to demonstrate locks
        for (int i = 0; i < 5; i++) {
            executor.submit(new Worker());
        }

        latch.await();
        executor.shutdown();

        System.out.println("Final Atomic Counter: " + atomicCounter.get());
    }

    static class Worker implements Runnable {

        @Override
        public void run() {
            try {

                // synchronized block
                synchronized (AllConcurrencyExample.class) {
                    System.out.println("Synchronized Block");
                }

                // ReentrantLock
                reentrantLock.lock();
                try {
                    atomicCounter.incrementAndGet();
                } finally {
                    reentrantLock.unlock();
                }

                // ReadWriteLock
                readWriteLock.readLock().lock();
                try {
                    System.out.println("Read Lock");
                } finally {
                    readWriteLock.readLock().unlock();
                }

                readWriteLock.writeLock().lock();
                try {
                    System.out.println("Write Lock");
                } finally {
                    readWriteLock.writeLock().unlock();
                }

                // Semaphore (only 3 threads allowed here)
                semaphore.acquire();
                try {
                    System.out.println("Semaphore Acquired by " + Thread.currentThread().getName());
                } finally {
                    semaphore.release();
                }

                // CyclicBarrier
                barrier.await();
                System.out.println("Passed CyclicBarrier");

                // Phaser
                phaser.arriveAndAwaitAdvance();
                System.out.println("Passed Phaser Phase");

                latch.countDown();

            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
