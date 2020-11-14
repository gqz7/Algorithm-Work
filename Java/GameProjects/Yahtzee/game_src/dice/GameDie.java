package com.yahtzee.game_src.dice;

public class GameDie {
    protected int currentValue;
    protected int faces;

    protected GameDie(int faces) {
        setFaces(faces);
        currentValue = 1;
    }

    protected void roll() {
        currentValue = (int) (faces * Math.random() + 1);
    }

    private void setFaces (int numberOfFaces ) throws IllegalArgumentException {
        if (numberOfFaces > 0 && numberOfFaces <= 100) {
            faces = numberOfFaces;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
