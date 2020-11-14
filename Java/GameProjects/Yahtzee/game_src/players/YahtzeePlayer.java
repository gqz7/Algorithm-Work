package com.yahtzee.game_src.players;

import com.yahtzee.game_src.dice.DiceRoller;
import com.yahtzee.game_src.gamelogic.YahtzeeCLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YahtzeePlayer {


    private static final int numberOfDicePerPlayer = 5;
    private static final int numberOfFacesPerDie = 6;

    private final DiceRoller hand;
    private final ScoreCard card;
    private final String name;

    public YahtzeePlayer (String name) {
        this.name = name;
        card = new ScoreCard();
        hand = new DiceRoller(numberOfDicePerPlayer, numberOfFacesPerDie);
    }

    public void takeTurn() {
        System.out.println("\n______________________\nYour turn " + name + "!\n");

        //store which rolls the play wants to keep and which to re-roll;
        List<Integer> keepRolling = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));

        for (int rolls = 1; rolls <= 3; rolls++) {
            System.out.println("\n\nRoll #" + rolls + "\nRolling...\n");

            //rolling dice, because they are might not all be rolled,
            // this loop individually rolls each die, instead of using the DiceRollers rollAllDice method
            for ( int index : keepRolling ) { hand.rollDie(index); }

            int[] values = hand.getValues();
            System.out.println(name + ", you rolled: " + Arrays.toString(values));

            if (rolls == 3)
                pickTurnScore();
            else {
                keepRolling.clear();
                for ( int i = 0; i < values.length; i++ )  {
                    int rolledNumber = values[i];
                    boolean keepRollingNumber = YahtzeeCLI.keepRollingNumber(rolledNumber);
                    if (keepRollingNumber)
                        keepRolling.add(i);
                }
            }

        }

        System.out.println("Your turn is over " + name);


    }

    private void pickTurnScore() {
        //use the current state of hand to determine this turns score and update the scorecard accordingly
    }

    public String getName() {
        return name;
    }

    public ScoreCard getCard() {
        return card;
    }

    @Override
    public String toString(){
        return name + ": " + card.getFinalScore();
    }
}
