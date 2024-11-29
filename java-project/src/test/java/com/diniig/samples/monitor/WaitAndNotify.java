package com.diniig.samples.monitor;

import org.junit.jupiter.api.Test;

public class WaitAndNotify {
    

    @Test
    void waitAndNotify() throws InterruptedException{
        Store s = new Store();
        Producer p = new Producer(s);
        Consumer c = new Consumer(s);
        Thread pt = new Thread(p);
        pt.setName("AAA");
        Thread ct = new Thread(c);
        ct.setName("BBB");
        
        ct.start();
        Thread.sleep(5000);
        pt.start();

        while (true) {
            Thread.sleep(5000);
        }
    }
}
