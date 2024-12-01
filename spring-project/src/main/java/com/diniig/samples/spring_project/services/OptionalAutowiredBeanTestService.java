package com.diniig.samples.spring_project.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OptionalAutowiredBeanTestService {
    SomeExistingService serviceA;
    SomeNotExistingService serviceB;

    @Autowired(required = false)
    SomeNotExistingService serviceC;

    @Autowired
    ObjectProvider<SomeNotExistingService> serviceD;

    @Autowired
    Optional<SomeNotExistingService> serviceE;

    @Autowired
    Optional<SomeExistingService> serviceF;

    @Autowired
    public void setA(SomeExistingService a) {
        this.serviceA = a;
    }

    @Autowired(required = false)
    public void setB(SomeNotExistingService b) {
        this.serviceB = b;
    }


        @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        serviceA.printTime();
        assert serviceB == null;
        assert serviceC == null;
        assert serviceD.getIfAvailable() == null;
        assert serviceD.getObject() == null;
        assert !serviceE.isPresent();
        assert serviceE.orElse(null) == null;
        assert serviceF.isPresent();
    }
}
