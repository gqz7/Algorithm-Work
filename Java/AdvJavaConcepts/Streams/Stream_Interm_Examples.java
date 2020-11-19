package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Interm_Examples {
    public static void showExamples() {

        System.out.println("More Examples of Stream Methods");

        String[] strNumbers = new String[] {"2", "3", "4", "7"};

        //Mapping and filtering with Streams
        System.out.println("\nMapping and Filtering with Streams\n");
        Arrays.stream(strNumbers)
                .map(Integer::parseInt)
                .filter(n -> n > 3)
                .map(n -> n*7)
                .forEach(System.out::println);

    }
}
