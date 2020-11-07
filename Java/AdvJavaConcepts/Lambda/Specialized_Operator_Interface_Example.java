package com.company;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Specialized_Operator_Interface_Example {

    public static void show () {

        System.out.println("\nSpecialized Operators Interface Basics Examples Output\n".toUpperCase());

        System.out.println("Binary-Operator Interface");

        //use a binary operator when you need to take too of the same value types as arguments to return that same type
        BinaryOperator<Integer> multiply = (a,b) -> a * b;
        //this function will take a int and return that int squared
        Function<Integer, Integer> square = num -> num*num;

        //composing biOperator with a Function interface
        int mathResult = multiply.andThen(square).apply(3,7);
        System.out.println("3*7 then squared is: " + mathResult);

        System.out.println("\nUnary-Operator Interface");
        //an unary operation takes one argument and returns that same time, after modifying the value
        UnaryOperator<Integer> increment = number -> number + 1;

        //the square function above can be written as an unary operator
        UnaryOperator<Integer> squareUnary = num -> num*num;
        int unaryResult = increment.andThen(square).apply(2);
        System.out.println("When you increment 2 then square it the final result is: " + unaryResult);


        System.out.println("-------------------------------------");

    }

}
