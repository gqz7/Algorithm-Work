package com.astralprojection;

import java.text.NumberFormat;
import java.util.Scanner;
import java.text.MessageFormat;

public class Main {
    //CONSTANTS
    final static int MONTHS_IN_YEAR = 12, PERCENT = 100;

    public static void main(String[] args) {
        
    }
    
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

    
}