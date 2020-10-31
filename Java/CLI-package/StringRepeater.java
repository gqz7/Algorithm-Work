package com.company;

public class StringRepeater implements Algorithm {
    @Override
    public void run() {
        System.out.println("\nYou will first enter a string, then the number of times you want the string to repeat\nThen the repeated string will output\n\n");

        String orgStr = CLI.stringQuestion("Enter an string to be repeated");
        String repeatedStr = "";
        String repeatQuestion = "Enter how many times you want the string to be repeated";
        int repeatTimes = CLI.numberIntQuestion(repeatQuestion, 1, 1000);
        for ( int i = 0; i < repeatTimes; i++) {
            repeatedStr += orgStr;
        }
        System.out.println("\nYour Repeated String Is: \n\n" + repeatedStr);

    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nSTRING REPEAT\n_____________________________\n\n");
    }
}
