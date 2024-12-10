package com.diniig.samples.gof.behavioral;

public interface State {
    State goSuspend();
    State goResume();
    boolean isSleepMode();
}
