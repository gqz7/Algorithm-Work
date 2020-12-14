package com.company;

public class Americano extends Beverage {
    public Americano () {
        this.description = "Americano";
    }

    @Override
    public double cost () {
        return 2.79;
    }
}
