package com.company.AlgorithmLogic;

import com.company.UI.CLI;

import java.util.ArrayList;

public class Randomizer implements Algorithm {
    @Override
    public void run() {
        printWelcomeMsg();

        int numberOfElement = CLI.numberIntQuestion("How many elements will be randomized?", 2,100);
        ArrayList<String> randomList = new ArrayList<>();

        for (int i = 0; i < numberOfElement; i++) {
            String newElementQuestion = "\nEnter element #" + (i+1);
            String newElement = CLI.stringQuestion(newElementQuestion);
            randomList.add(newElement);
        }

        boolean randomizerFinished = false;
        while (!randomizerFinished) {
            int randomIndex = (int) (randomList.size() * Math.random());
            System.out.println("\nOur program randomly selected:\n\n\t" + randomList.get(randomIndex) );

            if (!CLI.yesOrNo("\nWould you like to randomize the data again?\n"))
                randomizerFinished = true;
        }

    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nRANDOMIZER\n_____________________________\n\n");
        System.out.println("You will enter a number of element to input, then a random selection will be made.\n");
    }
}
