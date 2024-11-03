package com.diniig.samples.clonning;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Name {
    String name;

    @Override
    public Name clone() {
        return new Name(name);
    }

    public String getName() {
        return name;
    }
}
