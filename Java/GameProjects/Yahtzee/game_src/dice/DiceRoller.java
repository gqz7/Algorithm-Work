package com.yahtzee.game_src.dice;

import java.util.ArrayList;
import java.util.List;

public class DiceRoller {
    //the only purpose of this class is to manipulate a collection of Die
    private final List<GameDie> dice;

    //this constructor is used when the dice needed all have the same number of faces
    public DiceRoller ( int numberOfDice, int numberOfFaces ) throws IllegalArgumentException {

        if (numberOfDice < 1 || numberOfDice > 1000) {
            System.out.println("Number of dice given to DiceRoller not accepted (1-1000)");
            throw new IllegalArgumentException();
        }

        dice = new ArrayList<>();

        for (int i = 0; i < numberOfDice; i++) {
            dice.add(new GameDie(numberOfFaces));
        }

    }

    //this overload method would be used in a more complex dice game like D&D
    public DiceRoller ( int numberOfDice, int[] diceFaces ) throws IllegalArgumentException {

        //im setting an arbitrary limit of 1000 here so that a ridiculous number of Die don't get instantiated by accident
        if (numberOfDice < 1 || numberOfDice > 1000) {
            System.out.println("DICE ROLLER ERR: Number of dice given to DiceRoller not accepted (1-1000)");
            throw new IllegalArgumentException();
        }

        if (numberOfDice != diceFaces.length) {
            System.out.println(
                "DICE ROLLER ERR: An array of face numbers was passed whose length did not match the number of dice"
            );
            throw new IllegalArgumentException();
        }

        dice = new ArrayList<>();

        for (int i = 0; i < numberOfDice; i++) {
            dice.add(new GameDie(diceFaces[i]));
        }

    }

    //randomizes each die in the dice roller
    public void rollAllDice(){

        for ( GameDie d : dice ) {
            d.roll();
        }

    };

    //roll just one die, this is important to have access to for Yahtzee
    public void rollDie(int index){
        if (index >= 0 && index < dice.size()) {
            dice.get(index).roll();
        }
    }

    //get all the dice values at once
    public int[] getValues() {
        int[] allValues = new int[dice.size()];

        for (int i = 0; i < dice.size(); i++) {
            allValues[i] = dice.get(i).currentValue;
        }

        return allValues;
    }

    //get one die value by index
    public int getDieValue( int index ) throws IllegalArgumentException{
        if (index < 0 || index >= dice.size() ) {
            throw new IllegalArgumentException();
        }
        return dice.get(index).currentValue;
    }

}
