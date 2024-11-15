package com.diniig.samples.gof.creational;

public class PC implements Device {

    @Override
    public void print(String s) {
        // print
    }

    @Override
    public PC clone() {
        return new PC();
    }

}
