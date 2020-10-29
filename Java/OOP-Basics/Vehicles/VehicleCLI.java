package com.company;

public class VehicleCLI {

    static public Vehicle createVehicle() {
        String question = "\nWould you like to create a...\n1) Land Vehicle\n2) Air Vehicle\n3) Water Vehicle\n4) Cancel Creation Process\nInput: ";
        int type = CLI.numberByteQuestion(question, 1, 4);

        switch (type) {
            case 1:
                return createLandVehicle();
            case 2:
                return createAirVehicle();
            case 3:
                return createWaterVehicle();
            case 4:
                return null;
            default:
                System.out.println("Something went wrong, vehicle type out of range.");
                return null;
        }
    }

    static private Landcraft createLandVehicle() {

        String question = "\nWould you like to create a...\n1) Sedan\n2) Truck\n3) Sports Car\n4) Cancel Creation Process\nInput: ";
        int type = CLI.numberByteQuestion(question, 1, 4);

        if (type == 4) return null;

        String nameQuestion = "\nWhat would you like to call it?\nName: ";
        String name = CLI.stringQuestion(nameQuestion);

        switch (type) {
            case 1:
                return new Sedan(name);
            case 2:
                return new Truck(name);
            case 3:
                return new SportsCar(name);
            default:
                System.out.println("Something went wrong, vehicle type out of range.");
                return null;
        }
    }

    static private Aircraft createAirVehicle() {

        String question = "\nWould you like to create a...\n1) Commercial Plane\n2) Private Jet\n3) Helicopter\n4) Cancel Creation Process\nInput: ";
        int type = CLI.numberByteQuestion(question, 1, 4);

        if (type == 4) return null;

        String nameQuestion = "\nWhat would you like to call it?\nName: ";
        String name = CLI.stringQuestion(nameQuestion);

        switch (type) {
            case 1:
                return new CommercialPlane(name);
            case 2:
                return new PrivateJet(name);
            case 3:
                return new Helicopter(name);
            default:
                System.out.println("Something went wrong, vehicle type out of range.");
                return null;
        }
    }

    static private Watercraft createWaterVehicle() {

        String question = "\nWould you like to create a...\n1) Motor Boat\n2) Canoe\n3) Yacht\n4) Cancel Creation Process\nInput: ";
        int type = CLI.numberByteQuestion(question, 1, 4);

        if (type == 4) return null;

        String nameQuestion = "\nWhat would you like to call it?\nName: ";
        String name = CLI.stringQuestion(nameQuestion);

        switch (type) {
            case 1:
                return new MotorBoat(name);
            case 2:
                return new Canoe(name);
            case 3:
                return new Yacht(name);
            default:
                System.out.println("Something went wrong, vehicle type out of range.");
                return null;
        }
    }

}
