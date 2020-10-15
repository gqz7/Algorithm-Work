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

        try {
            String sentence = scanner.nextLine();
            String titleCased = "";

            String sentenceArr[]= sentence.split(" ");

            for ( int i = 0; i < sentenceArr.length; i++) {
                String word = sentenceArr[i];
                String titleCasedWord = Character.toUpperCase( word.charAt(0) ) + word.substring(1).toLowerCase();
                // System.out.println(titleCasedWord);
                if (i != 0) {
                    titleCased += " ";
                }
                titleCased += titleCasedWord;

            }

            System.out.println("\nYour Title Cased Sentence Is: \n" + titleCased);
        }catch (Exception e) {
            System.out.println("You must enter an String for this program");
        }

    }
}