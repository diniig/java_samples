package com.diniig.samples.spring_project.prototypes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Random;

@Service
@Scope(org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// @Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
// @org.springframework.web.context.annotation.RequestScope
public class WeatherService {
    final private LocalTime time = LocalTime.now();
    final private int temperature = new Random().nextInt(60);

    public String getCurrentTemperature() {
        return time + " -> " + temperature;
    }
}
