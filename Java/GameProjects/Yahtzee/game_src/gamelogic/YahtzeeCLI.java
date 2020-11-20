package com.yahtzee.game_src.gamelogic;

import com.yahtzee.game_src.ComboKeys;
import com.yahtzee.ui.CLI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class YahtzeeCLI {

    private final static String DICE_SELECTION_QUESTION = "\nThroughout the game, would you like to select dice to re-roll individually?\n(otherwise you will have to specify re-rolling dice all at once)";
    private final static String NUM_OF_TURNS_QUESTION = "\nHow many turns would you like this game of Yahtzee to be? (13 is recommended)";
    private final static String NUM_OF_PLAYERS_QUESTION = "\nHow many players would you like this game of Yahtzee to have?";
    private final static String RESTART_QUESTION = "\nThat was fun! Would you like to play another game?";
    private final static String KEEP_ROLLING_DIE_QUESTION = "Would you like to keep rolling ";
    private final static String KEEP_ROLLING_MULTIPLE_QUESTION = "\nEnter the numbers associated to the die/dice you would like to HOLD this roll...";
    private final static String KEEP_ROLLING_MULTIPLE_INTRO = "\n You can select the die/dice you would like to HOLD by typing in the number to the left of die/dice roll/s you got\n";
    private final static String IS_HUMAN_PLAYER_QUESTION = "\nIs this a human controlled player?";
    private final static String COMBO_QUESTION = "Choose one of the scoring combinations above";
    private final static String NAME_QUESTION = "What what is your name?";
    private final static String END_TURN_QUESTION = "Would you like to end your turn now?";

    private final static int MAX_TURNS = 13;
    private final static int MIN_TURNS = 1;
    private final static int MAX_PLAYERS = 10;
    private final static int MIN_PLAYERS = 2;

    public static int[] getGameData() {
        return new int[] {
            getNumberOfPlayers(),
            getNumberOfTurns()
        };
    }

    private static int getNumberOfTurns() {
        return CLI.numberIntQuestion(NUM_OF_TURNS_QUESTION, MIN_TURNS, MAX_TURNS);
    }

    private static int getNumberOfPlayers() {
        return CLI.numberIntQuestion(NUM_OF_PLAYERS_QUESTION, MIN_PLAYERS, MAX_PLAYERS);
    }

    public static String getPlayerName() {
        return CLI.stringQuestion(NAME_QUESTION);
    }

    public static boolean playingAgain() {
        return CLI.yesOrNo(RESTART_QUESTION);
    }

    public static boolean keepRollingNumber(int num ) { return CLI.yesOrNo(KEEP_ROLLING_DIE_QUESTION + num + "?"); }

    public static int chooseCombo (String[][] choices) {
        System.out.println("\n- Select A Scoring Combination -\n");
        for (int i = 0; i < choices.length; i++) {
            String displayText = COMBO_MAP.get( choices[i][0] ) + choices[i][1];
            System.out.println( (i+1) + ") " + displayText);
        }

        return CLI.numberIntQuestion(COMBO_QUESTION, 1, choices.length);
    }

    public static boolean chooseDiceSelectionRule() { return CLI.yesOrNo(DICE_SELECTION_QUESTION); }

    private static final String ACES = ComboKeys.ACES.toString();
    private static final String TWOS = ComboKeys.TWOS.toString();
    private static final String THREES = ComboKeys.THREES.toString();
    private static final String FOURS = ComboKeys.FOURS.toString();
    private static final String FIVES = ComboKeys.FIVES.toString();
    private static final String SIXES = ComboKeys.SIXES.toString();
    private static final String TOAK = ComboKeys.TOAK.toString();
    private static final String FOAK = ComboKeys.FOAK.toString();
    private static final String FLHO = ComboKeys.FLHO.toString();
    private static final String CHNC = ComboKeys.CHNC.toString();
    private static final String SMST = ComboKeys.SMST.toString();
    private static final String LGST = ComboKeys.LGST.toString();
    private static final String YATZ = ComboKeys.YATZ.toString();

    //this hash map get used when a player is selecting a choice.
    // the method will be given keys from ScoreCard and passed to the player, then to this CLI
    private static final Map<String, String> COMBO_MAP = new HashMap<>() {{
        //upper
        put(ACES, "Total of Aces");
        put(TWOS, "Total of Twos");
        put(THREES, "Total of Threes");
        put(FOURS, "Total of Fours");
        put(FIVES, "Total of Fives");
        put(SIXES, "Total of Sixes");
        //lower
        put(SMST, "Small Straight");
        put(LGST, "Large Straight");
        put(FLHO, "Full House");
        put(YATZ, "YAHTZEE");
        put(CHNC, "Chance");
        put(TOAK, "Three of a Kind");
        put(FOAK, "Four of a Kind");
    }};

    public static boolean endTurn() {
        return CLI.yesOrNo(END_TURN_QUESTION);
    }

    public static void printWelcomeMsg() {
        System.out.println("\n\n----------------------------------\n|\t\t\tYAHTZEE\t\t\t\t |\n|________________________________|\n");
        System.out.println("Welcome to this Yahtzee Java simulation\n\n");
    }

    public static void printExitMsg() {
        System.out.println("\n\n\nThank you for using this Yahtzee simulation, hope you enjoyed!!\n\nprogram ending...");
    }

    public static String getNumbersToKeepRolling() {
        return CLI.stringQuestion(KEEP_ROLLING_MULTIPLE_QUESTION);
    }

    public static void showDiceSelections(int[] currentRollsValues) {
        System.out.println(KEEP_ROLLING_MULTIPLE_INTRO);
        for (int i = 0; i < currentRollsValues.length; i++) {
            System.out.println((i+1) + ") " + currentRollsValues[i]);
        }
    }

    public static void displayCurrentRoll(String name, int[] currentRollsValues) {

         System.out.println(name + ", you rolled: \n");
         Arrays.stream(currentRollsValues)
                         .forEach( diceVal -> System.out.print("[" + diceVal + "] "));
         System.out.println("\n");
    }

    public static boolean isHumanPlayer() {
        return CLI.yesOrNo(IS_HUMAN_PLAYER_QUESTION);
    }
}
