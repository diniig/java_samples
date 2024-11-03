package com.diniig.samples.gof.structural;

import java.util.ArrayList;
import java.util.List;

public class CompositeAction implements Action {

    List<Action> actions = new ArrayList<Action>();

    public void add(Action action) {
        actions.add(action);
    }

    public void run() {
        for (Action action : actions) {
            action.run();
        }
    }

}
