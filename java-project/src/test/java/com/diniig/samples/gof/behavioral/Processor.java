package com.diniig.samples.gof.behavioral;

public interface Processor {
    void subscribe(MyObserver ob);
    void notifyUpdate();
}
