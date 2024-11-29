package com.diniig.samples.gof.behavioral;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberExpression implements Interpreter {
    // terminal expression
    int i;

    @Override
    public int interprete() {
        return i;
    }

}
