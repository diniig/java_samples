package com.diniig.samples.gof.behavioral;

public class ResumedState implements State {

    @Override
    public State goSuspend() {
        return new SuspendedState();
    }

    @Override
    public State goResume() {
        return this;
    }

    @Override
    public boolean isSleepMode() {
        return false;
    }

}
