package com.diniig.samples.gof;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultStrategy implements Strategy {

    @Override
    public void print(String s) {
        log.info(s);
    }

}
