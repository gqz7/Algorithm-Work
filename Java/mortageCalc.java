package com.astralprojection;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    /*
    Principal: how much of a loan
    Annual Interest: percentage each year
    Period (Years taken as months): how long to pay off loan
     */

    public static void main(String[] args) {
        collectData();
    }

    private static void collectData() {

        //GET INPUT FOR PRINCIPAL/LOAN AMMOUNT
        String principleQues = "How much do you want to take out on your loan? ($500 - 10,000,000)\nUSD: $";
        float princeAmount = askQuestion( principleQues, 500, 10000000);

        //GET INPUT FOR PERCENTAGE/INTEREST RATE
        String interestQues = "\nWhat is the yearly interest rate on your loan? (1 - 100)\nPercent: ";
        float interestAmount = askQuestion( interestQues, 1, 100);

        //GET INPUT FOR MONTHS
        String monthsQues = "\nHow many months until you repay the loan? (1-700)\nMonths: ";
        float monthsAmount = askQuestion( monthsQues, 1, 700);

        calculateMortgage(princeAmount, monthsAmount, interestAmount);
    };

    private static void calculateMortgage(float principal, float months, float percentage) {
        //CONTANTS
        final int MONTHS_IN_YEAR = 12, PERCENT = 100;

        //CALCULATE MORTGAGE
        float numberOfPayments = months*MONTHS_IN_YEAR;
        float rate = percentage/PERCENT/MONTHS_IN_YEAR;

        float mortgage = (float) (principal * rate * Math.pow(1+rate, numberOfPayments)/(Math.pow(1+rate, numberOfPayments)-1) );

        String finalMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("\nYour annual mortgage will be: " + finalMortgage);
    };

    private static float askQuestion(String question, int min, int max) {
        float inputValue = 0;
        final Scanner scanner = new Scanner(System.in);

        try {
            while (inputValue < min || inputValue > max) {
                System.out.print(question);
                inputValue = scanner.nextFloat();
                if (inputValue < min || inputValue > max) {
                    System.out.print("\nWARNING\nYou did not enter a number in the range of "+min+" to "+max+"\n\n");
                }
            }
            return inputValue;
        } catch (Exception e) {
            System.out.println("\nYou must correct data types");
            return askQuestion(question, min, max);
        }
    };
}