package com.company;

import java.util.function.Function;
import java.util.function.Predicate;

public class Predicate_Interface_Examples {
    public static void show () {

        System.out.println("\nPredicate Interface Basics Examples Output\n".toUpperCase());

        //predicates can be used as test where you can pass a value and it will return true or false if the test passed or failed
        //this is a simple one that check if an int value is within a range
        Predicate<Integer> isEligibleAge = number -> number > 17;
        Function<Integer, String > testAge = num -> isEligibleAge.test(num) ? "Yes" : "No";

        System.out.println("Basic Predicate & Function Interface Example");
        System.out.println("Is 7 an eligible age: " + testAge.apply(7));
        System.out.println("Is 19 an eligible age: " + testAge.apply(19));

        //predicates allow for composition and give methods that will allow you to build any conditional statement you need
        //the &&, ||, and ! operators are used through; 'and', 'or', and 'negate' respectively
        System.out.println("\n\nComposing Predicates And Functions\n");

        Predicate<String> startsWithCapital = str -> str.substring(0,1).matches("[A-Z]");
        Predicate<String> endsWithPunctuation = str -> str.substring(str.length()-1).matches("\\.|!|\\?");
        Predicate<String> isProperSentence = str -> startsWithCapital.and(endsWithPunctuation).test(str);

        String sentence1 = "the rabbit jumped into the hole";
        String sentence2 = "The boy jumped after the rabbit.";
        String sentence3 = "Time cease to exist";
        String sentence4 = "Where did everyone go?";

        String[] allSentences = {sentence1, sentence2, sentence3, sentence4};

        for ( String sentence : allSentences )
            System.out.println("Sentence: " + sentence +
                    "\nIs it a proper sentence: " + (isProperSentence.test(sentence) ? "YES" : "NO") + "\n");


        System.out.println("-------------------------------------");

    }
}
