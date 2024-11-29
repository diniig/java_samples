package com.diniig.samples.monitor;

public class Consumer implements Runnable {

    private Store s;

    public Consumer(Store s) {
        this.s = s;

    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            s.get();
            // try {
            //     Thread.sleep(5000);
            // } catch (InterruptedException e) {
            // }
        }
    }

}
