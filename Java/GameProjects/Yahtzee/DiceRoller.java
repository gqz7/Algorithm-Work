package com.yahtzee;

public class DiceRoller {
    private Die[] dice;

    public DiceRoller ( int numberOfDice, int numberOfFaces ) {

        if (numberOfDice < 1 || numberOfDice > 1000) numberOfDice = 1;

        dice = new Die[numberOfDice];

        for (int i = 0; i < numberOfDice; i++) {
            dice[i] = new Die(numberOfFaces);
        }

    }

    public void rollDice(){

        for ( Die d : dice ) {
            d.roll();
        }

    };

    public void rollDie(int index){
        if (index >= 0 && index < dice.length) {
            dice[index].roll();
        }
    }

    public int[] getValues() {
        int[] allValues = new int[dice.length];

        for (int i = 0; i < dice.length; i++) {
            allValues[i] = dice[i].currentValue;
        }

        return allValues;
    }

}
