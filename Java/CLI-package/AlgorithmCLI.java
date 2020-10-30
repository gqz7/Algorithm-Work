package com.company;

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

    private static void algorithmSelection() {

        String question = "\n--------------------\nAlgorithm Selection\n____________________\nMake a choice...\n1) Factorial\n2) Hike Tracker\n3) Breaking Records\n4) Not Far From The Tree\n5) Back To Main Menu";
        int selection = CLI.numberIntQuestion(question, 1, 5);

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
                System.out.println("\nHeading back to main menu...\n");
                break;
            default:
                System.out.println("Something went wrong, input out of bounds");
                break;
        }

        mainMenu();

    }

}
