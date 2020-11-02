package com.company;

public class StringConverter implements Algorithm  {
    @Override
    public void run () {
        printWelcomeMsg();

        String selectionMsg = "How would you like to modify your string\n1) Title Case\n2) spinal-case\n3) Reverser\n4) Repeater\n5) OR Return Back To Main Menu";
        String inputMsg = "\nEnter a string to be transformed";

        int exitOption = 5;

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
            case 3:
                String reversed = stringReverser(inputStr);
                System.out.println("\nREVERSING YOUR INPUT...\n");
                System.out.println("Your reversed string is:\n\n" + reversed);

                break;
            case 4:

                String repeatQuestion = "Enter how many times you want the string to be repeated";
                int repeatTimes = CLI.numberIntQuestion(repeatQuestion, 1, 1000);
                String repeated = stringRepeater(inputStr, repeatTimes);
                System.out.println("\nREPEATING YOUR INPUT...\n");
                System.out.println("Your repeated string is:\n\n" + repeated);

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
            if (i != 0) {
                titleCased.append(" ");
            }
            titleCased.append(titleCasedWord);
        }
        return titleCased.toString();
    }

    public static String spinalCaseString (String inStr ) {
        StringBuilder spinalCased = new StringBuilder();
        //replace all the uneven number of concurrent spaces with a single space, then split into array for minipulation
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

    public static String stringReverser ( String inStr ) {
        String reversedString = "";
        int strLen = inStr.length()-1;
        for (int i = strLen; i >= 0 ; i--) {
            reversedString += inStr.charAt(i);
        }
        return reversedString;
    }

    private String stringRepeater(String inputStr, int repeatTimes) {
        String repeatedStr = "";
        for ( int i = 0; i < repeatTimes; i++) {
            repeatedStr += inputStr;
        }
        return repeatedStr;
    }


    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nSTRING CASING\n_____________________________\n\n");
    }
}
