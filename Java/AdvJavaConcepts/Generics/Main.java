package com.company;

public class Main {

    public static void main(String[] args) {

        //any data type can be used for this list because there are no constraints
        var intArray = new GenericList<Integer>(12); 

        //Java is using boxing here because the add method takes an Integer instance but allows for an int primitive
        intArray.add(39);

        //this is unboxing, the value is stored in the intArray as an Integer but is casted to a primitive implicitly
        int firstElm = intArray.get(0);

        //this is fine because the constraint on this list is that is must be of a Number subclass
        var floatArr = new GenericListWithConstraints<Float>(3); 

        //this will return a compile time error because String does not fit within the generics constraints
        //var strArr = new GenericListWithConstraints<String>(7);

    }
}
