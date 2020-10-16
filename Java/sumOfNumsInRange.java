package com.astralprojection;

import java.util.Scanner;

public class Main {
    /*
      User enters two number and gets the range of numbers between them
     */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        int min = 0;
        int max = 0;
        if ( number1 > number2 ) {
          min = number2;
          max = number1;
        } else {
          min = number1;
          max = number2;
        }

        int total = 0;

        for ( int i = min; i <=  max; i++) {
            total += i;
        }

        System.out.println("The total sum of all numbers between " + min + " and " + max + " is " + total);

    }
}