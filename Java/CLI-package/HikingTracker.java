package com.company;

public class HikingTracker implements Algorithm {

    public static int[] countingValleys(int steps, String path) {
        int elevation = 0;
        int valleys = 0;
        int mountains = 0;
        boolean aboveSea = false;
        for (int i = 0; i < steps; i++) {
            //System.out.println(path.charAt(i));
            switch (path.charAt(i)) {
                case 'D':
                    //System.out.println("Going down!");

                    if (aboveSea == true && elevation == 1) {
                        mountains++;
                        aboveSea = false;
                    }
                    elevation--;

                    break;
                case 'U':
                    //System.out.println("Going up!");
                    if (aboveSea == false && elevation == -1) {
                        valleys++;
                        aboveSea = true;
                    }
                    elevation++;

                    break;
                default:
                    //System.out.println("Invalid Input...");
                    break;
            }
        }

        int[] results = {valleys, mountains, elevation};

        return results;
    }

    @Override
    public void run() {
        printWelcomeMsg();

        System.out.println("To represent up in elevation use U\nTo represent down in elevation use D\n");

        String path = CLI.stringQuestion("Enter a string to represent the terrains topography");

        int steps = path.length();

        int[] results = countingValleys(steps, path);

        String valleyMsg = results[0] + (results[0] == 1 ? " valley, " : " valleys, ");
        String mountainMsg = results[1] + (results[1] == 1 ? " mountain, " : " mountains, ");
        String finalMessage = "The Hiker traversed " + valleyMsg + mountainMsg + "with a final elevation of " + results[2] + " units." ;

        System.out.println(finalMessage);
    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nHIKE TRACKER\n_____________________________\n\n");
    }
}

