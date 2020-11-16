package com.yahtzee.game_src;

public enum ComboKeys {
    ACES,
    TWOS,
    THREES,
    FOURS,
    FIVES,
    SIXES,
    TOAK, //Three of a Kind
    FOAK, //Four of a Kind
    FLHO, //Full House
    CHNC, //Chance
    SMST, //Small Straight
    LGST, //Large Straight
    YATZ; //Yahtzee

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}