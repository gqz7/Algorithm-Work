package com.company;

public class UIControl {

    private boolean isEnabled;

    public UIControl(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void enable() {
        isEnabled = true;
    }
    public  void disable() {
        isEnabled = false;
    }

    public void render() {

    }

    public void toggleEnabled () {
        isEnabled = !isEnabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

}
