package com.diniig.samples.spring_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		log.info("starting..");
		SpringApplication.run(SpringProjectApplication.class, args);
	}

}
