package com.company;

import java.text.MessageFormat;
import java.util.*;

public class BreakingRecords implements Algorithm {

    private static final Scanner scanner = new Scanner(System.in);

    static int[] breakingRecords(int[] scores) {

        int highestScore = scores[0];
        int lowestScore = scores[0];

        //two ints to keep of how many times the high/low score have changed throught the series of games
        int numberHighScoreChanged = 0;
        int numberLowScoreChanged = 0;

        for ( int gameScore: scores ) {
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

        return new int[] {numberHighScoreChanged, numberLowScoreChanged};
    }

    @Override
    public void run() {
        printWelcomeMsg();

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) { int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        scanner.close();
    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nBREAKING RECORDS\n_____________________________\n\n");
    }
}

