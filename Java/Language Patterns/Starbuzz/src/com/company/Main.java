package com.company;

public class Main {

    public static void main(String[] args) {

        Beverage order = new Americano();
        order = new Mocha(order);

        System.out.println(order.getDescription());
        System.out.println(order.cost());


        Beverage order2 = new Frappucinno();
        order2 = new Mocha(order2);

        System.out.println(order2.getDescription());
        System.out.println(order2.cost());
    }
}
