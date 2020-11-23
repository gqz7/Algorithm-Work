package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Interm_Examples {
    public static void showExamples() {

        System.out.println("More Examples of Stream Methods");

        String[] strNumbers = new String[] {"2", "23", "4", "7", "1", "32", "5"};

        //Mapping and filtering with Streams
        System.out.println("\nMapping and Filtering with Streams\n");
        Arrays.stream(strNumbers)
                .map(Integer::parseInt)
                .filter(n -> n > 3)
                .map(n -> n*7)
                .forEach(System.out::println);

        System.out.println("\n\nMore Methods to Explore\n");
        System.out.println("take/dropWhile, allows filtering based on a conditional to occur until a condition is met");
        System.out.println("peek: allow you to see/log data in a stream without terminating it, a terminating equivalent can be made with forEach");

        OptionalInt sumOfNumsBelowFour = Arrays.stream(strNumbers)
                .takeWhile(numStr -> Integer.parseInt(numStr) < 4)
                .peek(n -> System.out.println("peeking: " + n))
                .mapToInt(Integer::parseInt)
                .reduce(Integer::sum);

        if (sumOfNumsBelowFour.isPresent())
            System.out.println("Sum of numbers in array below 4: " + sumOfNumsBelowFour.getAsInt());

        System.out.println("\nStream Sorting\nsorted numbers array reverse order: ");
        Arrays.stream(strNumbers)
                .map(Integer::parseInt)
                //.sorted(String::compareTo) using sorted this way limits the sorting to one direction
                //a better way is to use the Comparator interface that gives more control of sorting
                .sorted(Comparator.comparing(Integer::doubleValue).reversed())
                .forEach(n -> System.out.print(n + ", "));


        System.out.println("\n\nReducing Methods");
        System.out.println("\treduce()");
        System.out.println("\tcount()");

        System.out.println("\nusing count() and filter() in tandem\n");
        int count = (int) Arrays.stream(strNumbers)
                .map(Integer::parseInt)
                .filter(n -> n > 3)
                .count();

        System.out.println("\tThere are a total of " + count + " numbers above 3 in the array.");
        System.out.println("\tany/allMatch");
        System.out.println("\tfindFirst/Any");
        System.out.println("\tmax/min");

        System.out.println("Collectors");

        System.out.println("Partitioning");

    }
}
