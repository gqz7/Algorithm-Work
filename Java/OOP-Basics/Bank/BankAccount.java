package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;


public class BankAccount {

    private static int ACCOUNT_CHAR_LIMIT = 1_000_000_000;
    private static int ACC_LENGTH = 10;

    private String accountHolderFirstName;
    private String accountHolderLastName;
    private String accountNumber;
    private String routingNumber;
    private int balance;

    private static ArrayList<String>  allAccountNum = new ArrayList<>();
    private static ArrayList<String>  allRouteNum = new ArrayList<>();

    BankAccount ( String firstName, String lastName ) {
        accountHolderFirstName = firstName;
        accountHolderLastName = lastName;

        accountNumber = BankAccount.genAccountNumber();
        routingNumber = BankAccount.genRoutingNumber();

        balance = 0;
    }

    private static String genAccountNumber () {
        //Ensure there are no repeats by comparing to list of all account numbers
        String randomNumber = formatAccountNumber(Integer.toString((int) Math.round(Math.random() * ACCOUNT_CHAR_LIMIT)));
        while (allAccountNum.contains(randomNumber)) {
            randomNumber = formatAccountNumber(Integer.toString((int) Math.round(Math.random() * ACCOUNT_CHAR_LIMIT)));
        }
//        System.out.println(randomNumber);
        allAccountNum.add(randomNumber);
        return randomNumber;
    }

    public void deposit ( int amount ) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw ( int amount ) {
        if (amount > 0) {
            balance -= amount;
        }
    }

    private static String genRoutingNumber () {
        String randomNumber = formatAccountNumber(Integer.toString((int) Math.round(Math.random() * ACCOUNT_CHAR_LIMIT)));
        while (allRouteNum.contains(randomNumber)) {
            randomNumber = formatAccountNumber(Integer.toString((int) Math.round(Math.random() * ACCOUNT_CHAR_LIMIT)));
        }
//        System.out.println(randomNumber);
        allRouteNum.add(randomNumber);
        return randomNumber;
    }

    public void getAccountBalance () {
        System.out.println("Your Account Balance is: " + NumberFormat.getCurrencyInstance().format(balance));
    }

    public static void showAllNumbers () {
        System.out.println(allAccountNum.toString());
        System.out.println(allRouteNum.toString());
    }

    public static String formatAccountNumber ( String accountNumber ) {
        int missingZeros = ACC_LENGTH - accountNumber.length();
        return "0".repeat(missingZeros) + accountNumber;
    }
}
