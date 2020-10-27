package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle extends Entity {
    public List<Passenger> passengers;
    public Operator operator;

    public Vehicle(String name) {
        super(name);
        passengers = new ArrayList<>();
//      operator = new Operator(); //does not need to be assigned in constructor
    }

}
