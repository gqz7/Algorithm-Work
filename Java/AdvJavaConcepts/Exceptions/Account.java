package com.company;

import java.io.IOException;

public class Account {
    public void deposit ( int value) throws IOException {
        if ( value <= 0 )
            throw new IOException(); //this technique of throwing exceptions is call defensive coding

        System.out.println(value + " is a valid number");
    }
}
