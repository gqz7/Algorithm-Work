package com.company;

public class StringCaseConverter implements Algorithm  {
    @Override
    public void run () {
        printWelcomeMsg();

        String selectionMsg = "How would you like to case your string\n1) Title Case\n2) spinal-case\n3) OR Return Back To Main Menu";
        String inputMsg = "\nEnter a string to be transformed";

        int exitOption = 3;

        int caseOption = CLI.numberIntQuestion(selectionMsg, 1, exitOption);

        if (caseOption == exitOption) return;

        String inputStr = CLI.stringQuestion(inputMsg);

        switch (caseOption) {
            case 1:
                String titleCased = titleCaseString(inputStr);
                System.out.println("\nTITLE CASING YOUR INPUT...\n");
                System.out.println("Your title cased string is:\n\n" + titleCased);

                break;
            case 2:
                String spinalCased = spinalCaseString(inputStr);
                System.out.println("\nSPINAL CASING YOUR INPUT...\n");
                System.out.println("Your spinal cased string is:\n\n" + spinalCased);

                break;
            default:
                System.out.println("An invalid input was given, return to main menu...");
        }
    }

    public static String titleCaseString (String inStr ) {
        StringBuilder titleCased = new StringBuilder();
        String[] originalStr= inStr.split(" ");

        for ( int i = 0; i < originalStr.length; i++) {
            String word = originalStr[i];
            String titleCasedWord = Character.toUpperCase( word.charAt(0) ) + word.substring(1).toLowerCase();
            // System.out.println(titleCasedWord);
            if (i != 0) {
                titleCased.append(" ");
            }
            titleCased.append(titleCasedWord);
        }
        return titleCased.toString();
    }

    public static String spinalCaseString (String inStr ) {
        StringBuilder spinalCased = new StringBuilder();

        //replace all the uneven amounts of space with a single space, then split into array for minipulation
        String[] originalStr = inStr.replaceAll("\\s+", " ").split(" ");

        for ( int i = 0; i < originalStr.length; i++) {
            String word = originalStr[i];
            String spinalCasedWord = word.toLowerCase();

            if (i != 0) {
                spinalCased.append("-");
            }
            spinalCased.append(spinalCasedWord);
        }
        String finalOutput = spinalCased.toString();
        return finalOutput;
    }


    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nSTRING CASING\n_____________________________\n\n");
    }
}
