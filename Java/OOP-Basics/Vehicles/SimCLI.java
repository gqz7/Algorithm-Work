package com.company;

public class SimCLI {

    private static EntityManager Simulation;

    public static void startSimulation() {
        Simulation = new EntityManager();
        mainMenu();
    }

    public static void mainMenu() {

        String question = "\nMAIN MENU\n__________\nWould you like to...\n1) Create A New Vehicle\n2) View Simulation Entities\n3) Exit the Program\nInput: ";
        int selection = CLI.numberIntQuestion(question, 1, 3);

        switch (selection) {
            case 1:
                SimCLI.vehicleInitialization();
                break;
            case 2:
                storageView();
                break;
            case 3:
                System.out.println("\nThank you for using this program, now exiting...\n");
                break;
            default:
                System.out.println("Something went wrong, input out of bounds");
                mainMenu();
                break;
        }
    }

    private static void storageView() {
        String question = "\nWould you like to...\n1) View All Vehicles\n2) View All Occupants\n3) Return Back To Main Menu\nInput: ";
        int selection = CLI.numberIntQuestion(question, 1, 3);
        switch (selection) {
            case 1:
                Simulation.showAllVehicleInfo();
                break;
            case 2:
                Simulation.showAllOccupantInfo();
                break;
            case 3:
                mainMenu();
                return;
            default:
                System.out.println("Something went wrong, input out of bounds");
                break;
        }

        storageView();

    }

    private static void vehicleInitialization() {
        var newVehicle = VehicleCLI.createVehicle();
        if (newVehicle != null) {
            Simulation.addVehicle( newVehicle );
            System.out.println("\nAdding Vehicle To Simulation...\n");
            occupantInquire( newVehicle );
        } else {
            System.out.println("\nCanceled Vehicle Creation...");
        }
        mainMenu();
    }

    private static void occupantInquire( Vehicle newVehicle ) {
        String question = "Would you like to add occupants to your newly created vehicle\n1) Yes\n2) No\nInput: ";
        int selection = CLI.numberIntQuestion(question, 1, 2);
        switch (selection) {
            case 1:

                int maxPassengers = newVehicle.getMaxPassengers();

                String passengerString = maxPassengers + ( maxPassengers == 1 ? " passenger," : " passengers," );
                String passengersQuestion = "\nThe new vehicle can hold " + passengerString + " enter how many you would like to add now\nInt: ";

                int numberOfPassengersToAdd = CLI.numberIntQuestion(passengersQuestion, 1, maxPassengers );

                OccupantCLI.addOccupantsToVehicle( newVehicle, numberOfPassengersToAdd);

                break;
            case 2:
                System.out.println("\nVehicle is being placed in storage\nReturning to main menu...\n");
                break;
            default:
                System.out.println("Something went wrong, input out of bounds");
                break;
        }
    }

}
