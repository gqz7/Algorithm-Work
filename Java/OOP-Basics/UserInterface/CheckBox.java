package com.company;

public class CheckBox extends UIControl {
    private boolean isChecked=false;
    public CheckBox(boolean isEnabled) {
        super(isEnabled);
    }
    public CheckBox() {
        super(true);
    }
    @Override
    public void render () {
        System.out.println("Rendering Checkbox, isChecked: " + isChecked);
    }
}
