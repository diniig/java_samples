package com.diniig.samples.gof.creational.mac;

import com.diniig.samples.gof.creational.Button;
import com.diniig.samples.gof.creational.GUIFactory;
import com.diniig.samples.gof.creational.Select;
import com.diniig.samples.gof.creational.TextField;

public class MacGUIFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }

    @Override
    public Select createSelect() {
        return new MacSelect();
    }
    
}
