package main.java.Thread;

import java.util.concurrent.*;

public class CustomThreadPoolExample {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // core threads
                4, // max threads
                60, // keep-alive time
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5) // queue
        );

        for (int i = 1; i <= 6; i++) {
            int taskNum = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " running task " + taskNum);
                try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("All custom pool tasks finished!");
    }
}
