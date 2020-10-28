package com.company;

public class MotorBoat extends Watercraft {
    int motorHorsePower;
    public MotorBoat( String name, int maxPassengers, int horsePower ) {
        super( name, maxPassengers);
        motorHorsePower = horsePower;
    }
}
