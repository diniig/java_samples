package com.diniig.samples.spring_project;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StartupApplicationListener {

    public static int counter;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Increment counter");
        counter++;

        // RestTemplate restTemplate = new RestTemplate();
        // ResponseEntity<String> res = restTemplate.exchange(URI.create("https://google.com"), HttpMethod.GET, null, String.class);
        // log.info("res {}", res);
    }
}
