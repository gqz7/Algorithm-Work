package com.company;

public class SportsCar extends Car {
    boolean hasSpoiler;
    String engineType;

    SportsCar ( boolean spoiler, String engineType ) {
        this.hasSpoiler = spoiler;
        this.engineType = engineType;
    }

    public void toggleHasSpoiler () {
        this.hasSpoiler = !this.hasSpoiler;
    }

    public void changeEngineType ( String type ) {
        this.engineType =  type;
    }

}
