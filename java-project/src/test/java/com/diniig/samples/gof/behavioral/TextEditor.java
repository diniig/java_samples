package com.diniig.samples.gof.behavioral;

public class TextEditor {
    String text;

    public void add(String string) {
        text = text + string;
    }

    public TextStore save() {
        return new TextStore(text);
    }

    public void restore(TextStore momento) {
        text = momento.getText();
    }

}
