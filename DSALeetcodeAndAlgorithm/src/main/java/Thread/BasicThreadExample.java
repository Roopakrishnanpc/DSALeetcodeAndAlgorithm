package main.java.Thread;

public class BasicThreadExample {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println("Thread is running: " + Thread.currentThread().getName());
        });

        t.start();
    }
}
