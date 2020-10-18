package com.astralprojection;
import java.util.Scanner;
import java.text.MessageFormat;

public class Main
{
    public static void main(String[] args) {
        try {
            System.out.println("This is the Fibonacci Sequence");
            String fibQuestion = ("Enter an integer for the number of rounds through the fibonacci sequence to calculate (1-93)\nInt: ");
            String processQuestion = ("Do you want to see the whole fibonacci sequence? (Y/N)\nInput: ");

            long number = askQuestion(fibQuestion, 0, 93);

            boolean showFibProcess = askBool(processQuestion);

            String finalFib = fibCalculation(number, showFibProcess);

            System.out.println(MessageFormat.format("\n\nThe {0} Number In The Fibonacci Sequence Is {1}", number, finalFib));

        } catch (Exception e) {
            System.out.println("An unexpected error occured in the program!");
        }
    }

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

    private static boolean askBool(String question) {
        final Scanner scanner = new Scanner(System.in);
        boolean answer = false;
        try {
            while (true) {
                System.out.print(question);
                String answered = scanner.nextLine();
                System.out.println(answered.trim());

                if (answered == "Yes") {
                    answer = true;
                    break;
                } else if (answered == "No") {
                    break;
                } else {
                    System.out.println("WARNING: Please Enter Y or N");
                }
            }
            return answer;
        } catch (Exception e) {
            System.out.println("\nYou must correct data types");
            return askBool(question);
        }
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
                System.out.print(MessageFormat.format("\nWARNING\nYou did not enter a number in the range of {0} to {1}\n\n", min, max));
            }
            return inputValue;
        } catch (Exception e) {
            System.out.println("\nYou must correct data types");
            return askQuestion(question, min, max);
        }
    };

}