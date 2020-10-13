package com.astralprojection;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    /*
      User enters number and gets the factorial of it
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an sentence to be Title Cased\nString: ");
        String sentence = scanner.nextLine();
        String titleCased = "";

        String array1[]= sentence.split("/");


        System.out.println("\nYour Title Cased Sentence Is: \n" + titleCased);

    }
}