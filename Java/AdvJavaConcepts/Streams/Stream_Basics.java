
package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Intro_Examples {

    public static void showExamples() {

        Random randomizer = new Random();
        int[] numbers = new int[] {2, 3, 4, 7, 9, 11};

        //Creating a stream.
        //  A stream can be created from an Collection using the 'Arrays' package
        //  or from the Static Stream class using the 'generate' method

        //Streams can be created from collections/arrays or generated with the generate method

        //using Stream.generate
        Stream<Float> randomNumberStream = Stream.generate(randomizer::nextFloat);

        //create a stream from a collection
        IntStream intStream = Arrays.stream(numbers);

        //Iterating a Stream
        //this will print every item in the stream, if the stream is endless then so will the forEach loop
        System.out.println("Printing all numbers in the int stream");
        intStream.forEach(System.out::println);

        //intStream can no long be used because it has already been operated on
        //this closes the stream and therefore will throw an 'illegal state exception' if used again
        //so instead I will just create a new stream in-line for the next example

        //Limiting Iteration
        //stream methods are like a pipeline of instructions,
        // limit is called before so that forEach will only have access to 3 elements
        System.out.println("\nLimiting the number stream");
        Arrays.stream(numbers)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\nRandom Numbers Stream limited to 10");
        randomNumberStream.limit(10).forEach(System.out::println);


    }

}
