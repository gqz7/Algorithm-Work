package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableIntroExamples {
    public static void show() {
        System.out.println("\nComparable Examples Output\n".toUpperCase());

        //comparing a collection of objects (Customers) that implement the Comparable interface
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("jack", "3jack@email.com"));
        customers.add(new Customer("gav", "2gav@email.com"));
        customers.add(new Customer("ray", "1ray@email.com"));

        System.out.println("Unsorted: " + customers);

        //this Collections static method with modify the original list
        Collections.sort(customers);
        System.out.println("Sorted by name: " + customers);


        //A class that implement the Comparator interface can also be passed so the default compareTo method is overrided
        Collections.sort(customers, new EmailComparator());
        //another way to write this is
        customers.sort(new EmailComparator());
        System.out.println("Sorted by email: " + customers);

        System.out.println("-------------------------------------");
    }
}
