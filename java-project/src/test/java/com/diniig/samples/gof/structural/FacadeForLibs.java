package com.diniig.samples.gof.structural;

public class FacadeForLibs {

    private Lib1 lib1;
    private Lib2 lib2;
    private Lib3 lib3;

    public FacadeForLibs(Lib1 lib1, Lib2 lib2, Lib3 lib3) {
        this.lib1 = lib1;
        this.lib2 = lib2;
        this.lib3 = lib3;
    }

    public void doWithLib1() {
        lib1.toString();
    }

    public void doWithLib2() {
        lib2.toString();
    }

    public void doWithLib3() {
        lib3.toString();
    }

}
