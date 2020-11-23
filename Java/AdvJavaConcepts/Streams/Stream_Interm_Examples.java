package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Interm_Examples {
    public static void showExamples() {

        System.out.println("More Examples of Stream Methods");

        String[] strNumbers = new String[] {"4", "2", "23", "4", "7", "1", "32", "7", "5"};

        //Mapping and filtering with Streams
        System.out.println("\nMapping and Filtering with Streams\n");
        Arrays.stream(strNumbers)
                .map(Integer::parseInt)
                .filter(n -> n > 3)
                .map(n -> n*7)
                .forEach(System.out::println);

        System.out.println("\n\nMore Methods to Explore\n");
        System.out.println("take/dropWhile, allows filtering based on a conditional to occur until a condition is met");
        System.out.println("peek: allow you to see/log data in a stream without terminating it (this is used in testing),\nterminating equivalent can be made with forEach");

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
        System.out.println("\treduce(), combine multiple stream values to produce one");
        System.out.println("\tcount(), count how many items are in a stream at a give moment");
        System.out.println("\tdistinct(), reduce a stream down to only its unique value");
        System.out.println("\tany/all/noneMatch, return booleans based on a predicate given to each element in a stream");
        System.out.println("\tfindFirst/Any, returns element/s that return true on a given predicate");
        System.out.println("\tmax/min, return the largest or smallest element of a stream based on a comparator given");
        System.out.println("\nusing count() and filter() in tandem\n");

        int count = (int) Arrays.stream(strNumbers)
                .map(Integer::parseInt)
                .filter(n -> n > 3)
                .distinct()
                .count();
        int maxValue = (int) Arrays.stream(strNumbers)
                .map(Integer::parseInt)
                .max(Comparator.comparing(Integer::intValue))
                .get();
        int minValue = (int) Arrays.stream(strNumbers)
                .map(Integer::parseInt)
                .min(Comparator.comparing(Integer::intValue))
                .get();
        Optional<Integer> numsProduce = Arrays.stream(strNumbers)
                .map(Integer::parseInt)
                .distinct()
                .reduce((a,b) -> a*b);

        System.out.println("\tThere are a total of " + count + " unique numbers above 3 in the array.");
        System.out.println("\tThe Max Value: " + maxValue);
        System.out.println("\tThe Min Value: " + minValue);
        numsProduce.ifPresent(integer -> System.out.println("\tProduct of unique values: " + integer));

        System.out.println("\nUsing Collectors With Streams");
        System.out.println("\tCreating an int summary...");
        IntSummaryStatistics intSummary = Arrays.stream(strNumbers)
                .collect(Collectors.summarizingInt(Integer::parseInt));
        System.out.println("\t\tSummary of Data: " + intSummary);

        System.out.println("\nOther Collectors methods: \njoining - add all elements to join in one string (optional delimiter)");
        System.out.println("\ntoList\\Set\\Map - converts stream to Object List\\Set\\Map (can be casted to other List<>)");
        System.out.println("\nThere are also reducing oriented methods like summingInt that provide another way to reduce a stream to a single value");
        System.out.println("\n\nPartitioning");

    }
}
