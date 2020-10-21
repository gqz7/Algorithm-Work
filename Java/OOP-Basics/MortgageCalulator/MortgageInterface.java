package com.astralprojection;

import java.text.MessageFormat;
import java.util.Scanner;

public class MortgageInterface {
    //CONSTANTS
    final static int
            PRINCIPLE_MIN = 500,
            PRINCIPLE_MAX = 1000000,
            INTEREST_MIN = 1,
            INTEREST_MAX = 100,
            PERIOD_MIN = 1,
            PERIOD_MAX = 100;

    public static MortgageAccount createAccount() {

        String accountName = MortgageInterface.askName();
        float inputPrinciple = MortgageInterface.askPrinciple();
        float inputInterest = MortgageInterface.askInterest();
        byte inputPeriod = MortgageInterface.askPeriod();

        return new MortgageAccount(accountName, inputPrinciple, inputInterest, inputPeriod);
    }

    private static float askPrinciple() {
        String principleQues = MessageFormat.format("How much do you want to take out on your loan? (${0} - {1})\nUSD: $", PRINCIPLE_MIN, PRINCIPLE_MAX);
        float princeAmount = CommandLineInterface.numberFloatQuestion( principleQues, PRINCIPLE_MIN, PRINCIPLE_MAX);
        return princeAmount;
    }

    private static byte askPeriod() {
        String periodQuestion = MessageFormat.format("\nIn How many years will you repay the loan? ({0}-{1})\nYears: ", PERIOD_MIN, PERIOD_MAX);
        byte periodInYears = CommandLineInterface.numberByteQuestion( periodQuestion, PERIOD_MIN, PERIOD_MAX);
        return periodInYears;
    }

    private static float askInterest() {
        String interestQues = MessageFormat.format("\nWhat is the yearly interest rate on your loan? ({0} - {1})\nPercent: ", INTEREST_MIN, INTEREST_MAX);
        float interestAmount = CommandLineInterface.numberFloatQuestion( interestQues, INTEREST_MIN, INTEREST_MAX);
        return interestAmount;
    }

    private static String askName() {
        String nameQues = "Please Enter A Name For This Mortgage Account.\nName: ";
        String accountName = CommandLineInterface.stringQuestion( nameQues );
        return  accountName;
    }

}
