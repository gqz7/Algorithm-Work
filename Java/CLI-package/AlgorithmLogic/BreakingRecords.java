package com.company.AlgorithmLogic;

import com.company.UI.CLI;

import java.text.MessageFormat;

public class BreakingRecords implements Algorithm {


    static float[] breakingRecords(float[] scores) {

        float highestScore = scores[0];
        float lowestScore = scores[0];

        //two ints to keep of how many times the high/low score have changed throught the series of games
        float numberHighScoreChanged = 0;
        float numberLowScoreChanged = 0;

        for ( float gameScore: scores ) {
            /*
                Sudo Code
                if the gameScore is GT highestScore, set the HS and increment the numHSChng
                if the gameScore is LT lowestScore, set the LS and increment the numLSChng
            */
            if (gameScore > highestScore ) { //a new highscore!
                highestScore = gameScore;
                numberHighScoreChanged++;
            } else if (gameScore < lowestScore) { //a new lowest score :(
                lowestScore = gameScore;
                numberLowScoreChanged++;
            }
        }

        return new float[] {numberHighScoreChanged, numberLowScoreChanged, highestScore, lowestScore};
    }

    @Override
    public void run() {
        printWelcomeMsg();

        int numberOfScores = CLI.numberIntQuestion("How many scores were recorded?", 2, 100);
        float[] scores = new float[numberOfScores];

        for (int i = 0; i < numberOfScores; i++) {
            scores[i] = CLI.numberFloatQuestion("\nEnter score #" + (i+1), -999_999_999, 999_999_999);
        }

        float[] result = breakingRecords(scores);

        System.out.println(
                "\n\nRESULTS\n___________\n\nThe High-Score was broken" +
                MessageFormat.format(" {0} times.\nThe Low-Score was broken {1} times\nFinal HS: {2}\nFinal LS: {3}",
                result[0], result[1], result[2], result[3])
        );

    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nBREAKING RECORDS\n_____________________________\n\n");

        System.out.println("This algorithm will count how many times your highest score and lowest score changed in a series of games/scores");
        System.out.println("First you will enter how many scores were recorded, then you will enter each score one at a time\n");
    }
}

