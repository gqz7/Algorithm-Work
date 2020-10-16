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
        try {

            //CONTANTS
            final int MONTHS_IN_YEAR = 12, PERCENT = 100;
            final Scanner scanner = new Scanner(System.in);
            
            //VALUES THAT WILL BE SET BY USER INPUT
            //Principal is the total loan in $USD
                float principal = 0;
            //Number of months the loan is being taken out
                float months  = 0;
            //Percentage is the interest rate on each 12 month period
                float percentage = 0;

            //GET INPUT FOR PRINCIPAL/LOAN AMMOUNT
            while (principal < 500 || principal >10000000) {

                System.out.print("How much do you want to take out on your loan? ($500 - 10,000,000)\nUSD: $");
                principal = scanner.nextFloat();
                if (principal < 500 || principal >10000000) {
                     System.out.print("\nEnter a number in the range of 500 to 10,000,000\n");
                }
            }

            //GET INPUT FOR PERCENTAGE/INTEREST RATE
            while (percentage < 1 || percentage > 100) {
                System.out.print("\nWhat is the yearly interest rate on your loan? (1 - 100)\nPercent: ");
                percentage = scanner.nextFloat();
                if (principal < 1 || principal > 100) {
                     System.out.print("\nEnter a number in the range of 1 to 100\n");
                }
            }

            //GET INPUT FOR MONTHS
            while (months < 1 || months > 700) {
                System.out.print("\nHow many months until you repay the loan? (1-700)\nMonths: ");
                months = scanner.nextFloat();
                if (principal < 1 || principal > 700) {
                     System.out.print("\nEnter a number in the range of 1 to 700\n");
                }

            }

            //CALCULATE MORTGAGE
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