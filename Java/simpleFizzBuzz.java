package com.astralprojection;

import java.util.Scanner;

public class Main {
    /*
      User enters number and gets the factorial of it
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer\nInt: ");

        try {
            int number = scanner.nextInt();

            if (number % 3 == 0 && number % 5 == 0 ) {
                System.out.println("FizzBuzz");
            } else if (number % 3 == 0) {
                System.out.println("Buzz");
            } else if (number % 5 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(number);
            }

        } catch (Exception e) {
            System.out.println("You must enter an Integer");
        }

    }
}