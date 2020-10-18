package com.astralprojection;

import java.text.MessageFormat;
import java.util.Scanner;

public class MortgageInterface {

    /*
        Principal: how much of a loan
        Annual Interest: percentage each year
        Period (Years taken as months): how long to pay off loan
    */
    //CONSTANTS
    final static int
            PRINCIPLE_MIN = 500,
            PRINCIPLE_MAX = 1000000,
            INTEREST_MIN = 1,
            INTEREST_MAX = 100,
            PERIOD_MIN = 1,
            PERIOD_MAX = 100;

    public static MortgageAccount createAccount() {

        float inputPrinciple = MortgageInterface.askPrinciple();
        float inputInterest = MortgageInterface.askInterest();
        byte inputPeriod = (byte) MortgageInterface.askPeriod();

        return new MortgageAccount(inputPrinciple, inputInterest, inputPeriod);
    }

    private static float askPrinciple() {
        String principleQues = MessageFormat.format("How much do you want to take out on your loan? (${0} - {1})\nUSD: $", PRINCIPLE_MIN, PRINCIPLE_MAX);
        float princeAmount = MortgageInterface.numberQuestion( principleQues, PRINCIPLE_MIN, PRINCIPLE_MAX);
        return princeAmount;
    }

    private static float askPeriod() {
        String periodQuestion = MessageFormat.format("\nIn How many years will you repay the loan? ({0-{1})\nYears: ", PERIOD_MIN, PERIOD_MAX);
        float periodInYears = MortgageInterface.numberQuestion( periodQuestion, PRINCIPLE_MIN, PRINCIPLE_MAX);
        return periodInYears;
    }

    private static float askInterest() {
        String interestQues = MessageFormat.format("\nWhat is the yearly interest rate on your loan? ({0} - {1})\nPercent: ", INTEREST_MIN, INTEREST_MAX);
        float interestAmount = MortgageInterface.numberQuestion( interestQues, INTEREST_MIN, INTEREST_MAX);
        return interestAmount;
    }

    private static float numberQuestion(String question, int min, int max) {
        float inputValue = 0;
        final Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.print(question);
                inputValue = scanner.nextFloat();
                if (inputValue >= min && inputValue <= max) {
                    break;
                }
                System.out.print(MessageFormat.format("\nWARNING\nYou did not enter a number in the range of {0} to {1}\n\n", min, max));
            }
            return inputValue;
        } catch (Exception e) {
            System.out.println("\nYou must correct data types");
            return numberQuestion(question, min, max);
        }
    };

}
