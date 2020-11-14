package com.yahtzee.game_src.players;

import com.yahtzee.game_src.dice.DiceRoller;

public class YahtzeePlayer {


    private static final int numberOfDicePerPlayer = 5;
    private static final int numberOfFacesPerDie = 6;

    private DiceRoller hand;
    private ScoreCard card;
    private String name;

    public YahtzeePlayer (String name) {
        this.name = name;
        card = new ScoreCard();
        hand = new DiceRoller(numberOfDicePerPlayer, numberOfFacesPerDie);
    }

    public void takeTurn() {



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
