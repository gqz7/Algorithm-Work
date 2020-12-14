package com.company;

//State Pattern

import com.company.state.Drive;
import com.company.state.Parked;
import com.company.state.Reverse;
import com.company.state.State;

public class TezlaRoadster {

    State drive = new Drive();
    State parked = new Parked();
    State reverse = new Reverse();

    State currentState = parked;

    public void pushPetal() {
        currentState.accelerate();
    }

    public void openDoor() {
        currentState.openDoor();
    }

    public void shiftToDrive () {
        currentState = drive;
    }

    public void shiftToReverse () {
        currentState = reverse;
    }

    public void shiftToPark () {
        currentState = parked;
    }
}
