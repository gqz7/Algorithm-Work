package com.company;

import com.company.Exceptions.AccountException;
import com.company.Exceptions.InsufficientFundsException;

import java.io.IOException;


public class Account {

    private int balance;

    public void deposit ( int value) throws IOException {
        if ( value <= 0 )
            throw new IOException(); //this technique of throwing exceptions is call defensive coding

        System.out.println(value + " is a valid number");
    }

    public void withdraw ( int value) throws InsufficientFundsException {
        if (value > balance) {
            throw new InsufficientFundsException();
        }

    }

    public void withdrawWithChainedException ( int value) throws AccountException {
        if ( value > balance)
            throw new AccountException( new InsufficientFundsException("Not enough funds"));
    }
}
