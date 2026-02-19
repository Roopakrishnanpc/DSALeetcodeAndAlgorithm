package main.java.Thread;

import java.util.concurrent.*;
import java.util.*;

public class ReadWriteNamesExample {

    public static void main(String[] args) throws InterruptedException {

        // Thread-safe queue
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        List<String> namesToRead = Arrays.asList(
                "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace"
        );

        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Producer: Read names and add to queue
        Runnable readerTask = () -> {
            for (String name : namesToRead) {
                try {
                    System.out.println(Thread.currentThread().getName() + " reading: " + name);
                    queue.put(name); // blocks if queue is full
                    Thread.sleep(100); // simulate read delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Consumer: Write names from queue
        Runnable writerTask = () -> {
            while (true) {
                try {
                    String name = queue.take(); // blocks if queue empty
                    System.out.println(Thread.currentThread().getName() + " writing: " + name);
                    Thread.sleep(150); // simulate write delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break; // exit thread
                }
            }
        };

        // Start 2 reader threads
        executor.submit(readerTask);
        executor.submit(readerTask);

        // Start 2 writer threads
        executor.submit(writerTask);
        executor.submit(writerTask);

        // Let it run for a bit
        Thread.sleep(3000);

        // Shutdown executor gracefully
        executor.shutdownNow();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("All reading and writing tasks completed!");
    }
}
