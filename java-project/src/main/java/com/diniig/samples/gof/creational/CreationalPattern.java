package com.diniig.samples.gof.creational;

import com.diniig.samples.gof.creational.mac.MacGUIFactory;
import com.diniig.samples.gof.creational.win.WinGUIFactory;

public class CreationalPattern implements GUIFactoryCreator {
    
    final static public CreationalPattern INSTANCE = new CreationalPattern();

    public String getOs() {
        return System.getProperty("os.name").toLowerCase();
    }
    
    @Override
    public GUIFactory getGUIFactory() { // factory method
        GUIFactory factory;
        if (getOs() == "mac") {
            factory = new MacGUIFactory();  // abstract factory
        } else { // win
            factory = new WinGUIFactory();  // abstract factory
        }
        return factory;
    }

}
