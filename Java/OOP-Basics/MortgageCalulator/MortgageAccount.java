package com.astralprojection;

import java.text.MessageFormat;
import java.text.NumberFormat;

public class MortgageAccount {
    final static byte MONTHS_IN_YEAR = 12, PERCENT = 100;

    private String accountHolder;
    private float principle;
    private float yearlyInterest;
    private float monthlyInterest;
    public float monthlyMortgage;
    private byte yearPeriod;
    private short monthPeriod;

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

       monthlyInterest = yearlyInterest / PERCENT / MONTHS_IN_YEAR;
       monthPeriod = (short) (yearPeriod * MONTHS_IN_YEAR);

       monthlyMortgage = calculateMortgage(principle, yearPeriod, yearlyInterest);
    }

    private float calculateMortgage(float principal, float months, float percentage) {

        //CALCULATE MORTGAGE
        float numberOfPayments = months*MONTHS_IN_YEAR;
        float rate = percentage/PERCENT/MONTHS_IN_YEAR;

        float mortgage = (float) (principal * rate * Math.pow(1+rate, numberOfPayments)/(Math.pow(1+rate, numberOfPayments)-1) );

        //String finalMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        //System.out.println("\nYour annual mortgage will be: " + finalMortgage);

        return mortgage;
    };

    public void displayPaymentSchedule() {

        String lineSeparator = "_______________________________________________________________";
        String monthlyPayFormatted = NumberFormat.getCurrencyInstance().format(this.monthlyMortgage);
        System.out.println(MessageFormat.format(
                "\nThank you for using our service {4}.\nYour loan of ${0} will be paid off in {1} monthly payments of roughly {2}\n{3}\n\n",
                this.principle,
                this.monthPeriod,
                monthlyPayFormatted,
                lineSeparator,
                accountHolder
        ));

        int currentMonth = 0;
        while (currentMonth <= this.monthPeriod) {
            double ownedMoney = calculateBalanceOwned(this.principle, this.monthPeriod, this.monthlyInterest, currentMonth);
            String ownedMoneyFormatted = NumberFormat.getCurrencyInstance().format(ownedMoney);
            System.out.println(MessageFormat.format("Month {0}: Money Owned - {1}", currentMonth, ownedMoneyFormatted));
            currentMonth += 1;
        }
        System.out.println("\nYour debts are now paid off!");
    };

    private static double calculateBalanceOwned(float principal, float totalPayments, float interest, int currentMonth) {
        double balance = principal
                * (Math.pow(1 + interest, totalPayments) - Math.pow(1 + interest, currentMonth))
                / (Math.pow(1 + interest, totalPayments) - 1);
        return balance;
    }
}
