package com.yahtzee.game_src.gamelogic;

import com.yahtzee.ui.CLI;

import java.util.HashMap;
import java.util.Map;

public class YahtzeeCLI {

    private final static String numOfTurnsQuestion = "\nHow many turns would you like this game of Yahtzee to be? (13 is recommended)";
    private final static String numOfPlayersQuestion = "\nHow many players would you like this game of Yahtzee to have?";
    private final static String restartQuestion = "\nThat was fun! Would you like to play another game?";
    private final static String keepRollingDieQuestion = "Would you like to keep rolling ";
    private final static String comboQuestion = "Choose one of the scoring combinations above";
    private final static String nameQuestion = "What what is your name?";

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

    public static boolean playingAgain() {
        return CLI.yesOrNo(restartQuestion);
    }

    public static boolean keepRollingNumber(int num ) { return CLI.yesOrNo(keepRollingDieQuestion + num + "?"); }

    public static int chooseCombo (String[] choices) {
        System.out.println("\n\t- Select A Scoring Combination -");
        for (int i = 0; i < choices.length; i++) {
            String displayText = COMBO_MAP.get( choices[i] );
            System.out.println( (i+1) + ") " + displayText);
        }

        return CLI.numberIntQuestion(comboQuestion, 1, choices.length);
    }

    //this hash map get used when a player is selecting a choice.
    // the method will be given keys from ScoreCard and passed to the player, then to this CLI
    private static final Map<String, String> COMBO_MAP = new HashMap<>() {{
        //upper
        put("aces", "Total of Aces");
        put("twos", "Total of Twos");
        put("threes", "Total of Threes");
        put("fours", "Total of Fours");
        put("fives", "Total of Fives");
        put("sixes", "Total of Sixes");
        //lower
        put("smS", "Small Straight");
        put("lgS", "Large Straight");
        put("fh", "Full House");
        put("yah", "YAHTZEE");
        put("cnc", "Chance (sum of all dice)");
        put("3ok", "Three of a Kind");
        put("4ok", "Four of a Kind");
    }};
}
