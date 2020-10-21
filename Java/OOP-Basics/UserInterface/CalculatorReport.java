package com.company;

public class CalculatorReport {
    private Calculator calculator;

    //constructor dependency injection
    public CalculatorReport(Calculator calculator) {
        System.out.println("Making report");
        this.calculator = calculator;
    }
    //setter dep. injection
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void useCalculator( Calculator calculator ) {
        System.out.println("Your using your nogin!");
    }
}
