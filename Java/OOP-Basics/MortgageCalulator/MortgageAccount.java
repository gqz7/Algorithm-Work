package com.astralprojection;

public class MortgageAccount {

    private float principle;
    private float yearlyInterest;
    private byte yearPeriod;

    MortgageAccount(
            float total,
            float interest,
            byte period
    ) {
       this.principle = total;
       this.yearlyInterest = interest;
       this.yearPeriod = period;
    }

}
