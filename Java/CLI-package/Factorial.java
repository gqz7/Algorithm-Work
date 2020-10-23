package com.company;
import java.text.MessageFormat;

public class Factorial extends Algorithm {

    @Override
    public void run () {
        String factorialQuestion = "Enter an integer to factorialize (0 - 20)\nInt: ";
        long number = CLI.numberLongQuestion(factorialQuestion, 0, 20);
        long factorial = calcFactorial(number);
        System.out.println(MessageFormat.format( "\nThe Factorial Of {0} is {1}", number, factorial ));
    }

    private static long calcFactorial(long num) {
        long factorial = 1, count = 1;
        while (count <= num) {
            factorial *= count;
//            System.out.println( MessageFormat.format ("{0} count {0}", factorial,  count);
            count++;
        }
        return factorial;
    }


}
