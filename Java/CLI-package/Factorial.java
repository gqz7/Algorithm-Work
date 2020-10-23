package com.company;
import java.text.MessageFormat;

public class Factorial extends Algorithm {

    String question = "Enter an integer to factorialize (0 - 20)\nInt: ";

    @Override
    public void run () {
        long number = CLI.numberLongQuestion( question, 0, 20);
        long factorial = calculate(number);
        System.out.println(MessageFormat.format( "\nThe Factorial Of {0} is {1}", number, factorial ));
    }

    private long calculate(long num) {
        long factorial = 1, count = 1;
        while (count <= num) {
            factorial *= count;
            count++;
        }
        return factorial;
    }

}
