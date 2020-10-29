package com.company;

import java.text.MessageFormat;
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

    public void showAllVehicleInfo () {
        System.out.println("\nAll Vehicles In Storage\n____________________\n");
        int count = 1;
        for ( Vehicle vehicle : allVehicles ) {

            int maxPass = vehicle.getMaxPassengers();
            int currentlyHolding = vehicle.countOccupants();
            String vehicleType = vehicle.getClass().getSimpleName();

            String display =
                    MessageFormat.format("{0}) Name: {1}, Type: {2}, Maximum Passengers: {3}, Currently Holding: {4}",
                        count, vehicle.name, vehicleType, maxPass, currentlyHolding );

            System.out.println(display);

            count++;
        }
        System.out.println("____________________\n");
    }

    public void showAllOccupantInfo () {

        System.out.println("\nAll Vehicle Operators And Passengers\n____________________\n");
        int count = 1;
        for ( Occupant occupant : allOccupants ) {

            String vehicleType = occupant.occupying.getClass().getSimpleName();
            String vehicleName = occupant.occupying.name;
            String role = occupant.getClass().getSimpleName();
            String display =
                    MessageFormat.format("{0}) Name: {1}, In Vehicle Type: {2}, Vehicle Name: {3}, Role: {4}",
                            count, occupant.name, vehicleType, vehicleName, role );

            System.out.println(display);

            count++;
        }
        System.out.println("____________________\n");

    }

}
