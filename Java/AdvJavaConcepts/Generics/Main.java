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
        var floatArr = new GenericNumberList<Float>(13);

        //this will return a compile time error because String does not fit within the generics constraints
        //var strArr = new GenericListWithConstraints<String>(7);

        //using the comparable interface
        var userOne = new User(3);
        var userTwo = new User(7);

        var pointCompare = userOne.compareTo(userTwo);
        if (pointCompare > 1) {
            System.out.println("userOne has more points");
        } else if ( pointCompare == 0) {
            System.out.println("Users have the same points.");
        } else {
            System.out.println("userOne has less points");
        }

        //using a utils class to create a generic method and get the user's points who has the max value
        int maxUserPoints = Utils.max(userOne.points, userTwo.points);
        System.out.println("The max user points is: " + maxUserPoints);

        //using utils to show generic methods with more than one generic type
        Utils.print(userTwo.username, userTwo.points);

        //testing the new Utils method and the admin class
        Admin firstAdmin = new Admin();

        var allUsers = new GenericComparableList(3);
        allUsers.add(userOne);
        allUsers.add(userTwo);
        allUsers.add(firstAdmin);

        Utils.printUsers(allUsers);
    }
}
