package com.yahtzee;

public class Die {
    public int currentValue;
    public int faces;

    public Die (int faces) {

        setFaces(faces);
        currentValue = 1;
    }

    public void roll() {
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
