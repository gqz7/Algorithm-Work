package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsIntroExamples {
    public static void show() {
        //this will be an example collection that is used to showcase available collection methods
        Collection<Object> collection = new ArrayList<>();
        //this is a collection of objects so any primitive and any class instance can be added to this collection
        Collections.addAll(collection, 3, 4, 7, "jpeg", 'Z');

        System.out.println(collection);

        boolean containsZ = collection.contains('Z');
        System.out.println( "it" + (containsZ ? " " : " does not ") +  "contains Z" );
    }
}
