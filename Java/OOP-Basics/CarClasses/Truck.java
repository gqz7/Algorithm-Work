package com.company;

public class Truck extends Car {

    private int maxLoad;
    private float currentLoad;

    Truck ( int loadWeight ) {
        super(80, "black", "Truck");
        maxLoad = loadWeight;
        currentLoad = 0;
    }

    public float getCurrentLoad () {
        return currentLoad;
    }

    public void setCurrentLoad ( int weight ) {
        if ( weight <= maxLoad ) {
            currentLoad = weight;
        } else {
            System.out.println("The load weight is too much for your car");
        }
    }
}
