package com.diniig.samples.spring_project.configuratiorns;

import com.diniig.samples.spring_project.threads.MyThreadFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Configuration
public class ExecutorsConfiguration {

    @Bean(destroyMethod = "shutdown")
    public Executor myExecutor() {
        ThreadFactory namedThreadFactory = new MyThreadFactory("myExecutor-");
        return Executors.newFixedThreadPool(4, namedThreadFactory);
    }
}
