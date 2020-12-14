package com.company.state;

public class Parked implements State {
    @Override
    public void accelerate() {
        System.out.println("Engine revs. Car goes nowhere");
    }

    @Override
    public void openDoor() {
        System.out.println("Door opens");
    }
}
