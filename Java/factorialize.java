package com.astralprojection;
import java.util.Scanner;
import java.text.MessageFormat;

public class Main {
    /*
      User enters number and gets the factorial of it
     */
    public static void main(String[] args) {
        try {
            String factorialQuestion = "Enter an integer to factorialize (0 - 20)\nInt: ";
            long number = askQuestion(factorialQuestion, 0, 20);
            long factorial = calcFactorial(number);
            System.out.println(MessageFormat.format( "\nThe Factorial Of {0} is {1}", number, factorial ));
        } catch (Exception e) {
            System.out.println("An unexpected error occured!");
        }
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
                System.out.print( MessageFormat.format("\nWARNING\nYou did not enter a number in the range of {0} to {1}\n\n", min, max));
            }
            return inputValue;
        } catch (Exception e) {
            System.out.println("\nYou must correct data types");
            return askQuestion(question, min, max);
        }
    };
}