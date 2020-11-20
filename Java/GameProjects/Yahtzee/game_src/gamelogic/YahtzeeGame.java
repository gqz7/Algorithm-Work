package com.yahtzee.game_src.gamelogic;

import com.yahtzee.game_src.scorelogic.player.AIPlayer;
import com.yahtzee.game_src.scorelogic.player.HumanPlayer;
import com.yahtzee.game_src.scorelogic.player.YahtzeePlayer;
import com.yahtzee.game_src.scorelogic.YahtzeeScoring;

import java.util.ArrayList;
import java.util.List;

public class YahtzeeGame {

    private List<YahtzeePlayer> players;

    private int numberOfTurns;

    private int numberOfPlayers;

    private boolean isDiceSelectionIndividual;

    public YahtzeeGame ( ) {

        YahtzeeCLI.printWelcomeMsg();

        players = new ArrayList<>();
        initializeGame();
//        initializeAITesting(10);
        playGame();

        //if the user gets here the program will end
        YahtzeeCLI.printExitMsg();

    }

    private void playGame() {

        for (int turn = 0; turn < numberOfTurns; turn++) {

            System.out.println("\n-----------------------------\n");
            System.out.println("\n\t-- TURN " + (turn+1) + " of " + numberOfTurns + " --\n");
            for (int playerNum = 0; playerNum < numberOfPlayers; playerNum++) {

                players.get(playerNum).takeTurn();
            }
        }

        var playersAsArray = players.toArray(new YahtzeePlayer[0]);

        YahtzeeScoring.endGameReport(playersAsArray);

        //ask players if they would like to play again, if they do the program will re-initialize the game
        boolean restartGame = YahtzeeCLI.playingAgain();

        if (restartGame) initializeGame();
        //otherwise the call stack will continue on and the program will end
    }

    private void initializeGame() {
        //get the basic game info from players (number of players and turns)
        int[] gameData = YahtzeeCLI.getGameData();

        isDiceSelectionIndividual = YahtzeeCLI.chooseDiceSelectionRule();

        numberOfPlayers = gameData[0];
        numberOfTurns = gameData[1];
        initializePlayers();

    }

    private void initializePlayers() {

        List<String> playerNames = new ArrayList<>();
        //setup the players array and allow the players to enter their name
        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = "";
            while (true) {
                System.out.println("\nPlayer #" + (i+1) + " enter your name...");
                playerName = YahtzeeCLI.getPlayerName();
                if (playerNames.contains(playerName))
                    System.out.println("\nSomeone already entered '" + playerName + "', try something else.");
                else {
                    playerNames.add(playerName);
                    break;
                }
            }

            boolean isHuman = YahtzeeCLI.isHumanPlayer();

            players.add(
                isHuman
                    ? new HumanPlayer(playerName, isDiceSelectionIndividual)
                    : new AIPlayer(playerName)
            );
        }
    }

    //preforms an AI vs AI regular 13 turn game. just for testing
    private void initializeAITesting(int totalAIPlayers) {

        isDiceSelectionIndividual = true;
        numberOfPlayers = totalAIPlayers;
        numberOfTurns = 13;

        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(  new AIPlayer("player" + (i+1)));
        }
    }

}
