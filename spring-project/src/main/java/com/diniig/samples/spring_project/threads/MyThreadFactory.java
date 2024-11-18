package com.diniig.samples.spring_project.threads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
    private AtomicInteger threadNumber = new AtomicInteger(1);
    private String threadlNamePrefix = "";

    public MyThreadFactory(String threadlNamePrefix) {
        this.threadlNamePrefix = threadlNamePrefix;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, threadlNamePrefix + threadNumber.getAndIncrement());
    }
}
