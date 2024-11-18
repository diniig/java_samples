package com.diniig.samples.spring_project.schedules;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import javax.management.RuntimeErrorException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JobsAggregator {

    @Async("myExecutor")
    @Scheduled(cron = "*/1 * * * * *")
    public void everySecond() {
        log.info("everySecond. time: {}. thread: {}", LocalTime.now(), Thread.currentThread().getName());
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void everyFiveSeconds() throws InterruptedException {
        log.info("everyFiveSeconds. time: {}. thread: {}", LocalTime.now(), Thread.currentThread().getName());
        Thread.sleep(3000);
    }

    @Async("taskExecutor")
    public void asyncMethod_1() throws InterruptedException {
        log.info("asyncMethod 1. time: {}. thread: {}", LocalTime.now(), Thread.currentThread().getName());
        Thread.sleep(3000);
    }

    @Async("commonExecutor")
    public void asyncMethod_2() throws InterruptedException {
        log.info("asyncMethod 2. time: {}. thread: {}", LocalTime.now(), Thread.currentThread().getName());
        Thread.sleep(3000);
        throw new RuntimeException("AAAA");
    }

    @Async("myExecutor")
    public Future<String> asyncMethod_3() throws InterruptedException {
        log.info("asyncMethod 3. time: {}. thread: {}", LocalTime.now(), Thread.currentThread().getName());
        Thread.sleep(3000);
        CompletableFuture<String> future = new CompletableFuture<String>();
        future.complete("hello world !!!!");
        return future;
    }

    @Async("taskExecutor")
    public CompletableFuture<String> asyncMethod_4() throws InterruptedException {
        log.info("asyncMethod 4. time: {}. thread: {}", LocalTime.now(), Thread.currentThread().getName());
        Thread.sleep(3000);
        CompletableFuture<String> future = new CompletableFuture<String>();
        future.complete("hello");
        return future;
    }

    @Async("commonExecutor")
    public CompletableFuture<String> asyncMethod_5() throws InterruptedException {
        log.info("asyncMethod 5. time: {}. thread: {}", LocalTime.now(), Thread.currentThread().getName());
        Thread.sleep(3000);
        CompletableFuture<String> future = new CompletableFuture<String>();
        future.complete("world !!!!");
        return future;
    }
}
