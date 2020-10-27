package com.company;

import java.util.Scanner;

public class CLI {

    final static Scanner scanner = new Scanner(System.in);


    public static String stringQuestion(String question) {
        String inputValue = "";

        try {
            while (true) {
                System.out.print(question);
                inputValue = scanner.nextLine();
                if (inputValue.trim() != "") {
                    break;
                }
                System.out.print("\nWARNING\nYou Can Not Enter An Empty String");
            }
            return inputValue;
        } catch (Exception e) {
            System.out.println("\nYou must correct data types");
            return stringQuestion(question);
        }
    };


}
