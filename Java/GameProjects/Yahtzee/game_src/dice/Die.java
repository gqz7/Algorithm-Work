package com.yahtzee.game_src.dice;

public class Die {
    protected int currentValue;
    protected int faces;

    protected Die (int faces) {
        setFaces(faces);
        currentValue = 1;
    }

    protected void roll() {
        currentValue = (int) (faces * Math.random());
    }

    private void setFaces (int numberOfFaces ) throws IllegalArgumentException {
        if (numberOfFaces > 0 && numberOfFaces <= 100) {
            faces = numberOfFaces;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
