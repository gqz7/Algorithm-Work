package com.company;

public class SimCLI {

    private static EntityManager Simulation;

    public static void startSimulation() {
        Simulation = new EntityManager();
        mainMenu();
    }

    public static void mainMenu() {
        String question = "Would you like to...\n1) Create A New Vehicle\n2) Exit the Program\nInput: ";
        int selection = CLI.numberIntQuestion(question, 1, 2);

        switch (selection) {
            case 1:
                SimCLI.vehicleInitialization();
                break;
            case 2:
                System.out.println("\nThank you for using this program, now exiting...\n");
                return;
            default:
                System.out.println("Something went wrong, input out of bounds");
                mainMenu();
                return;
        }

    }

    private static void vehicleInitialization() {
        var newVehicle = VehicleCLI.createVehicle();
        if (newVehicle != null) {
            System.out.println("Adding Vehicle To Simulation");
        } else {
            System.out.println("Canceled Vehicle Creation");
        }
    }
}
