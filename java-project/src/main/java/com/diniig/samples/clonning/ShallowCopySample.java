package com.diniig.samples.clonning;

import java.util.List;

public class ShallowCopySample {
    private int i;
    private String s;
    private List<Name> names;

    public ShallowCopySample(int i, String s, List<Name> names) {
        this.i = i;
        this.s = s;
        this.names = names;
    }

    @Override
    public ShallowCopySample clone() {
        return new ShallowCopySample(i, s, names);
    }
}
