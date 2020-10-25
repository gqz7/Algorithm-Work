package com.company;

import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        var exceptionThrower = new FirstExceptions();

        //exceptionThrower.errorWithNoHandler(); //this method purposefully throws an unhandled NullPointerException error

        //this would cause a 'checked error' meaning the compiler will not run until the error has been fixed.
        //  FileReader reader = new FileReader("notAFile.txt");
        //      see caught example in FirstExceptions Class

        //this will log a helpful error message to the client
        exceptionThrower.errorWithHandler("aRandomFile.txt");

        //this method examples catching more than one exception
        exceptionThrower.multipleExceptionsHandled("anotherFileThatDoesntExist.txt");

        //example new exceptions try with resources
        exceptionThrower.exceptionHandlingWithResources("infile.txt", "outfile.json");

        //this method will throw an exception of IllegalArgument if the value is checked and it is negative.
        //since a positive value is being passed nothing will go wrong and an output will log in the console
        try {
            exceptionThrower.throwingExceptionsManually( 100 );
        } catch ( IOException exception ) {
            System.out.println("An unexpected error occurred");
        }
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
