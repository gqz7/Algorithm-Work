package com.astralprojection;

import java.text.NumberFormat;
import java.util.Scanner;
import java.text.MessageFormat;

public class Main {
    /*
    Principal: how much of a loan
    Annual Interest: percentage each year
    Period (Years taken as months): how long to pay off loan
     */
    //CONTANTS
    final static int MONTHS_IN_YEAR = 12, PERCENT = 100;

    public static void main(String[] args) {
        mortgageCalculator();
    }

    private static void mortgageCalculator() {

        //GET INPUT FOR PRINCIPAL/LOAN AMMOUNT
        String principleQues = "How much do you want to take out on your loan? ($500 - 10,000,000)\nUSD: $";
        float princeAmount = numberQuestion( principleQues, 500, 10000000);

        //GET INPUT FOR PERCENTAGE/INTEREST RATE
        String interestQues = "\nWhat is the yearly interest rate on your loan? (1 - 100)\nPercent: ";
        float yearlyInterest = numberQuestion( interestQues, 1, 100);
        float monthlyInterest = yearlyInterest / PERCENT / MONTHS_IN_YEAR;

        //GET INPUT FOR MONTHS
        String yearsQuestion = "\nIn How many years will you repay the loan? (1-100)\nYears: ";
        float yearsAmount = numberQuestion( yearsQuestion, 1, 100);
        float totalMonths = yearsAmount*MONTHS_IN_YEAR;

        //CALCULATE MONTHLY MORTGAGE
        float monthlyMortgage = calculateMortgage(princeAmount, yearsAmount, yearlyInterest);

        //DISPLAY A PAYMENT SCHEDULE FOR USER
        displayPaymentSchedual(princeAmount, totalMonths, monthlyMortgage, monthlyInterest);
    };

    private static float calculateMortgage(float principal, float months, float percentage) {

        //CALCULATE MORTGAGE
        float numberOfPayments = months*MONTHS_IN_YEAR;
        float rate = percentage/PERCENT/MONTHS_IN_YEAR;

        float mortgage = (float) (principal * rate * Math.pow(1+rate, numberOfPayments)/(Math.pow(1+rate, numberOfPayments)-1) );

        String finalMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("\nYour annual mortgage will be: " + finalMortgage);

        return mortgage;
    };

    private static void displayPaymentSchedual(float principal, float totalMonths, float monthlyPay, float interest) {
        String lineSeparator = "_______________________________________________________________";
        String monthlyPayFormatted = NumberFormat.getCurrencyInstance().format(monthlyPay);
        System.out.println(MessageFormat.format("\nYour loan of ${0} will be paid off in {1} monthly payments of {2}\n{3}\n\n", principal, totalMonths, monthlyPayFormatted, lineSeparator));

        int currentMonth = 0;
        while (currentMonth <= totalMonths) {
            double ownedMoney = calculateBalanceOwned(principal, totalMonths, interest, currentMonth);
            String ownedMoneyFormatted = NumberFormat.getCurrencyInstance().format(ownedMoney);
            System.out.println(MessageFormat.format("Month {0}: Money Owned - {1}", currentMonth, ownedMoneyFormatted));
            currentMonth += 1;
        }
        System.out.println("\nYour debts are now paid off!");
    };

    private static double calculateBalanceOwned(float principal, float totalPayments, float interest, int currentMonth) {
        double balance = principal
                * (Math.pow( 1+interest, totalPayments ) - Math.pow( 1+interest, currentMonth ))
                / (Math.pow( 1+interest, totalPayments) - 1);
        return balance;
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