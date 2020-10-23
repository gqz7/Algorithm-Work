package com.company;

public class FirstExceptions {

    public void showWithNoHandler() {
        sayHello(null); //this will throw a NullPointerException and log the call stack
    }

    public void showWithHandler() {

    }

    public static void sayHello( String name ) {
        System.out.println(name.toUpperCase());
    }

}
