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

        try {
            //Principal is the total loan in $USD
            float principal = 0;
            while (principal < 500 || principal >10000000) {

                System.out.print("How much do you want to take out on your loan? ($500 - 10,000,000)\nUSD: $");
                principal = scanner.nextFloat();
                if (principal < 500 || principal >10000000) {
                     System.out.print("\nEnter a number in the range of 500 to 10,000,000\n");
                }
            }
            float percentage = 0;
            while (percentage < 1 || percentage > 100) {
                System.out.print("\nWhat is the yearly interest rate on your loan? (1 - 100)\nPercent: ");
                //Percentage is the interest rate on each 12 month period
                percentage = scanner.nextFloat();
                if (principal < 1 || principal > 100) {
                     System.out.print("\nEnter a number in the range of 1 to 100\n");
                }
            }
            float months  = 0;
            while (months < 1 || months > 700) {
                System.out.print("\nHow many months until you repay the loan? (1-700)\nMonths: ");
                //Period will be the number of months the loan is being taken out
                months = scanner.nextFloat();
                if (principal < 1 || principal > 700) {
                     System.out.print("\nEnter a number in the range of 1 to 700\n");
                }

            }

            float numberOfPayments = months*MONTHS_IN_YEAR;
            float rate = percentage/PERCENT/MONTHS_IN_YEAR;

            float mortgage = (float) (principal * rate * Math.pow(1+rate, numberOfPayments)/(Math.pow(1+rate, numberOfPayments)-1) );

            String finalMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

            System.out.println("\nYour annual mortgage will be: " + finalMortgage);
        } catch (Exception e) {
            System.out.println("You must correct data types");
        }

    }
}