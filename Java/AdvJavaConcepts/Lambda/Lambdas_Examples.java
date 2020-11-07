package com.company;

public class Lambdas_Examples {

    public static void show() {

        System.out.println("\nLambda Basics Examples Output\n".toUpperCase());

        //using a named interface
        //an interface implemented here tell the class that it must have a print method
        //so that the console printer can have its 'print' method called
        System.out.println("\nFunctional Interface Implementation");
        greet(new ConsolePrinter());

        //an alternative approach is using Anonymous Inner Classes
        //this is for when you only want to implement an interface in a certain way once
        System.out.println("\nAnonymous-Inner-Class Interface Implementation");
        greet( new Printer() {
            //the implementation of print here is different than how it is being used in the ConsolePrinter
            @Override
            public void print (String msg) {
                String[] splitMsg = msg.split(" ");
                for ( String word : splitMsg )
                    System.out.println(word);
            }
        });

        //as you can see above the Inner Class approach takes a bit of code and can get messy very quickly
        //this is why Lambda Expressions were introduced!
        System.out.println("\nLambda Expressions Implementation");
        //the compiler will check the expression passed to greet against where it is being called
        // making sure it is in line with the contract of the Printer interface
        greet(message -> System.out.println(message)); //this is the traditional way of writing a lambda expression
        //this is an even cleaner way of writing one
        //it is set up as 'Object/Class::methodName'
        System.out.println("\nLambda (Method Reference) Implementation");
        greet(System.out::println);

        System.out.println("-------------------------------------");
    }

    public static void greet (Printer printer) {
        printer.print("Printing... beep... boop!");
    }
}
