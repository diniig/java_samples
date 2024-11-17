package com.diniig.samples.dymanic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntroInvocationHandler implements InvocationHandler {

    private Intro ind;

    public IntroInvocationHandler(Intro ind) {
        this.ind = ind;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("hello world from invoke");
        return method.invoke(ind, args);
    }

}
