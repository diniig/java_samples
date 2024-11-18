package com.diniig.samples.spring_project.configuratiorns;

import com.diniig.samples.spring_project.threads.MyThreadFactory;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor() {
        ThreadFactory namedThreadFactory = new MyThreadFactory("taskExecutor-");
        return Executors.newScheduledThreadPool(4, namedThreadFactory);
    }

    @Bean(destroyMethod = "shutdown")
    public Executor commonExecutor() {
        ThreadFactory namedThreadFactory = new MyThreadFactory("commonExecutor-");
        return Executors.newFixedThreadPool(4, namedThreadFactory);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {

            @Override
            public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
                System.out.println("==============================================");
                System.out.println("Exception message - " + throwable.getMessage());
                System.out.println("Method name - " + method.getName());
                for (Object param : obj) {
                    System.out.println("Parameter value - " + param);
                }
                System.out.println("==============================================");
            }
        };
    }
}
