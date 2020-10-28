package com.company;

public class VehicleCLI {

    static public Vehicle createVehicle() {
        String question = "\nWould you like to create a...\n1) Land Vehicle\n2) Air Vehicle\n3) Water Vehicle\n4) Cancel Creation Process\nInput: ";
        int type = CLI.numberByteQuestion(question, 1, 4);

        switch (type) {
            case 1:
                return createLandVehicle();
            case 2:
                return createWaterVehicle();
            case 3:
                return createAirVehicle();
            case 4:
                return null;
            default:
                System.out.println("Something went wrong, vehicle type out of range.");
                return null;
        }
    }

    static private Landcraft createLandVehicle() {
        return new Sedan("Honda");
    }

    static private Aircraft createAirVehicle() {
        return new PassengerPlane("747", 300);
    }

    static private Watercraft createWaterVehicle() {
        return new MotorBoat("BoatyMcBoatFace", 20, 550);
    }

}
