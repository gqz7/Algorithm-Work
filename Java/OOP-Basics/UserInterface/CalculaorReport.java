package com.company;

public class CalculaorReport {
    private Calculator calculator;

    //constructor dependency injection
    public CalculaorReport (Calculator calculator) {
        System.out.println("Making report");
        this.calculator = calculator;
    }
    //setter dep. injection
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
