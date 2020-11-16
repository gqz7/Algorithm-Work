package com.yahtzee.game_src;

public enum ComboKeys {
    ACES,
    TWOS,
    THREES,
    FOURS,
    FIVES,
    SIXES,
    TOAK,
    FOAK,
    FLHO,
    CHNC,
    SMST,
    LGST,
    YATZ;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}