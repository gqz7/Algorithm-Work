package com.company;

import java.text.MessageFormat;

public class StringReverser implements Algorithm {

    public static String stringReverse (String normalString) {
        String reversedString = "";
        int strLen = normalString.length()-1;
        for (int i = strLen; i >= 0 ; i--) {
            //  System.out.println(normalString.charAt(i));
            reversedString += normalString.charAt(i);
        }
        return reversedString;
    }

    @Override
    public void run() {
        String reverserQuestion = "\nEnter A String/Sentence And It Will Be Reversed For You";
        String normalString = CLI.stringQuestion(reverserQuestion);
        String reversedString = stringReverse(normalString);
        String finalMsg = MessageFormat.format("\nYour Original String:\n{0}\n\nYour String Reversed:\n{1}", normalString, reversedString);

        System.out.println(finalMsg);
    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nSTRING REVERSER\n_____________________________\n\n");
    }
}
