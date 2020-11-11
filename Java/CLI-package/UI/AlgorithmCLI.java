package com.company.UI;

import com.company.AlgorithmLogic.*;

public class AlgorithmCLI {

    public static void mainMenu() {
        String question = "\nMAIN MENU\n-------------\nWould you like to...\n1) Use An Algorithm\n2) Exit the Program";
        int selection = CLI.numberIntQuestion(question, 1, 2);

        switch (selection) {
            case 1:
                algorithmSelection();
                break;
            case 2:
                System.out.println("\nThank you for using this program, now exiting...\n");
                break;
            default:
                System.out.println("Something went wrong, input out of bounds");
                mainMenu();
                break;
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
        opt += "\n7) Randomizer";
        opt += "\n8) Text Calculator";
        opt += "\n9) Back To Main Menu";

        return opt;

}

    private static void algorithmSelection() {

        String question = listOptions();
        int selection = CLI.numberIntQuestion(question, 1, 9);

        switch (selection) {


            case 1:
                new Factorial().run();
                break;
            case 2:
                new HikingTracker().run();
                break;
            case 3:
                new BreakingRecords().run();
                break;
            case 4:
                new FarFromTheTree().run();
                break;
            case 5:
                new FibonacciSequence().run();
                break;
            case 6:
                new StringConverter().run();
                break;
            case 7:
                new Randomizer().run();
                break;
            case 8:
                new TextCalc().run();
                break;
            case 9:
                System.out.println("\nHeading back to main menu...\n");
                break;
            default:
                System.out.println("Something went wrong, input out of bounds");
                break;
        }

        mainMenu();

    }

}
