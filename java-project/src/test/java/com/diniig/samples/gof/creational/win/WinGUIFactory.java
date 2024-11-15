package com.diniig.samples.gof.creational.win;

import com.diniig.samples.gof.creational.Button;
import com.diniig.samples.gof.creational.GUIFactory;
import com.diniig.samples.gof.creational.Select;
import com.diniig.samples.gof.creational.TextField;

public class WinGUIFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public TextField createTextField() {
        return new WinTextField();
    }

    @Override
    public Select createSelect() {
        return new WinSelect();
    }
    
}
