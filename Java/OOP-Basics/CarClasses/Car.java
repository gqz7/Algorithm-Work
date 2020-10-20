package com.company;


//        Create a car class and at least two child classes that inherit from the car class.
//
//        the car class should have at least 3 fields and 1 method that belongs to all cars.
//        the sub classes should each have at least 1 field and 1 method that is unique to the subclass
//        extra challenge. include an override or overloaded method


public class Car {

    float xPosition = 0;
    boolean movingForward = true;
    boolean isDriving = false;

    public void moveForward ( int velocity ) {
        if (this.movingForward) {
            this.xPosition += velocity;
        } else {
            this.xPosition -= velocity;
        }
    }

    public void toggleIsDriving () {
        this.isDriving = !this.isDriving;
    }

    public void toggleMovingForward () {
        this.movingForward = !this.movingForward;
    }

}
