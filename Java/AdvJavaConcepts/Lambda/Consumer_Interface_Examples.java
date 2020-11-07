package com.company;

import java.util.List;
import java.util.function.Consumer;

public class Consumer_Interface_Examples {
    public static void show () {

        System.out.println("\nConsumer Basics Examples Output\n".toUpperCase());

        List<Integer> intList = List.of(3, 4, 7, 8, 9);

        //example of Imperative Programing
        //one simple way to iterate over these values would be a for loop, like so
        System.out.println("\nImperative Programing Implementation");
        for (int number : intList )
            System.out.println(number);
        //examples of imperative programing are; for, if/else, switch and using these to change the programs state

        System.out.println("\nDeclarative Programing Implementation");
        //another approach to the same problem can be solved with Declarative Programing
        intList.forEach(System.out::println); // OR  intList.forEach(item -> System.out.println(item));

        System.out.println("\nChaining Lambda Defined Consumers");
        List<String> strList = List.of("there", "once", "was", "a", "man");
        Consumer<String> print = System.out::println;
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());

        strList.forEach(print.andThen(printUpperCase).andThen(print));
        // this is the same as print.andThen(printUpperCase.andThen(print)) but is more difficult to read

        System.out.println("-------------------------------------");

    }
}
