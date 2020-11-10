package com.astralprojection.Finaces;

import java.text.MessageFormat;
import java.text.NumberFormat;

public class MortgageAccount {
    final static byte MONTHS_IN_YEAR = 12, PERCENT = 100;

    private String accountHolder;
    private float principle;
    private float yearlyInterest;
    private float monthlyInterest;
    private float monthlyMortgage;
    private byte yearPeriod;
    private short monthPeriod;
    private short monthsPaidOff;

    MortgageAccount(
            String name,
            float total,
            float interest,
            byte period
    ) {
       accountHolder = name;
       principle = total;
       yearlyInterest = interest;
       yearPeriod = period;
       monthsPaidOff = 0;

       monthlyInterest = yearlyInterest / PERCENT / MONTHS_IN_YEAR;
       monthPeriod = (short) (yearPeriod * MONTHS_IN_YEAR);

       monthlyMortgage = calculateMortgage();
    }

    private float calculateMortgage() {

        //CALCULATE MORTGAGE
        float mortgage = (float) (principle
                * monthlyInterest * Math.pow(1+monthlyInterest, monthPeriod)
                /(Math.pow(1+monthlyInterest, monthPeriod)-1) );

        //String finalMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        //System.out.println("\nYour annual mortgage will be: " + finalMortgage);

        return mortgage;
    };

    public void displayPaymentSchedule() {

        String lineSeparator = "_______________________________________________________________";
        String monthlyPayFormatted = NumberFormat.getCurrencyInstance().format(monthlyMortgage);
        System.out.println(MessageFormat.format(
                "\nThank you for using our service {0}.\nYour loan of ${1} will be paid off in {2} monthly payments of roughly {3}\n{4}\n\n",
                accountHolder,
                principle,
                monthPeriod,
                monthlyPayFormatted,
                lineSeparator

        ));
        int currentMonth = 0;
        while (currentMonth <= monthPeriod) {
            double ownedMoney = calculateBalanceOwned( currentMonth);
            String ownedMoneyFormatted = NumberFormat.getCurrencyInstance().format(ownedMoney);
            System.out.println(MessageFormat.format("Month {0}: Money Owned - {1}", currentMonth, ownedMoneyFormatted));
            currentMonth += 1;
        }
        System.out.println("\nYour debts are now paid off!");
    };

    private double calculateBalanceOwned( int currentMonth ) {
        double balance = principle
                * (Math.pow(1 + monthlyInterest, monthPeriod) - Math.pow(1 + monthlyInterest, currentMonth))
                / (Math.pow(1 + monthlyInterest, monthPeriod) - 1);
        return balance;
    }
}
