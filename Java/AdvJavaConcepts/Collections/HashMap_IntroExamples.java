package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMap_IntroExamples {

    public static void show() {

        System.out.println("\nHashMap Examples Output\n".toUpperCase());

        //creating a list of customers to then add to a HashMap
        Customer customerTom = new Customer("tom", "tom@email.com");

        List<Customer> customers = new ArrayList<>();
        customers.add(customerTom);
        customers.add(new Customer("mike", "mike@email.com"));
        customers.add(new Customer("bill", "bill@email.com"));

        //a hash map is extremely useful for looking up data when you had a lot of it.
        //the O notation of this search algorithm will always be O(1)
        Map<String, Customer> map = new HashMap<>();

        //in the map the customers will we keyed by their id and their Customer object will be stored as the value
        for (Customer c : customers)
            map.put(c.getId(), c);

        //now that the hash map is full of data, Customer data can be looked up very quickly
        Customer foundCustomer = map.get("u5");
        //u4 is the first key that will not return null
        //this is because other Customers were created in another example but not store in the map, see the Customer class.
        System.out.println("Customer with id 'u5': " + foundCustomer);

        //one can also use getOrDefault so instead of passing null a default value will be returned

        //to check for a keys existence in a map use 'containsKey'
        System.out.println("The key 'u1' does " + (map.containsKey("u1") ? "" : "not ") + "exist in the map");
        //to check for a value in a map use 'containsValue
        System.out.println("Customer tom's data does " + (map.containsValue(customerTom) ? "" : "not ") + "exist in the map");

        //one can also replace data in a map using the 'replace' method
        map.replace("u5", new Customer("george", "george@email.com") );

        Customer foundReplacedCustomer = map.get("u5");
        System.out.println("Customer with id 'u5': " + foundReplacedCustomer);

        //a map is not directly iterable but has methods that return iterable objects
        //these methods are 'keySet', 'entrySet', and 'values'. if one needs to get both key and values it is best to use entrySet

        //the order of this iteration is not always the same as maps to not have a set order
        System.out.println("\n - CUSTOMER DATA -");
        for ( var customerData : map.entrySet() ) {
            String id = customerData.getKey();
            String name = customerData.getValue().toString();
            System.out.println("Customer; id: " + id + " name: " + name);
        }

        System.out.println("-------------------------------------");
    }
}
