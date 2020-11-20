package com.yahtzee.game_src.scorelogic.player;

import com.yahtzee.game_src.dice.DiceRoller;
import com.yahtzee.game_src.gamelogic.YahtzeeCLI;

import java.util.ArrayList;
import java.util.List;

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

    public void takeTurn() {
        turnSequence(startTurn());
    }

    public abstract void turnSequence( List<Integer> keepRolling );

    public abstract boolean pickTurnScore();

    public List<Integer> startTurn() {
        System.out.println("\n-----------------------------\n\tYour turn " + name + "!\n_____________________________\n");

        System.out.println("Current Score: " + score);

        //store which rolls the play wants to keep and which to re-roll;
        return new ArrayList<>();
    }


    public ScoreCard getCard() {
        return card;
    }

    @Override
    public String toString(){
        return name;
    }
}
