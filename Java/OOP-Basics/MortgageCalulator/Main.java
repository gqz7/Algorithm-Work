package com.astralprojection;

import java.text.NumberFormat;
import java.util.Scanner;
import java.text.MessageFormat;

public class Main {
    //CONSTANTS
    final static int MONTHS_IN_YEAR = 12, PERCENT = 100;

    public static void main(String[] args) {
        MortgageAccount myAccount = MortgageInterface.createAccount();

        myAccount.displayPaymentSchedule();
    }

}