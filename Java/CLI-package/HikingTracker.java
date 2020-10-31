package com.company;

import java.util.Collection;
import java.util.List;

public class HikingTracker implements Algorithm {

    public static int[][] countingValleys(int steps, String path) {
        int elevation = 0;
        int lowestEle = 0;
        int highestEle = 0;
        int valleys = 0;
        int mountains = 0;
        int[] elevationTracker = new int[steps];

        boolean aboveSea = path.charAt(0) == 'U';
        for (int i = 0; i < steps; i++) {
            //System.out.println(path.charAt(i));
            switch (path.charAt(i)) {
                case 'D':

                    if (
                        i - 1 > 0 && path.charAt(i - 1) == 'D'
                        || i == 0 && path.charAt(i + 1) == 'D'
                        || i == 1 && path.charAt(0) == 'D'
                    ) {
                        elevation--;
                    }

                    if (elevation < lowestEle)
                        lowestEle = elevation;

                    if (aboveSea && elevation == 0) {
                        mountains++;
                        aboveSea = false;
                        System.out.println(i + " mount");

                    }

                    break;
                case 'U':
                    //System.out.println("Going up!");
                    if (
                        i - 1 > 0 && path.charAt(i - 1) == 'U'
                        || i == 0 && path.charAt(i + 1) == 'U'
                        || i == 1 && path.charAt(0) == 'U'
                    ) {
                        elevation++;
                    }

                    if (elevation > highestEle)
                        highestEle = elevation;

                    if (!aboveSea && elevation == -2) {
                        valleys++;
                        aboveSea = true;
                        System.out.println(i + " valley");
                    }

                    break;
                default:
                    System.out.println("Invalid Input...");
                    break;
            }

            elevationTracker[i] = elevation;

            if (i == steps-1) {
                if (path.charAt(i) == 'D')
                    elevation--;
                else
                    elevation++;
            }
        }


        int[][] results = {{valleys, mountains, elevation, lowestEle, highestEle}, elevationTracker };

        return results;
    }

    public static void showHikeRoute( int low, int high, String convertedPath, int[] elevation) {

        for (int i = high; i >= low; i--) {
            int curElev = i;
            for (int j = 0; j < convertedPath.length(); j++) {
                if ( elevation[j] == curElev) {
                    System.out.print(convertedPath.charAt(j));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void run() {
        printWelcomeMsg();

        System.out.println("To represent up in elevation use U\nTo represent down in elevation use D\n");

        String path = "DDUUDDUDUUUD";//CLI.stringQuestion("Enter a string to represent the terrains topography");

        path = path.toUpperCase().replaceAll("[^UD]","");

        int steps = path.length();

        int[][] allResults = countingValleys(steps, path);

        int[] results = allResults[0];
        int[] elevationData = allResults[1];

        String valleyMsg = results[0] + (results[0] == 1 ? " valley, " : " valleys, ");
        String mountainMsg = results[1] + (results[1] == 1 ? " mountain, " : " mountains, ");
        String finalMessage = "\nThe Hiker traversed " + valleyMsg + mountainMsg + "with a final elevation of " + results[2] + " units.\n" ;

        System.out.println(finalMessage);

        boolean showGraphic = true;//CLI.yesOrNo("\nWould you like to see a graphical depiction of the terrain hiked?");

        if (showGraphic) {
            String convertedPath = path.replaceAll("U","/").replaceAll("D", "\\\\");
//            System.out.println(path + "\n" + convertedPath);
            showHikeRoute( results[3], results[4], convertedPath, elevationData);
        } else {
            System.out.println("Okay, retuning to main menu!");
        }
    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nHIKE TRACKER\n_____________________________\n\n");
    }
}

