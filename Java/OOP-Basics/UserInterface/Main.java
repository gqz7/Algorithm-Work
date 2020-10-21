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
    }

    public static void castingObj ( UIControl obj) {
        if (obj instanceof TextBox) {
            ((TextBox) obj).setText("I was casted"); //this is an example of down-casting because the parent class is now casted to a child class
        }
        System.out.println(obj);

    }
}
