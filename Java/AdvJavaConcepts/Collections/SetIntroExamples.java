package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetIntroExamples {
    public static void show() {

        System.out.println("\nSet Examples Output\n".toUpperCase());

        //the idea behind a set is to have a collection of data with no repeats. Order is not prioritized and there is no built in sort

        //a simple HashSet, the most commonly used set
        Set<String> simpleSet = new HashSet<>();
        simpleSet.add("hello");
        //this will not cause an error but effiectively will be ignored once ran because it will be determined that "hello" is already present
        simpleSet.add("hello");
        simpleSet.add("world");

        //you may notice the order is not ["hello", "world"] when this prints, because order is not by when elements were added
        System.out.println("Simple Set: " + simpleSet);

        //Other Set operations

        //creating a set in-line
        String[] stringArr = {"2", "4", "5"};

        Set<String> firstSet = new HashSet<>(Arrays.asList("1", "2", "3", "2", "1"));
        Set<String> secondSet = new HashSet<>(Arrays.asList(stringArr));
        Set<String> thirdSet = new HashSet<>();
        thirdSet.add("4");
        thirdSet.add("3");

        // Copying elements in first set before any Set operations are applied.
        // This is copying values and not its reference in memory
        Set<String> firstSetCopy = new HashSet<>(firstSet);

        // A Union operation is combining two sets
        firstSet.addAll(secondSet);
        //when they are combined there will still be no duplicates, the secondSet will not be affected by this operation
        System.out.println("Union Set operation: " + firstSet);

        // Intersection operation (find the similar element in two sets)
        firstSet.retainAll(thirdSet);
        //now the first set will only retain(keep) the elements that were also contained in the thirdSet
        System.out.println("Intersection Set operation: " + firstSet);

        // Difference operation
        firstSetCopy.removeAll(firstSet);
        System.out.println("Difference Set operation: " + firstSetCopy);

        System.out.println("-------------------------------------");
    }
}
