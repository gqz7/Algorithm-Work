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
        final Scanner scanner = new Scanner(System.in);
        final int MONTHS_IN_YEAR = 12, PERCENT = 100;

        //Principal is the total loan in $USD
        System.out.print("How much do you want to take out on your loan?\nUSD: $");
        float principal = scanner.nextFloat();

        System.out.print("\nWhat is the yearly interest rate on your loan?\nPercent: ");
        //Percentage is the interest rate on each 12 month period
        float percentage = scanner.nextFloat();

        System.out.print("\nHow many months until you repay the loan?\nMonths: ");
        //Period will be the number of months the loan is being taken out
        float months  = scanner.nextFloat();

        float numberOfPayments = months*MONTHS_IN_YEAR;
        float rate = percentage/PERCENT/MONTHS_IN_YEAR;

        float mortgage = (float) (principal * rate * Math.pow(1+rate, numberOfPayments)/(Math.pow(1+rate, numberOfPayments)-1) );

        String finalMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("\nYour annual mortgage will be: " + finalMortgage);

    }
}