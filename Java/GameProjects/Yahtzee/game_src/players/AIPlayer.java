package com.yahtzee.game_src.players;

public class AIPlayer extends YahtzeePlayer {
    public AIPlayer (String name) {
        super(name, true);
    }

    @Override
    public void takeTurn() {

    }

    @Override
    public boolean pickTurnScore() {
        return false;
    }
}
