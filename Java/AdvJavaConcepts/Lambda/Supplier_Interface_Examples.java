package com.company;

import java.util.List;
import java.util.function.Supplier;

public class Supplier_Interface_Examples {
    public static void show () {

        System.out.println("\nSupplier Basics Examples Output\n".toUpperCase());

        System.out.println("A simple get random number supplier");
        Supplier<Double> randomDbl = Math::random; //also written as () -> Math.random();
        //one can also use DoubleSupplier here which will save runtime memory as the program wont need to do auto-boxing/unboxing

        //suppliers are always called by their 'get' method which then supplies a value (without any arguments to wherever its needed)
        double ranVal = randomDbl.get();
        System.out.println("Random: " + ranVal);

        System.out.println("-------------------------------------");

    }
}
