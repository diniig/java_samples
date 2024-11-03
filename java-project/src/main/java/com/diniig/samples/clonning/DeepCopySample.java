package com.diniig.samples.clonning;

import java.util.ArrayList;
import java.util.List;

public class DeepCopySample {
    private int i;
    private String s;
    private List<Name> names;

    public DeepCopySample(int i, String s, List<Name> names) {
        this.i = i;
        this.s = s;
        this.names = names;
    }

    @Override
    public DeepCopySample clone() {
        List<Name> copyNames = new ArrayList<>(names.size()) ;
        for (Name n : names) {
            copyNames.add(n.clone());
        }

        return new DeepCopySample(i, s, copyNames);
    }

    public List<Name> getNames() {
        return names;
    }
}
