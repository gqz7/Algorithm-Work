package com.company;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private static List<Entity> allEntities;
    private static List<Vehicle> allVehicles;
    private static List<Occupant> allOccupants;
    private static List<Occupant> allOperators;
    private static List<Occupant> allPassengers;

    public EntityManager() {
        System.out.println("\nSimulation Start...\n");
        allEntities = new ArrayList<>();
        allVehicles = new ArrayList<>();
        allOccupants = new ArrayList<>();
        allOperators = new ArrayList<>();
        allPassengers = new ArrayList<>();

    }

    private static void addEntity ( Entity newEntity) {
        allEntities.add( newEntity );
    }

    public static void addVehicle ( Vehicle newEntity) {
        allVehicles.add( newEntity );
        addEntity( newEntity );
    }

    private static void addOccupant ( Occupant newEntity) {
        allOccupants.add( newEntity );
        addEntity( newEntity );
    }

    public static void addOperator ( Operator newEntity) {
        allOperators.add( newEntity );
        addOccupant( newEntity );
    }

    public static void addPassenger ( Passenger newEntity) {
        allPassengers.add( newEntity );
        addOccupant( newEntity );
    }
}
