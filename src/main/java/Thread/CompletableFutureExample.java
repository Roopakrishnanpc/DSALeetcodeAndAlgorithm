package main.java.Thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {

        CompletableFuture<Void> future =
                CompletableFuture.runAsync(() -> {
                    System.out.println("Running async task");
                });

        future.join(); // wait for completion
        CompletableFuture<Integer> future1 =
                CompletableFuture.supplyAsync(() -> 10);

        System.out.println("Result: " + future1.join());
        CompletableFuture.supplyAsync(() -> 10)
        .thenApply(x -> x * 2)
        .thenApply(x -> x + 5)
        .thenAccept(result -> System.out.println("Final Result: " + result));
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);

        f1.thenCombine(f2, (a, b) -> a + b)
          .thenAccept(System.out::println);


    }
}
