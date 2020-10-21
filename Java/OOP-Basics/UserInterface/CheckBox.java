package com.company;

public final class CheckBox extends UIControl { //because this class is final there can be no class that extends (is a child of) the CheckBox class
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
