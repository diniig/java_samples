package com.diniig.samples.spring_project.listeners;

import com.diniig.samples.spring_project.schedules.JobsAggregator;

import org.hibernate.annotations.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RequestOnStartListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    JobsAggregator jobsAggregator;

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        // RestTemplate restTemplate = new RestTemplate();
        // ResponseEntity<String> res = restTemplate.exchange(URI.create("https://google.com"), HttpMethod.GET, null,
        //         String.class);
        // log.info("res {}", res);


        try {
            jobsAggregator.asyncMethod_1();

            jobsAggregator.asyncMethod_2();

            Future<String> future = jobsAggregator.asyncMethod_3();
            log.info("FUTURE RETURNS {}", future.get());


            CompletableFuture<String> task1 = jobsAggregator.asyncMethod_4();
            CompletableFuture<String> task2 = jobsAggregator.asyncMethod_5();

            CompletableFuture<Object> composed = task1.thenCompose(t1 -> task2.thenApply(t2 -> t1 + " " + t2));
            log.info("COMPOSED FUTURE RETURNS {}", composed.get());
        

        } catch (InterruptedException | ExecutionException e) {
            log.error("Exception", e);
        }
    }
}
