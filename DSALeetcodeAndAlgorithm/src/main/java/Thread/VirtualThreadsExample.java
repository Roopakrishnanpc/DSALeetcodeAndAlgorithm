package main.java.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadsExample {

    public static void main(String[] args) throws InterruptedException {

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 1; i <= 10; i++) {
                int taskNum = i;
                executor.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + " running task " + taskNum);
                    try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                });
            }

        } // auto-shutdown
        System.out.println("All virtual threads tasks completed!");
    }
}
