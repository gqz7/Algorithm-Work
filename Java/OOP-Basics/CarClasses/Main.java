package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var regularCar = new Car(100, "pink", "billy");
        regularCar.moveForward(27);
//        regularCar.toggleMovingForward();
//        regularCar.moveForward(2);
//        System.out.println(regularCar.xPosition);

        var myTruck = new Truck( 2000 );
        myTruck.moveForward(77);
//        myTruck.setCurrentLoad( 1000 );
//        System.out.println(myTruck.getCurrentLoad());

        System.out.println(myTruck.toString());
        System.out.println(regularCar.toString());
    }
}
