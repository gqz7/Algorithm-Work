package com.company;

import java.text.MessageFormat;

public class FibonacciSequence implements Algorithm {

    private static String fibCalculation(long number, boolean showProcess) {
        long i = 0;
        long prev = 0;
        long cur = 1;
        long next = 1;
        String finalFib = "";
        while ( i < number ) {
            long fib = prev;
            String msg = ""+fib;
            if (i != number-1) {
                msg += ", ";
            } else {
                finalFib = ""+fib;
            }
            if (showProcess) {
                System.out.print(msg);
            }
            next = prev + cur;
            prev = cur;
            cur = next;
            i++;
        }
        return finalFib;
    }


    @Override
    public void run () {
        printWelcomeMsg();

        try {
            String fibQuestion = ("Enter an integer for the number of rounds through the fibonacci sequence to calculate");
            String processQuestion = ("Do you want to see the whole fibonacci sequence?");
            long number = CLI.numberLongQuestion(fibQuestion, 0, 93);
            boolean showFibProcess = CLI.yesOrNo(processQuestion);
            String finalFib = fibCalculation(number, showFibProcess);
            System.out.println(MessageFormat.format("\n\nThe {0} Number In The Fibonacci Sequence Is {1}", number, finalFib));

        } catch (Exception e) {
            System.out.println("An unexpected error occurred in the program!");
        }

    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nFIBONACCI CALCULATOR\n_____________________________\n\n");
    }
}
