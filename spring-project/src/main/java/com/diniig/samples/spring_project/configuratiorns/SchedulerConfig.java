package com.diniig.samples.spring_project.configuratiorns;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {  
  
    @Override  
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {  
        // taskRegistrar.setScheduler(taskExecutor());  
    }   
}
