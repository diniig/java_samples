package com.diniig.samples.gof.structural;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Shape {

    private int[][] declarationOfShape;
    private Сolored colored;

    public Shape(Сolored colored, int[][] declarationOfShape) {
        this.colored = colored;
        this.declarationOfShape = declarationOfShape;
    }

    public void draw() {
        int color = colored.getCollor();
        log.info("print shape {} with color {}", declarationOfShape, color);
    }
}
