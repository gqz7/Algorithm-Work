package com.company;

public class TextBox extends UIControl {
    private String innerText = "";

    public TextBox(boolean isEnabled) {
        super(isEnabled);
    }
    //example of constructor overloading. This is useful because I can create a new instance of the text-box without having to pass any params
    public TextBox() {
        super(true);
    }

    public void setText (String text) {
        innerText = text;
    }

    @Override
    public void render () {
        System.out.println("Rendering TextBox: " + innerText);
    }

    @Override
    public String toString() {
        return innerText;
    }
}
