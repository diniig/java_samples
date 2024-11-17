package com.diniig.samples.dymanic_proxy;

public class Individual implements Intro {

    private String name;

    public Individual(String name) {
        this.name = name;
    }

    @Override
    public String introduce() {
        return "My name is " + name();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String address() {
        return "I am living in Moscow";
    }    
}
