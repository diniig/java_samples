package com.diniig.samples.monitor;

public class Producer implements Runnable {

    private Store s;

    public Producer(Store s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            s.put();
            // try {
            //     Thread.sleep(5000);
            // } catch (InterruptedException e) {
            // }
        }

        
    }

}
