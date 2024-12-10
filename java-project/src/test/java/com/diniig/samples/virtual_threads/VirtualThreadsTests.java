package com.diniig.samples.virtual_threads;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VirtualThreadsTests {

    @Test
    void test_sync() throws InterruptedException {
        log.info("hello virtual world");
        Integer userId = 1;
        String userName = get_username_from_db(userId, 5_000);
        System.out.printf("Hello, %s!", userName);
    }

    private String get_username_from_db(Integer userId, long delay) throws InterruptedException {
        Thread.sleep(delay);
        return "Vasia";
    }

    private synchronized String get_username_from_db_synchronized(Integer userId, long delay)
            throws InterruptedException {
        Thread.sleep(delay);
        return "Vasia";
    }

    @Test
    void test_async() throws InterruptedException, ExecutionException {
        log.info("hello virtual world");
        Integer userId = 1;

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                return get_username_from_db(userId, 5_000);
            } catch (InterruptedException e) {
                log.error("error: ", e);
                return "";
            }
        });

        CompletableFuture cf2 = cf.thenApply(t -> System.out.printf("Hello, %s!", t));

        cf2.get();
        log.info("all done");
    }

    @Test
    void test_virtual() throws InterruptedException, ExecutionException {
        log.info("hello virtual world");
        Integer userId = 1;

        CompletableFuture<String> cf = new CompletableFuture<>();
        Thread thr = Thread.ofVirtual().name("my-thr-1").unstarted(() -> {
            try {
                cf.complete(get_username_from_db(userId, 500_000));
            } catch (InterruptedException e) {
                log.error("error: ", e);
                cf.complete("");
            }
        });
        thr.start();

        CompletableFuture cf2 = cf.thenApply(t -> System.out.printf("Hello, %s!", t));

        cf2.get();
        log.info("all done");
    }

    @Test
    void test_virtual_startVirtualThread() throws InterruptedException, ExecutionException {
        log.info("hello virtual world");
        Integer userId = 1;

        Thread.startVirtualThread(() -> {
            try {
                get_username_from_db_synchronized(userId, 500_000);
            } catch (InterruptedException e) {
                log.error("error: ", e);
            }
        });
    }

    @Test
    void test_virtual_VirtualThreadPerTaskExecutor() throws InterruptedException, ExecutionException {
        log.info("hello virtual world");
        Integer userId = 1;

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(() -> {
            try {
                get_username_from_db(userId, 500_000);
            } catch (InterruptedException e) {
                log.error("error: ", e);
            }
        });

    }

    @Test
    void test_virtual_VirtualThreadfactory() throws InterruptedException, ExecutionException {
        log.info("hello virtual world");
        Integer userId = 1;

        ThreadFactory factory = Thread.ofVirtual().factory();
        factory.newThread(() -> {
            try {
                get_username_from_db(userId, 500_000);
            } catch (InterruptedException e) {
                log.error("error: ", e);
            }
        }).start();

    }



}
