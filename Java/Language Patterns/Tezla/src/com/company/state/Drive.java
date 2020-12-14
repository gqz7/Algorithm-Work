package com.company.state;

public class Drive implements State {
    @Override
    public void accelerate() {
        System.out.println("Car goes");
    }

    @Override
    public void openDoor() {
        System.out.println("Alert Alert! Cant open the door while driving.");
    }
}
