package com.diniig.samples.gof.behavioral;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SleepStrategy implements Strategy {

    @Override
    public void print(String s) {
        log.info("sorry i am sleep");
    }

}
