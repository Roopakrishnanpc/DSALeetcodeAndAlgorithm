package main.java.Thread;

import java.util.concurrent.*;
import java.util.*;

public class UserWriteReadCallableExample {

    public static void main(String[] args) throws Exception {

        // Thread-safe queue for names
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Scanner scanner = new Scanner(System.in);

        // Writer task (user input)
        Callable<Void> writerTask = () -> {
            System.out.println("Type names (type 'exit' to quit):");
            while (true) {
                String name = scanner.nextLine();
                if ("exit".equalsIgnoreCase(name)) {
                    break;
                }
                queue.put(name); // add to queue
                System.out.println("Added to queue: " + name);
            }
            return null;
        };

        // Reader task (process names)
        Callable<List<String>> readerTask = () -> {
            List<String> processedNames = new ArrayList<>();
            try {
                while (true) {
                    String name = queue.take(); // blocks if empty
                    System.out.println("Reader processed: " + name);
                    processedNames.add(name);
                }
            } catch (InterruptedException e) {
                System.out.println("Reader interrupted, stopping...");
                Thread.currentThread().interrupt();
            }
            return processedNames;
        };

        // Submit tasks
        Future<Void> writerFuture = executor.submit(writerTask);
        Future<List<String>> readerFuture = executor.submit(readerTask);

        // Wait for writer to finish
        writerFuture.get(); // blocks until user types 'exit'

        // Stop reader gracefully
        executor.shutdownNow();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        // Get processed names (optional)
        List<String> allProcessedNames = new ArrayList<>();
        try {
            allProcessedNames = readerFuture.get(); // may be empty if interrupted
        } catch (CancellationException | InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("All processed names: " + allProcessedNames);
        System.out.println("Program terminated!");
        
        
    }
}



class OptimizedNameProcessor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int readerThreads = 4; // number of reader threads
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(); // unbounded queue

        ExecutorService executor = Executors.newFixedThreadPool(readerThreads + 1); // +1 for writer
        Scanner scanner = new Scanner(System.in);

        // Poison pill to signal readers to stop
        final String POISON_PILL = "POISON_PILL";

        // Writer task: read names from user
        Callable<Void> writerTask = () -> {
            System.out.println("Enter names (type 'exit' to stop):");

            while (true) {
                String name = scanner.nextLine();
                if ("exit".equalsIgnoreCase(name)) break;
                queue.put(name); // add to queue
            }

            // Add poison pills for readers to stop
            for (int i = 0; i < readerThreads; i++) {
                queue.put(POISON_PILL);
            }
            return null;
        };

        // Reader task: process names
        Callable<Integer> readerTask = () -> {
            int processedCount = 0;
            while (true) {
                String name = queue.take();
                if (POISON_PILL.equals(name)) break; // stop signal
                // Process the name (e.g., print or write to DB/file)
                System.out.println(Thread.currentThread().getName() + " processed: " + name);
                processedCount++;
            }
            return processedCount;
        };

        // Submit writer
        Future<Void> writerFuture = executor.submit(writerTask);

        // Submit readers
        List<Future<Integer>> readerFutures = new ArrayList<>();
        for (int i = 0; i < readerThreads; i++) {
            readerFutures.add(executor.submit(readerTask));
        }

        // Wait for writer to finish
        writerFuture.get();

        // Wait for readers to finish
        int totalProcessed = 0;
        for (Future<Integer> f : readerFutures) {
            totalProcessed += f.get();
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("All names processed. Total: " + totalProcessed);
        System.out.println("Program terminated!");
    }
}


