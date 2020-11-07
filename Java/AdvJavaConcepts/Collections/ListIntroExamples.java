package com.company;

//the List interface implements the Collection interface to it has much of the same features
//the difference is that List keeps track of the index of elements so it should be used when you need to consider index.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListIntroExamples {

    public static void show() {

        System.out.println("\nList Examples Output\n".toUpperCase());

        List<String> stringList = new ArrayList<>();

        stringList.add("my");
        stringList.add("is");
        stringList.add("greg");

        //unlike standard Collections a List can have elements inserted at any available index
        stringList.add(1, "name");
        //you can see in the output that it does not replace the element at index 1, but inserts a new one there
        for (String str : stringList) { System.out.print(str + " "); }

        //for replacing an element use the 'set' method
        stringList.set(3, "harold");
        System.out.println();
        for (String str : stringList) { System.out.print(str + " "); }
        System.out.println();

        //your code can also remove an element by index, with the standard Collection you can only remove by an elements value
        //List still have this ability with the added index removing as well

        //a List have the method indexOf that returns the index where the first occurrence of a given value is found
        // -1 is returned when a value is not found in the given list
        //if there are more than one occurrences and you need to know the last index, use lastIndexOf
        System.out.println("'is' is found on index " + stringList.indexOf("is"));

        //adding more elements for better example of next method
        Collections.addAll(stringList, "one", "day", "i", "will", "save", "the", "world");

        //if you want just a portion of a List you can use 'subList' give a start and end index and return a sub-list
        //this returns a new List and does not affect the original
        System.out.println("\nThe middle of my String list is\n" + stringList.subList( stringList.size() / 4 , stringList.size() * 3 / 4 ));

        System.out.println("-------------------------------------");

    }

}
