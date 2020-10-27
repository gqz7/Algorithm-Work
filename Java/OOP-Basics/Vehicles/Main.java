package com.company;

public class Main {

    public static void main(String[] args) {

        var myPerson = new Operator("Hunter");
        System.out.println("The operator's name is " + myPerson.name);

        var myCar = new Sedan("Honda Accord");
        System.out.println("My car model is the " + myCar.name);

    }
}
