package com.company;

public class HikingTracker implements Algorithm {

    public static int[][] calculateHikeVisualData(int steps, String path) {
        int elevation = 0;
        int lowestEle = 0;
        int highestEle = 0;
        int[] elevationTracker = new int[steps];

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

                    break;
                default:
                    System.out.println("Invalid Input...");
                    break;
            }

            elevationTracker[i] = elevation;

        }

        int[][] results = {{ lowestEle, highestEle, elevation }, elevationTracker };

        return results;
    }

    public static void showHikeRoute( int low, int high, int endElevation, String convertedPath, int[] elevation) {

        for (int i = high; i >= low; i--) {
            int curElev = i;
            if (i == 0)
                System.out.print("_");
            else
                System.out.print(" ");
            for (int j = 0; j < convertedPath.length(); j++) {
                if ( elevation[j] == curElev) {
                    System.out.print(convertedPath.charAt(j));
                } else {
                    System.out.print(" ");
                }
            }
            if (i == endElevation)
                System.out.print("_");
            else
                System.out.print(" ");
            System.out.println();
        }
    }

    private int[] calculateValleysMountains(int steps, String path) {
        return new int[] {0, 0, 0};
    }

    @Override
    public void run() {
        printWelcomeMsg();

        System.out.println("To represent up in elevation use U\nTo represent down in elevation use D\n");

        String path = "DDUUDDUDUUUD";//CLI.stringQuestion("Enter a string to represent the terrains topography");

        path = path.toUpperCase().replaceAll("[^UD]","");

        int steps = path.length();

        int[] hikeData = calculateValleysMountains(steps, path);

        String valleyMsg = hikeData[0] + (hikeData[0] == 1 ? " valley, " : " valleys, ");
        String mountainMsg = hikeData[1] + (hikeData[1] == 1 ? " mountain, " : " mountains, ");
        String finalMessage = "\nThe Hiker traversed " + valleyMsg + mountainMsg + "with a final elevation of " + hikeData[2] + " units.\n" ;

        System.out.println(finalMessage);

        boolean showGraphic = true;//CLI.yesOrNo("\nWould you like to see a graphical depiction of the terrain hiked?");

        if (showGraphic) {

            int[][] allResults = calculateHikeVisualData(steps, path);

            int[] results = allResults[0];
            int[] elevationData = allResults[1];

            String convertedPath = path.replaceAll("U","/").replaceAll("D", "\\\\");
//            System.out.println(path + "\n" + convertedPath);
            showHikeRoute( results[0], results[1], results[2], convertedPath, elevationData);
        } else {
            System.out.println("Okay, retuning to main menu!");
        }
    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nHIKE TRACKER\n_____________________________\n\n");
    }
}

