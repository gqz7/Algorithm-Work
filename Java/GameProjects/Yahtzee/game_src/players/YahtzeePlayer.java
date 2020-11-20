package com.yahtzee.game_src.players;

import com.yahtzee.game_src.dice.DiceRoller;
import com.yahtzee.game_src.gamelogic.YahtzeeCLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class YahtzeePlayer {
    protected static final int MAX_ROLLS = 3;
    protected static final int NUMBER_OF_DICE_PER_PLAYER = 5;
    protected static final int NUMBER_OF_FACES_PER_DIE = 6;
    protected final boolean isDiceSelectionIndividual;
    protected final DiceRoller hand;
    protected final ScoreCard card;
    protected final String name;
    protected int score;

    public YahtzeePlayer (String name, boolean isDiceSelectionIndividual) {
        this.name = name;
        this.isDiceSelectionIndividual = isDiceSelectionIndividual;
        score = 0;
        card = new ScoreCard();
        hand = new DiceRoller(NUMBER_OF_DICE_PER_PLAYER, NUMBER_OF_FACES_PER_DIE);
    }

    public abstract void takeTurn();

    public abstract boolean pickTurnScore();

    protected boolean isTurnOver(int currentRoll) {
        //allow the user to end their turn prematurely
        boolean endTurn = false;
        //this check that it makes sense to ask them if they want to end their turn,
        // if they're on their last roll it makes no sense to ask this question
        if (currentRoll != MAX_ROLLS) {
            endTurn = YahtzeeCLI.endTurn();
        }

        if (currentRoll == MAX_ROLLS || endTurn) { //end the turn, either by choice or because rolls are done

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
                return true; //this will get triggered if one ends their turn early and they made a selection
            }

        }
        return false;
    }


    public ScoreCard getCard() {
        return card;
    }

    @Override
    public String toString(){
        return name;
    }
}
