package main.java.Thread;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            return 10 + 20;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Result: " + future.get()); // blocks until result is ready

        executor.shutdown();
//        future.get();           // waits and returns result
//        future.isDone();        // check if completed
//        future.cancel(true);    // cancel task

    }
}
