package com.diniig.samples.spring_project.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestOnStartListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        // RestTemplate restTemplate = new RestTemplate();
        // ResponseEntity<String> res = restTemplate.exchange(URI.create("https://google.com"), HttpMethod.GET, null,
        //         String.class);
        // log.info("res {}", res);
    }
}
