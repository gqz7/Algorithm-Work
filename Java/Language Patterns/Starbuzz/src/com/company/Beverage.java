package com.company;

//Wrapper Pattern pg. 91 $ 107

public abstract class Beverage {

    public String description = "Unknown Description";


    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
