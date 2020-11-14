package com.yahtzee.game_src.gamelogic;

import com.yahtzee.game_src.players.YahtzeePlayer;

import java.util.ArrayList;
import java.util.List;

public class YahtzeeScoring {
    public static void endGameReport(YahtzeePlayer[] allPlayers) {

        int highestScore = 0;

        List<YahtzeePlayer> winners = new ArrayList<>();

        for ( var player: allPlayers ) {

            int finalScore = player.getCard().getFinalScore();

            if (finalScore > highestScore) {
                winners.clear();
                winners.add(player);

            } else if (finalScore == highestScore) winners.add(player);

        }

        System.out.println("The Winners:\n\n" + winners.toArray() );

    }
}
