package com.company.AlgorithmLogic;

import com.company.UI.CLI;

import java.util.Arrays;
import java.util.List;

public class TextCalc implements Algorithm {

    final List<String> possibleOperators = Arrays.asList( "+", "-", "x", "X", "*", "/", "%" );
    final int MAX_OPERATORS = 1;
    final int MAX_INTS = 2;

    @Override
    public void run() {

        printWelcomeMsg();

        while (true) {
            String expressionQuestion = "Input a math expression using the rules above.";
            String textExpression = CLI.stringQuestion(expressionQuestion);

            boolean isValidExpr = isValidTextExpression( textExpression );

            if (isValidExpr) {
                double answer = evaluateTextExpression(textExpression);

                System.out.println("\nAfter evaluating your expression, the answer is: " + answer);

                boolean tryAgain = CLI.yesOrNo("\nWould you like to try the Text-Calculator again?");
                if (!tryAgain) break;
            } else
                System.out.println("\nThat was an invalid expression, try again...\n");
        }
    }

    private boolean isValidTextExpression(String textExpression) {
        String[] exprChars = textExpression.split(" ");
        if (exprChars.length != 3) return false;

        int ops = 0;
        int ints = 0;

        for ( String data : exprChars ) {
            if ( isNumeric(data) )
                ints++;
            else if ( possibleOperators.contains(data))
                ops++;
            else {
                return false;
            }

            if (ops > MAX_OPERATORS || ints > MAX_INTS) {
                return false;
            }
        }

        return true;
    }

    private boolean isNumeric ( String testStr ) {
        try {
            Integer.parseInt(testStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double evaluateTextExpression(String textExpression) {


        String[] chars = textExpression.split(" ");

        for ( String c : chars ) {
            System.out.println(c);
        }

        return 0;
    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nTEXT CALCULATOR\n_____________________________\n\n");
        System.out.println("Enter In A Math Operation As A String And Output The Results\n");
        System.out.println("RULES:\n1) Must include only one space between Numbers and Operators");
        System.out.println("2) Must input 2 Integers and 1 Operator\n");
        System.out.println("Operators:\n'+' = addition\n'-' = subtraction\n'x' OR 'X' OR '*' = multiplication");
        System.out.println("'/' = division\n'%' = modulus\n\n");
    }
}
