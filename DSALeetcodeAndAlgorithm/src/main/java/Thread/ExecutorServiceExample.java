package main.java.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println(
                        "Task " + taskNumber +
                        " executed by " + Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown(); // Always shutdown
//        executor.submit(task);   // submit Runnable or Callable
//        executor.shutdown();     // stop accepting new tasks
//        executor.shutdownNow();  // force stop
//        executor.awaitTermination(5, TimeUnit.SECONDS);

    }
}

