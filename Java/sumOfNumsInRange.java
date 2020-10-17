package com.astralprojection;

import java.util.Scanner;

public class Main {
    /*
      User enters two number and gets the range of numbers between them
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String numberQuestion = "Enter A Number Between 1 and 1,000,000,000\nNumber: ";

        long number1 = askQuestion(numberQuestion, 1, 1000000000);
        long number2 = askQuestion(numberQuestion, 1, 1000000000);

        sumOfRanges(number1, number2);

    }

    private static void sumOfRanges( long num1, long num2) {
        long min = 0;
        long max = 0;
        if ( num1 > num2 ) {
            min = num2;
            max = num1;
        } else {
            min = num1;
            max = num2;
        }

        long total = 0;

        for ( long i = min; i <=  max; i++) {
            total += i;
        }

        System.out.println("The total sum of all numbers between " + min + " and " + max + " is " + total);

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