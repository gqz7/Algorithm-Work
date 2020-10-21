package com.company;

public class SavingsAccount extends BankAccount {

    private float interest = (float) 0.01;
    private static final int WITHDRAW_FEE = 10_000;
    private static final int WD_LIMIT = 6;
    private int monthlyWithdraws = 0;

    SavingsAccount( String firstName, String lastName) {
        super(firstName, lastName);
    }
    private void monthlyInterestGain () {

    }

    @Override
    public void withdraw ( int amount ) {
        int totalWithdraw;
        if (monthlyWithdraws+1 > WD_LIMIT) {
            totalWithdraw = amount + WITHDRAW_FEE;
            System.out.println("Over monthly withdraw limit, you will be charged a withdraw fee.");
        } else totalWithdraw = amount;

        super.withdraw(totalWithdraw);
        monthlyWithdraws += 1;
    }
    @Override
    public void deposit ( int amount ) {
        super.deposit(amount);
    }

}
