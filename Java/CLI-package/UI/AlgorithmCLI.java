package com.company.UI;

import com.company.AlgorithmLogic.*;

public class AlgorithmCLI {

    public static void mainMenu() {
        String question = "\nMAIN MENU\n-------------\nWould you like to...\n1) Use An Algorithm\n2) Exit the Program";
        int selection = CLI.numberIntQuestion(question, 1, 2);

        switch (selection) {
            case 1 -> algorithmSelection();
            case 2 -> System.out.println("\nThank you for using this program, now exiting...\n");
            default -> {
                System.out.println("Something went wrong, input out of bounds");
                mainMenu();
            }
        }
    }

    private static String listOptions() {
        String opt = "\n--------------------\nAlgorithm Selection\n____________________\nMake a choice...";
        opt += "\n1) Factorial";
        opt += "\n2) Hike Tracker";
        opt += "\n3) Breaking Records";
        opt += "\n4) Not Far From The Tree";
        opt += "\n5) Fibonacci Sequence";
        opt += "\n6) String Converter";
        opt += "\n7) String Utility";
        opt += "\n8) Randomizer";
        opt += "\n9) Text Calculator";
        opt += "\n10) Back To Main Menu";

        return opt;

}

    private static void algorithmSelection() {

        String question = listOptions();
        int selection = CLI.numberIntQuestion(question, 1, 10);

        switch (selection) {
            case 1 -> new Factorial().run();
            case 2 -> new HikingTracker().run();
            case 3 -> new BreakingRecords().run();
            case 4 -> new FarFromTheTree().run();
            case 5 -> new FibonacciSequence().run();
            case 6 -> new StringConverter().run();
            case 7 -> new StringUtilsAlg().run();
            case 8 -> new Randomizer().run();
            case 9 -> new TextCalc().run();
            case 10 -> System.out.println("\nHeading back to main menu...\n");
            default -> System.out.println("Something went wrong, input out of bounds");
        }

        mainMenu();

    }

}
