package com.yahtzee.game_src.players;

import com.yahtzee.game_src.players.ScoreCard;
import com.yahtzee.game_src.players.YahtzeePlayer;

import java.util.*;

public class YahtzeeScoring {

    public static void endGameReport(YahtzeePlayer[] allPlayers) {

        int highestScore = 0;

        List<YahtzeePlayer> winners = new ArrayList<>();

        for ( var player: allPlayers ) {

            int finalScore = tallyScore(player.getCard());

            if (finalScore > highestScore) {
                winners.clear();
                winners.add(player);

            } else if (finalScore == highestScore) winners.add(player);

            System.out.println(player + ": " + finalScore);

        }

        System.out.println("The Winners:\n\n" + Arrays.toString(winners.toArray()));

    }

    private static int tallyScore (ScoreCard scoreCard) {

        int upScore = 0;
        int lwScore = 0;

        for ( Map.Entry comboEntry : scoreCard.getCombinations().entrySet() ) {

            ScoreCard.Combo combo = (ScoreCard.Combo) comboEntry.getValue();

            if (combo.getHasBeenUsed()) {
                int comboScore = combo.getPointsValue();
                if (combo.getIsUpper())
                    upScore += comboScore;
                else
                    lwScore += comboScore;

            }

        }

        lwScore += scoreCard.getYahtzeeBonuses() * 100;

        if ( upScore > 63 ) upScore += 35;

        return lwScore + upScore;
    }

}
