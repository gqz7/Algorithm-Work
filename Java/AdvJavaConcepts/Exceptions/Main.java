package com.company;

import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        var exceptionThrower = new FirstExceptions();

        //exceptionThrower.errorWithNoHandler(); //this method purposefully throws an unhandled NullPointerException error

        //this would cause a 'checked error' meaning the compiler will not run until the error has been fixed.
        //  FileReader reader = new FileReader("notAFile.txt");
        //      see caught example in FirstExceptions Class

        //this will log a helpful error message to the client
        exceptionThrower.errorWithHandler("aRandomFile.txt");

        /*
            Common Runtime Exceptions

            NullPointerException - null was passed where a specific value is needed
            ArithmeticException - trying to divide a number by 0
            IllegalArgumentException - a method received and unexpected data type
            IndexOutOfBoundsException - accessing an array/list index that does not exist
            IllegalStateException - running a method but the underlying object is not in the right state


        */

    }
}
