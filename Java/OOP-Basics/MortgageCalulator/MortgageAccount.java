package com.astralprojection;

public class MortgageAccount {
    final static byte MONTHS_IN_YEAR = 12, PERCENT = 100;

    private float principle;
    private float yearlyInterest;
    private float monthlyInterest;
    private byte yearPeriod;
    private short monthPeriod;

    MortgageAccount(
            float total,
            float interest,
            byte period
    ) {
       this.principle = total;
       this.yearlyInterest = interest;
       this.yearPeriod = period;

       this.monthlyInterest = yearlyInterest / PERCENT / MONTHS_IN_YEAR;
       this.monthPeriod = (short) (yearPeriod * MONTHS_IN_YEAR);
    }

}
