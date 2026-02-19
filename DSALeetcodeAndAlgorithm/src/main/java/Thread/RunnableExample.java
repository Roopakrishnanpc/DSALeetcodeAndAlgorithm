package main.java.Thread;

import java.util.concurrent.*;

public class RunnableExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            System.out.println("Runnable is running");
        };

        executor.submit(task);

        executor.shutdown();
    }
}

