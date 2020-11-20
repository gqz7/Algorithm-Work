package com.yahtzee.game_src.scorelogic;

import com.yahtzee.game_src.scorelogic.player.ScoreCard;
import com.yahtzee.game_src.scorelogic.player.YahtzeePlayer;

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
            int finalScore = player.getCard().tallyScore();

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
        System.out.println( "\n\tThe " + ( winners.size() > 1 ? "Winners Are" : "Winner Is" ) + "...\n");
        for ( YahtzeePlayer name : winners) System.out.println("\t" + name);
        System.out.println("\n\tWith a total of " + highestScore + " points!!");
        System.out.println("\n\n______________________________________\n");

    }



}
