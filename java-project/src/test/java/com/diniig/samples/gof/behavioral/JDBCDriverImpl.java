package com.diniig.samples.gof.behavioral;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JDBCDriverImpl implements JDBCDriver {

    public void doQuery(String string) {
        log.info("string {}", string);
    }
    
}
