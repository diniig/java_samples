package com.diniig.samples.gof.structural;

public class Adapter {

    LegacyCode code;

    public Adapter(LegacyCode legacyCode) {
        this.code = legacyCode;
    }

    public String getText() {
        return new String((char[])code.getChars());
    }

}
