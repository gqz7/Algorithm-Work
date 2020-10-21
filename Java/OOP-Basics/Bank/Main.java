package com.company;

public class Main {

    public static void main(String[] args) {
        //TESTING UNIQUE ACCOUNT NUMBER GENERATION
//        for (int i = 0; i < 10; i++) {
//            String fName = Integer.toString(i);
//            String lName = Integer.toString(i+1);
//            var myAccount = new BankAccount(fName, lName);
//        }
//
//        BankAccount.showAllNumbers();
            var myAccount = new BankAccount("Test first", "Test last");
            myAccount.getAccountBalance();
    }
}
