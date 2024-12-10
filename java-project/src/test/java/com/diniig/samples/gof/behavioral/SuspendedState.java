package com.diniig.samples.gof.behavioral;

public class SuspendedState implements State {

    @Override
    public State goSuspend() {
        return this;
    }

    @Override
    public State goResume() {
        return new ResumedState();
    }

    @Override
    public boolean isSleepMode() {
        return true;
    }

}
