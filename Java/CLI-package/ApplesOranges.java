package com.company;

import java.text.MessageFormat;
import java.util.*;

public class ApplesOranges implements Algorithm {

    static void countApplesAndOranges(int houseStart, int houseEnd, int appleTreePos, int orangeTreePos, int[] apples, int[] oranges) {

        String allVars = MessageFormat.format(
                "StartHouse: {0}\nEndHouse: {1}\nAT: {2}\nOT: {3}\nApples: {4}\nOranges: {5}",
                houseStart, houseEnd, appleTreePos, orangeTreePos, Arrays.toString(apples), Arrays.toString(oranges) );
//        System.out.println( allVars );

        int appleTotal = 0;
        int orangeTotal = 0;

        for (int i = 0; i < apples.length; i++) {
            int distanceFromTree = apples[i];
            int appleAbsPos = appleTreePos + distanceFromTree;

            if ( appleAbsPos >= houseStart && appleAbsPos <= houseEnd) {
                appleTotal++;
            }
        }

        for (int distanceFromTree : oranges) {
            int orangeAbsPos = orangeTreePos + distanceFromTree;

            if ( orangeAbsPos >= houseStart && orangeAbsPos <= houseEnd ) {
                orangeTotal++;
            }

        }

        System.out.println("\n" + appleTotal + " apples fell on the house,\nand" + orangeTotal + " oranges fell on the house.");

    }

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {

        System.out.println("Fruits are falling everywhere!\nYou will enter in the 1D dimensions of the house");
        System.out.println("Where the fruit trees are, and how far the fruits are falling from the tree.");
        System.out.println("Then we will calculate how many fruits fell on the house.\n\n");

        int houseStart = CLI.numberIntQuestion("Where is the house's left side?", 0, 100);

        int houseEnd = CLI.numberIntQuestion("Where is the house's left side?", houseStart+1, houseStart+100);

        int appleTreePos = CLI.numberIntQuestion("Where is the apple tree?", -1000, 1000);

        int orangeTreePos = CLI.numberIntQuestion("Where is the orange tree?", -1000, 1000);


        int totalApples = CLI.numberIntQuestion("How many apples fell?", 1, 77);
        int totalOranges = CLI.numberIntQuestion("How many oranges fell?", 1, 77);

        int[] apples = new int[totalApples];
        int[] oranges = new int[totalOranges];

        for (int i = 1; i <= totalApples; i++) {
            int applesItem = CLI.numberIntQuestion("How far did apple #" + i + " fall from the tree?", -100, 100);
            apples[i] = applesItem;
        }

        for (int i = 1; i <= totalOranges; i++) {
            int orangeItem = CLI.numberIntQuestion("How far did orange #" + i + " fall from the tree?", -100, 100);
            oranges[i] = orangeItem;
        }

        countApplesAndOranges(houseStart, houseEnd, appleTreePos, orangeTreePos, apples, oranges);

        scanner.close();
    }

}