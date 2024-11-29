package com.diniig.samples.gof;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyObserverImpl implements MyObserver {

    @Override
    public void update(int i) {
        log.info("do some update on update {}", i);
    }

}
