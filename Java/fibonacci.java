package com.astralprojection;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        try {
            System.out.println("This is the Fibonacci Sequence");
            String fibQuestion = ("Enter an integer for the number of rounds through the fibonacci sequence to calculate (1-93)\nInt: ");

            long number = askQuestion(fibQuestion, 0, 93);
            String finalFib = fibCalculation(number);

            System.out.println("\n\nThe " + number + " Number In The Fibonacci Sequence Is " + finalFib);

        } catch (Exception e) {
            System.out.println("An unexpected error occured in the program!");
        }
    }

    private static String fibCalculation(long number) {
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

           System.out.print(msg);

            next = prev + cur;
            prev = cur;
            cur = next;

            i++;
        }
        return finalFib;

    }

    private static long askQuestion(String question, long min, long max) {
        long inputValue = 0;
        final Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.print(question);
                inputValue = scanner.nextLong();
                if (inputValue >= min && inputValue <= max) {
                    break;
                }
                System.out.print("\nWARNING\nYou did not enter a number in the range of "+min+" to "+max+"\n\n");
            }
            return inputValue;
        } catch (Exception e) {
            System.out.println("\nYou must correct data types");
            return askQuestion(question, min, max);
        }
    };

}