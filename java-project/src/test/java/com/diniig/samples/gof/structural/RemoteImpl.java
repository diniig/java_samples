package com.diniig.samples.gof.structural;

public class RemoteImpl implements Remote {
    private int volume = 50;
    private boolean onOff = false;

    @Override
    public void volumeUp() {
        volume = volume+1;
    }

    @Override
    public void volumeDown() {
        volume = volume-1;
    }

    @Override
    public void on() {
        onOff = true;
    }

    @Override
    public void off() {
        onOff = false;
    }

    @Override
    public void volume(int a) {
        volume = a;
    }

}
