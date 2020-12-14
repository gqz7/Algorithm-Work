package com.company;

public class Mocha extends Condiment {

    Beverage beverage;

    public Mocha (Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "Mocha, " + beverage.description;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.50;
    }
}
