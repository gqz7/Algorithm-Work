package com.company;

public class CheckingAccount extends BankAccount {

    private int withdrawFee = 10_000;
    private int monthlyWithdraws = 0;

    CheckingAccount( String firstName, String lastName) {
        super(firstName, lastName);

    }

}
