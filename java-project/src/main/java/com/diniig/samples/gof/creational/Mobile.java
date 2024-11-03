package com.diniig.samples.gof.creational;

public class Mobile implements Device {

    @Override
    public void print(String s) {
        
    }

    @Override
    public Mobile clone() {
        return new Mobile();
    }

}
