package com.diniig.samples.gof;

public interface Processor {
    void subscribe(MyObserver ob);
    void notifyUpdate();
}
