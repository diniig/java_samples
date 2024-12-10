package com.diniig.samples.gof.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ProcessorImpl implements Processor {

    List<MyObserver> subscribers = new ArrayList<>();
    int i;

    @Override
    public void subscribe(MyObserver ob) {
        subscribers.add(ob);
    }


    public void update(int i) {
        this.i = i;
        notifyUpdate();
    }

    @Override
    public void notifyUpdate() {
        subscribers.stream().forEach(t -> t.update(i));
    }


}
