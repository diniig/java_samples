package com.diniig.samples.spring_project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SimpleSpringRunner {

	public static void main(String[] args) {
		log.info("starting..");
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleSpringRunner.class);

		log.info("hello world!");

		ctx.close();
	}

}
