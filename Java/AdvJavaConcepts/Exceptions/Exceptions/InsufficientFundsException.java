package com.company.Exceptions;

/*
    When making a custom exception...
    if it is going to be a 'checked' exception it must extend the Exception class
    if it is going to be an  'unchecked' exception it must extend the RunTimeException class
 */
public class InsufficientFundsException extends Exception {

    public InsufficientFundsException () {
        super("Insufficient Funds");
    }

    public InsufficientFundsException (String msg) {
        super(msg);
    }
}
