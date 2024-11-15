package com.diniig.samples.tricks;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TricksTest {

    @Test
    void finallyFuncTest() {
        int f = finallyFunc();
        log.info("f {}", f);
    }

    int finallyFunc() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }
}
