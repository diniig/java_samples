package com.diniig.samples.functional_interface;

public class MyFunConsumer {


    private String s;


    public MyFunConsumer(){
        
    }


    private void method1(){
        method2(t -> t.toString());
    }

    private void method2(MyFun my){
        my.myFun(s);
    }
}
