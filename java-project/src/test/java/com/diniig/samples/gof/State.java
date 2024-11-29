package com.diniig.samples.gof;

public interface State {
    State goSuspend();
    State goResume();
    boolean isSleepMode();
}
