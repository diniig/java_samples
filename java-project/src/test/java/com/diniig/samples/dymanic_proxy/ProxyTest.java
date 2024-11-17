package com.diniig.samples.dymanic_proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyTest {

    @Test
    void prexyTests() {
        Individual sasha = new Individual("Sasha");

        ClassLoader classLoader = sasha.getClass().getClassLoader();
        Class<?>[] interfaces = sasha.getClass().getInterfaces();

        Intro sashaProxy = (Intro) java.lang.reflect.Proxy.newProxyInstance(classLoader, interfaces, new IntroInvocationHandler(sasha));
        String address = sashaProxy.address();
        log.info("address: {}", address);
        log.info("finished");
    }
}
