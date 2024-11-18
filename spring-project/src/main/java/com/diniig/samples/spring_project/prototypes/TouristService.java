package com.diniig.samples.spring_project.prototypes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public abstract class TouristService {

    private final ObjectFactory<WeatherService> objectFactory;

    @Lookup
    public abstract WeatherService weather();

    public String getWeather() {
        return weather().getCurrentTemperature();
    }

    public String getWeather2() {
        return objectFactory.getObject().getCurrentTemperature();
    }
}