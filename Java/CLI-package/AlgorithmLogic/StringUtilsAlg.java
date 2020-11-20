package com.company.AlgorithmLogic;

import com.company.UI.CLI;

import java.text.MessageFormat;

public class StringUtilsAlg implements Algorithm {


    private static final String START_QUESTION = "Pick A Utility To Use";
    private static final String FINAL_MESSAGE = "\nEnding Utility ";
    private static final String INPUT_MSG = "\nEnter a string to be analyzed";
    private static final String SELECTION_MSG = "What would you like to know about your input?\n1) Number of Characters\n2) OR Return Back To Main Menu";
    private static final int NUMBER_OF_OPTIONS = 2;
    @Override
    public void run () {

        printWelcomeMsg();

        String inputStr = CLI.stringQuestion(INPUT_MSG);

        while (true) {
            int caseOption = CLI.numberIntQuestion(SELECTION_MSG, 1, NUMBER_OF_OPTIONS);

            if (caseOption == NUMBER_OF_OPTIONS) {
                System.out.println("Exiting String Utility...");
                break;
            }

            switch (caseOption) {
                case 1:
                    int charsInStr = countChars(inputStr);
                    System.out.println("Counting...\nNumber of characters: " + charsInStr);

                    break;
                default:
                    System.out.println("An invalid input was given, return to main menu...");
            }

        }

    }

    private int countChars(String inputStr) {
        return inputStr.length();
    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nSTRING UTILITY\n_____________________________\n\n");
    }
}
