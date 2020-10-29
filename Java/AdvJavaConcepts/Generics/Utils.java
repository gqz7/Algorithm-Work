package com.company;

public class Utils {

    public static <E extends Comparable<E>> E max(E first, E second) {
        return (first.compareTo(second) > 0) ? first : second;
    }

    public static <K, V> void print (K key, V value) {
        System.out.println(key + ": " + value);
    }

    public static void printUsers ( GenericComparableList<? extends User> users) {
        System.out.println("\nUsers In List\n______________\n");
        int listLen = users.getCount();
        for (int i = 0; i < listLen; i++) {
           User curUser = users.get(i);
            System.out.println("\t" + curUser);
        }
        System.out.println("______________\n");
    }
}
