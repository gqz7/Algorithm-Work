package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Collections_IntroExamples {
    public static void show() {

        System.out.println("\nCollection Examples Output\n".toUpperCase());
        //this will be an example collection that is used to showcase available collection methods
        Collection<Object> collection = new ArrayList<>();
        //this is a collection of objects so any primitive and any class instance can be added to this collection
        Collections.addAll(collection, 3, 4, 7, "jpeg", 'Z', 3);

        //System.out.println(collection);
        collection.remove(3); //removes the first instance of an element with a given value

        System.out.println(collection);


        //collection.clear(); //this will remove all elements from a collection

        boolean containsZ = collection.contains('Z');
        boolean collectionIsEmpty = collection.isEmpty();
        System.out.println( "the collection" + ( containsZ ? " " : " does not ") +  "contains Z." );
        System.out.println( "the collection" + ( collectionIsEmpty ? " is " : " is not ") +  "is empty." );

        //checking for equality among collections
        Collection<Object> copyCollection = new ArrayList<>();
        copyCollection.addAll(collection); //now we have an exact copy of the current state of the first collection

        //if the equality operator is used '==' then the code will return false because the variables are pointing to two different locations in memory
        //instead use the equals method of Collection
        boolean collectionsAreEqual = collection.equals(copyCollection);
        System.out.println("the collections are" + ( collectionsAreEqual ? " " : " not ") +  "equal.");

        System.out.println("-------------------------------------");

    }
}
