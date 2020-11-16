package com.yahtzee.game_src.players;

import java.util.*;

public class YahtzeeScoring {

    public static void endGameReport(YahtzeePlayer[] allPlayers) {

        System.out.println("\n______________________________________\n");
        System.out.println("The Game Is Over! Let's See Who Won\n\n\tSCORES:\n");

        int highestScore = 0;

        List<YahtzeePlayer> winners = new ArrayList<>();

        //iterate through all players in the game
        for ( YahtzeePlayer player: allPlayers ) {

            //get the players total score
            int finalScore = tallyScore(player.getCard());

            //check if the player got the highest score or tied
            if (finalScore > highestScore) {
                highestScore = finalScore;
                winners.clear();
                winners.add(player);

            } else if (finalScore == highestScore) winners.add(player);

            //print out each player and their score (in the order the players were entered)
            System.out.println("\t" + player + ": " + finalScore);

        }

        //PRINT OUT THE WINNERS
        System.out.println("\n______________________________________\n");
        System.out.println( "\nThe " + ( winners.size() > 1 ? "Winners Are" : "Winner Is" ) + "...\n");
        for ( YahtzeePlayer name : winners) System.out.println("\t" + name);
        System.out.println("\n\n______________________________________\n");

    }

    private static int tallyScore (ScoreCard scoreCard) {

        int upScore = 0;
        int lwScore = 0;

        //convert the Combo HashMap into something iterable
        for ( Map.Entry comboEntry : scoreCard.getCombinations().entrySet() ) {

            //get the value of the HM, the Combo object
            ScoreCard.Combo combo = (ScoreCard.Combo) comboEntry.getValue();

            //if the combo has been used it was at once point a selection by that player in the game
            if (combo.getHasBeenUsed()) {
                //get the points and add to the right section
                int comboScore = combo.getPointsValue();
                if (combo.getIsUpper())
                    upScore += comboScore;
                else
                    lwScore += comboScore;

            }

        }
        //add up the Yahtzee bonuses
        lwScore += scoreCard.getYahtzeeBonuses() * 100;
        //add the upper section bonus if they got it
        if ( upScore >= 63 ) upScore += 35;

        return lwScore + upScore;
    }

}
