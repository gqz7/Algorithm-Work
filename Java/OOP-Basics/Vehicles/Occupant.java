package com.company;

public abstract class Occupant extends Entity {

    public Vehicle occupying;

    Occupant(String name ) {
        super(name);
    }

    public void occupyVehicle ( Vehicle targetVehicle ) {
        occupying = targetVehicle;
        if ( this instanceof Operator ) {
            targetVehicle.addOperator( this );
        } else if ( this instanceof Passenger ) {
            targetVehicle.addPassenger( this);
        } else {
            System.out.println("Something went wrong, Occupant needs to be Passenger or Operator");
        }
    }

}
