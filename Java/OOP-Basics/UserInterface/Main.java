package com.company;

public class Main {

    public static void main(String[] args) {

        TextBox inputName = new TextBox();
//        System.out.println(inputName.isEnabled());

//        UIControl testControl = new UIControl(false); //after making this class abstract it can not be instantiated

        inputName.setText("Billy Jean"); //sets the innerText field of the text box
//        System.out.println(inputName); //because the toString method has been overridden this should return the innerText field of the TextBox

//        castingObj(inputName);
//        castingObj(testControl);

        //example polymorphism
        UIControl[] allControls = { inputName, new CheckBox()};

        for (var control : allControls)
            control.render();

        //Interfaces & dependency injection

        //constructor injection / poor man's dep. injection
        Calculator2020 cal = new Calculator2020();
        CalculatorReport report = new CalculatorReport(cal);

        //setter injection
        //this approach is good if you need to change the dependencies of a class through the lifetime of an application
        Calculator2020 newCalculator = new Calculator2020();
        report.setCalculator(newCalculator);
        // report.useCalculator(); //if method injection wasnt being used a parameter would not need to be passed

        //method dependency injection, simply inject the dependency as a param
        report.useCalculator(newCalculator);

    }

    public static void castingObj ( UIControl obj) {
        if (obj instanceof TextBox) {
            ((TextBox) obj).setText("I was casted"); //this is an example of down-casting because the parent class is now casted to a child class
        }
        System.out.println(obj);

    }



}
