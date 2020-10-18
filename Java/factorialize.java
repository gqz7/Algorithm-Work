package com.astralprojection;
import java.text.MessageFormat;

import java.util.Scanner;

public class Main {
    /*
      User enters number and gets the factorial of it
     */
    public static void main(String[] args) {
        try {
            String factorialQuestion = "Enter an integer to factorialize (0 - 20)\nInt: ";
            long number = askQuestion(factorialQuestion, 0, 20);
            long factorial = calcFactorial(number);
            System.out.println("\nThe Factorial Of " + number + " is " + factorial);
        } catch (Exception e) {
            System.out.println("An unexpected error occured!");
        }
    }
    private static long calcFactorial(long num) {
        long factorial = 1, count = 1;

        while (count <= num) {
            factorial *= count;
            System.out.println(factorial + " count " + count);
            count++;
        }
        return factorial;
    }
    private static long askQuestion(String question, String type, long min, long max) {
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
            System.out.println("\nYou must correct data type: " + type);
            return askQuestion(question, type, min, max);
        }
    };
}