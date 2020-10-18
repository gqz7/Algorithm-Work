package com.astralprojection;

import java.util.Scanner;

public class Main {
    /*
      User enters number and gets the factorial of it
     */
    public static void main(String[] args) {

        try {
            String titleCaseQuestion = "Enter an sentence to be Title Cased\nString: ";
            String originalStr = takeUserString(titleCaseQuestion);
            String titleCased = titleCaseString(originalStr);
            System.out.println("\nYour Title Cased Sentence Is: \n" + titleCased);
        }catch (Exception e) {
            System.out.println("An unexpected error occured!");
        }

    }

    public static String titleCaseString (String inStr ) {
        String titleCased = "";
        String originalStr[]= inStr.split(" ");

        for ( int i = 0; i < originalStr.length; i++) {
            String word = originalStr[i];
            String titleCasedWord = Character.toUpperCase( word.charAt(0) ) + word.substring(1).toLowerCase();
            // System.out.println(titleCasedWord);
            if (i != 0) {
                titleCased += " ";
            }
            titleCased += titleCasedWord;
        }
        return titleCased;
    }

    public static String takeUserString (String question) {
        final Scanner scanner = new Scanner(System.in);

        String inputStr;

        while (true) {
            System.out.print(question);

            inputStr = scanner.nextLine();
            if (!inputStr.strip().equals("")) {
                break;
            }
            System.out.println("\nWARNING: You entered nothing.\n");
        }
        return inputStr;
    }

}