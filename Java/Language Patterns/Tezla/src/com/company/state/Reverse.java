package com.company.state;

public class Reverse implements State {
    @Override
    public void accelerate() {
        System.out.println("Go goes backwards.");
    }

    @Override
    public void openDoor() {
        System.out.println("Alert car is going backwards");
    }
}
