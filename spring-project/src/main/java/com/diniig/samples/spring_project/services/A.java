package com.diniig.samples.spring_project.services;

import org.springframework.stereotype.Service;

import java.time.Instant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class A implements SomeExistingService {

    @Override
    public void printTime() {
        log.info("current time 1: {}", System.currentTimeMillis());
        log.info("current time 2: {}", Instant.now());
    }

}