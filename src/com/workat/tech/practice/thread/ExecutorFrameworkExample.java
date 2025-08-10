package com.workat.tech.practice.thread;

import java.util.concurrent.*;

public class ExecutorFrameworkExample {

    public static void main(String[] args) {
        // Create a fixed-size thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit Runnable tasks
        executorService.execute(() -> {
            System.out.println("Task 1 running in: " + Thread.currentThread().getName());
        });

        executorService.execute(() -> {
            System.out.println("Task 2 running in: " + Thread.currentThread().getName());
        });

        // Submit Callable task with Future result
        Future<String> futureResult = executorService.submit(() -> {
            Thread.sleep(1000);
            return "Callable Task Completed by: " + Thread.currentThread().getName();
        });

        try {
            // Get the result from Future (blocks until done)
            System.out.println(futureResult.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the executor (gracefully stops accepting new tasks)
        executorService.shutdown();
    }
}
