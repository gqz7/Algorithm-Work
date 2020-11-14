package com.yahtzee.game_src.gamelogic;

import com.yahtzee.ui.CLI;

public class YahtzeeCLI {

    private final static String numOfTurnsQuestion = "\nHow many turns would you like this game of Yahtzee to be? (a standard game is 13)";
    private final static String numOfPlayersQuestion = "\nHow many players would you like this game of Yahtzee to have?";
    private final static String nameQuestion = "What what is your name?";
    private final static String restartQuestion = "\nThat was fun! Would you like to play another game?";

    private final static int maxTurns = 30;
    private final static int minTurns = 1;
    private final static int maxPlayers = 10;
    private final static int minPlayers = 2;

    public static int[] getGameData() {
        return new int[] {
            getNumberOfPlayers(),
            getNumberOfTurns()
        };
    }

    private static int getNumberOfTurns() {
        return CLI.numberIntQuestion( numOfTurnsQuestion, minTurns, maxTurns );
    }

    private static int getNumberOfPlayers() {
        return CLI.numberIntQuestion( numOfPlayersQuestion, minPlayers, maxPlayers );
    }

    public static String getPlayerName() {
        return CLI.stringQuestion(nameQuestion);
    }

    public static boolean isPlayingAgain() {
        return CLI.yesOrNo(restartQuestion);
    }
}
