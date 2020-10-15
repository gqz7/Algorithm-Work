package com.astralprojection;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
/*
  User enters number and gets the factorial of it
 */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer to be factorialized\nInt: ");
        try {
            int number = scanner.nextInt();
            int factorial = 1, count = 1;

            while (count <= number) {
              factorial *= count;
              count++;
            }

            System.out.println("\nThe Factorial Of " + number + " is " + factorial);

        } catch (Exception e) {
            System.out.println("You must enter an Integer for this program");
        }
        
    }
}