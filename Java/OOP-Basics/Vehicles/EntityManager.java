package com.company;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private static List<Entity> allEntities;
    private static List<Vehicle> allVehicles;
    private static List<Occupant> allOccupants;

    public EntityManager() {
        System.out.println("\nSimulation Start...\n");
        allEntities = new ArrayList<>();
        allVehicles = new ArrayList<>();
        allOccupants = new ArrayList<>();

    }

    public void addEntity ( Entity newEntity) {
        allEntities.add( newEntity );
    }

    public void addVehicle ( Vehicle newEntity) {
        allVehicles.add( newEntity );
    }

    public void addOccupant ( Occupant newEntity) {
        allOccupants.add( newEntity );
    }
}
