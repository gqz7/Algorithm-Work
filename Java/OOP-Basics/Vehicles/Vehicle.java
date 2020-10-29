package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle extends Entity {
    private List<Passenger> passengers;
    private Operator operator = null;
    private int maxPassengers;

    public Vehicle(String name, int maxPassengers) {
        super(name);
        this.maxPassengers = maxPassengers;
        passengers = new ArrayList<>();
    }

    public void addOperator(Occupant occupant) {
        if ( operator != null ) {
            System.out.println("The operator of this vehicle can not be replaced, they need to leave the vehicle first");
        } else {
          operator = (Operator) occupant;
        }
    }

    public void addPassenger(Occupant occupant) {
        if ( passengers.size() < maxPassengers ) {
            passengers.add( (Passenger) occupant );
        } else {
            System.out.println("You can not add anymore passengers to this vehicle.");
        }
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int countOccupants() {
        int count = 0;
        if (operator != null) count++;

        count += this.passengers.size();

        return count;
    }
}
