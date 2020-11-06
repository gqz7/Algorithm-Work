package com.company.AlgorithmLogic;
import com.company.UI.CLI;

import java.text.MessageFormat;

public class Factorial implements Algorithm {

    private String START_QUESTION = "Enter an integer to factorialize";
    private String FINAL_MESSAGE = "\nThe Factorial Of {0} is {1}";

    @Override
    public void run () {
        printWelcomeMsg();

        long number = CLI.numberLongQuestion( START_QUESTION, 0, 20);
        long factorial = calculate(number);
        System.out.println(MessageFormat.format( FINAL_MESSAGE, number, factorial ));
    }

    private long calculate(long num) {
        long factorial = 1, count = 1;
        while (count <= num) {
            factorial *= count;
            count++;
        }
        return factorial;
    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nFACTORIAL CALCULATOR\n_____________________________\n\n");
    }

}
