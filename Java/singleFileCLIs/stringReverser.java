package com.astralprojection;
import java.text.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        String reverserQuestion = "\nEnter A String/Sentence And It Will Be Reversed For You\nString: ";
        String normalString = takeUserString(reverserQuestion);
        String reversedString = stringReverse(normalString);

        String finalMsg = MessageFormat.format("\nYour Original String:\n{0}\n\nYour String Reversed:\n{1}", normalString, reversedString);

        System.out.println(finalMsg);

    }

    public static String stringReverse (String normalString) {
        String reversedString = "";

        int strLen = normalString.length()-1;

        for (int i = strLen; i >= 0 ; i--) {
            //  System.out.println(normalString.charAt(i));
            reversedString += normalString.charAt(i);
        }
        return reversedString;
    }

    public static String takeUserString (String question) {
        final Scanner scanner = new Scanner(System.in);

        String inputStr;

        while (true) {
            System.out.print(question);

            inputStr = scanner.nextLine();
            if (!inputStr.strip().equals("")) {
                break;
            }
            System.out.println("\nWARNING: You entered nothing.\n");
        }
        return inputStr;


    }
}