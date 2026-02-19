package main.java.Thread;

import java.util.concurrent.*;

public class ExecutorServiceExamples {

    public static void main(String[] args) throws Exception {

        // 1️⃣ FixedThreadPool – Fixed number of threads
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        System.out.println("FixedThreadPool:");
        for (int i = 1; i <= 5; i++) {
            int taskNum = i;
            fixedPool.submit(() -> {
                System.out.println("FixedPool Task " + taskNum + " - " + Thread.currentThread().getName());
            });
        }
        fixedPool.shutdown();
        fixedPool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("-----------------------------------");

        // 2️⃣ CachedThreadPool – Creates new threads as needed
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        System.out.println("CachedThreadPool:");
        for (int i = 1; i <= 5; i++) {
            int taskNum = i;
            cachedPool.submit(() -> {
                System.out.println("CachedPool Task " + taskNum + " - " + Thread.currentThread().getName());
            });
        }
        cachedPool.shutdown();
        cachedPool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("-----------------------------------");

        // 3️⃣ SingleThreadExecutor – Only one thread
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        System.out.println("SingleThreadExecutor:");
        for (int i = 1; i <= 3; i++) {
            int taskNum = i;
            singleThread.submit(() -> {
                System.out.println("SingleThread Task " + taskNum + " - " + Thread.currentThread().getName());
            });
        }
        singleThread.shutdown();
        singleThread.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("-----------------------------------");

        // 4️⃣ ScheduledThreadPool – Delayed or periodic tasks
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        System.out.println("ScheduledThreadPool:");
        scheduledPool.schedule(() -> System.out.println("Delayed Task executed"), 2, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(() -> System.out.println("Periodic Task executed"), 1, 2, TimeUnit.SECONDS);

        // Wait a bit to see scheduled tasks
        Thread.sleep(7000);
        scheduledPool.shutdown();
        System.out.println("-----------------------------------");

        // 5️⃣ Custom ThreadPoolExecutor – Full control
        ThreadPoolExecutor customPool = new ThreadPoolExecutor(
                2,        // core threads
                4,        // max threads
                60,       // keep alive time
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5) // work queue
        );
        System.out.println("Custom ThreadPoolExecutor:");
        for (int i = 1; i <= 6; i++) {
            int taskNum = i;
            customPool.submit(() -> {
                System.out.println("CustomPool Task " + taskNum + " - " + Thread.currentThread().getName());
            });
        }
        customPool.shutdown();
        customPool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("All ExecutorService examples finished!");
    }
}
