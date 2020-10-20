package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var regularCar = new Car();
        regularCar.moveForward(10);
        regularCar.toggleMovingForward();
        regularCar.moveForward(2);

        System.out.println(regularCar.xPosition);

        var myTruck = new Truck( 2000 );
        myTruck.setCurrentLoad( 1000 );

        System.out.println(myTruck.getCurrentLoad());
    }
}
