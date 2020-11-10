package com.astralprojection.Interface;

import com.astralprojection.Finaces.MortgageAccount;
import com.astralprojection.Finaces.MortgageInterface;

public class Main {
    //CONSTANTS
    final static int MONTHS_IN_YEAR = 12, PERCENT = 100;

    public static void main(String[] args) {
        MortgageAccount myAccount = MortgageInterface.createAccount();

        myAccount.displayPaymentSchedule();
    }

}