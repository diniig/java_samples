package com.diniig.samples.gof.behavioral;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class BehavioralTest {

    @Test
    void chainOfResponsobilities() {
        TextFilter f = new NoCapitalCharFilter(new NoCapitalCharFilter(null));
        assertEquals("helloworld", f.doFilter("Hello World")); 
    }

}
