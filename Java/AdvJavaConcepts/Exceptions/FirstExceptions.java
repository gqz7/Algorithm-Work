package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FirstExceptions {

    public void errorWithNoHandler() {
        sayHello(null); //this will throw a NullPointerException and log the call stack
    }

    public void errorWithHandler(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
        } catch (FileNotFoundException exception) {
            System.out.println("File does not exist");
        }
    }

    public static void sayHello( String name ) {
        System.out.println(name.toUpperCase());
    }

}
