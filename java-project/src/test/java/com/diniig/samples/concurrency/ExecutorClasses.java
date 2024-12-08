package com.diniig.samples.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecutorClasses {

    private void daemonThreads() {
        Thread myThread = new Thread();
        myThread.setDaemon(true);
        myThread.start();
    }

    private void future() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Callable<Integer> callableTask = () -> {
            System.out.println("Выполняется в отдельном потоке");
            return 42;
        };
        Future<Integer> future = executor.submit(callableTask);
        try {
            Integer result = future.get();
            System.out.println("Результат: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    private void completeableFuture() throws InterruptedException, ExecutionException {
        {

            Future<String> completableFuture = CompletableFuture.completedFuture("Hello");
            String result = completableFuture.get();
        }

        {
            CompletableFuture<String> completableFuture = new CompletableFuture<>();

            Executors.newCachedThreadPool().submit(() -> {
                Thread.sleep(500);
                completableFuture.complete("Hello");
                return null;
            });
            String result = completableFuture.get();
        }

        {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
            future.get();
        }

        {
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
            CompletableFuture<String> future = completableFuture.thenApply(s -> s + " World");
            future.get();
        }
        
        {
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
                    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
            completableFuture.get();
        }
    }
}
