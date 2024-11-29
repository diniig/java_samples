package com.diniig.samples.gof.behavioral;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddExpression implements Interpreter {

    Interpreter v1;
    Interpreter v2;

    @Override
    public int interprete() {
        return v1.interprete() + v2.interprete();
    }

}
