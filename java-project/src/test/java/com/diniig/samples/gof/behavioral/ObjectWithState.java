package com.diniig.samples.gof.behavioral;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectWithState {

    private   State state;

    public ObjectWithState(State state) {
        this.state = state;
    }

    public void suspend() {
        state = state.goSuspend();
    }

    public void resume() {
        state = state.goResume();
    }

    public void print(String string) {
       log.info(string);
    }

    public Strategy getPrintStrategy() {
        if(state.isSleepMode()){
            return new SleepStrategy();
        }
        return new DefaultStrategy();
    }



}
