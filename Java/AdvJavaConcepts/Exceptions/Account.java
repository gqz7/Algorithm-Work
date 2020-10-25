package com.company;

public class Account {
    public void deposit ( int value) {
        if ( value <= 0 )
            throw new IllegalArgumentException(); //this technique of throwing exceptions is call defensive coding

        System.out.println(value + " is a valid number");
    }
}
