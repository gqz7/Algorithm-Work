package com.yahtzee.game_src.players;

import com.yahtzee.game_src.dice.DiceRoller;
import com.yahtzee.game_src.gamelogic.YahtzeeCLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YahtzeePlayer {
    private static final int MAX_ROLLS = 3;
    private static final int NUMBER_OF_DICE_PER_PLAYER = 5;
    private static final int NUMBER_OF_FACES_PER_DIE = 6;

    private final DiceRoller hand;
    private final ScoreCard card;
    private final String name;
    private int score;

    public YahtzeePlayer (String name) {
        this.name = name;
        score = 0;
        card = new ScoreCard();
        hand = new DiceRoller(NUMBER_OF_DICE_PER_PLAYER, NUMBER_OF_FACES_PER_DIE);
    }

    public void takeTurn() {
        System.out.println("\n-----------------------------\n\tYour turn " + name + "!\n_____________________________\n");

        System.out.println("Current Score: " + score);

        //store which rolls the play wants to keep and which to re-roll;
        List<Integer> keepRolling = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));

        for (int rolls = 1; rolls <= MAX_ROLLS; rolls++) {
            System.out.println("\n\nRoll #" + rolls + "\nRolling...\n");

            //rolling dice, because they are might not all be rolled,
            // this loop individually rolls each die, instead of using the DiceRollers rollAllDice method
            for ( int index : keepRolling ) { hand.rollDie(index); }

            int[] values = hand.getValues();
            System.out.println(name + ", you rolled: \n" + Arrays.toString(values) + "\n");

            //allow the user to end their turn prematurely
            boolean endTurn = false;
            //this check that it makes sense to ask them if they want to end their turn,
            // if they're on their last roll it makes no sense to ask this question
            if (rolls != MAX_ROLLS) {
                endTurn = YahtzeeCLI.endTurn();
            }


            if (rolls == MAX_ROLLS || endTurn) { //end the turn, either by choice or because rolls are done

                //i updated this method to return a boolean because if a user has more rolls
                // but they decide to end their turn early and they have no option it would be nice to be allowed to roll again
                // rather than be given a zero because you thought you would have options when you didn't
                //if this boolean is false that means they were not able to make a selection because there were no options
                boolean hadOptions = pickTurnScore();

                if (!hadOptions && endTurn ) { //only if they have more rolls left will they see this
                    System.out.println("\nYou are ouf of options right now, but you can roll again");
                } else if ( !hadOptions ) {
                    System.out.println("\nSorry your all out of options this round, better luck next time!");
                } else {
                    rolls = MAX_ROLLS; //this will get triggered if one ends their turn early and they made a selection
                }

            } else {
                keepRolling.clear();
                for ( int i = 0; i < values.length; i++ )  {
                    int rolledNumber = values[i];
                    boolean keepRollingNumber = YahtzeeCLI.keepRollingNumber(rolledNumber);
                    if (keepRollingNumber)
                        keepRolling.add(i);
                }
            }

        }

        System.out.println("Great job " + name + "! Your turn is now over.");

    }

    private boolean pickTurnScore() {
        //use the current state of hand to determine this turns score and update the scorecard accordingly
        String[] comboChoices = card.getPossibleCombosChoices( hand.getValues() );

        //if a player doesn't have any possible choices they get 0 points, ie the 'makeChoice' method doesn't need to run
        if (comboChoices.length == 0) {
            return false;
        }

        //this needs a minus one because the index will be minus one from their selection
        int comboIndex = YahtzeeCLI.chooseCombo(comboChoices) - 1;

        int turnPoints = card.makeChoice( comboChoices[comboIndex] );

        //add the points earned for this round
        score += turnPoints;

        return true;

    }

    public ScoreCard getCard() {
        return card;
    }

    @Override
    public String toString(){
        return name;
    }
}
