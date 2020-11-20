package com.yahtzee.game_src.gamelogic;

import com.yahtzee.game_src.scorelogic.player.AIPlayer;
import com.yahtzee.game_src.scorelogic.player.HumanPlayer;
import com.yahtzee.game_src.scorelogic.player.YahtzeePlayer;
import com.yahtzee.game_src.scorelogic.YahtzeeScoring;

import java.util.ArrayList;
import java.util.List;

public class YahtzeeGame {

    private YahtzeePlayer[] players;

    private int numberOfTurns;

    private int numberOfPlayers;

    private boolean isDiceSelectionIndividual;

    public YahtzeeGame ( ) {

        YahtzeeCLI.printWelcomeMsg();

        initializeGame();

        //if the user gets here the program will end
        YahtzeeCLI.printExitMsg();
    }

    private void playGame() {

        for (int turn = 0; turn < numberOfTurns; turn++) {

            System.out.println("\n-----------------------------\n");
            System.out.println("\n\t-- TURN " + (turn+1) + " of " + numberOfTurns + " --\n");
            for (int playerNum = 0; playerNum < numberOfPlayers; playerNum++) {

                players[playerNum].takeTurn();
            }
        }

        YahtzeeScoring.endGameReport(players);

        //ask players if they would like to play again, if they do the program will re-initialize the game
        boolean restartGame = YahtzeeCLI.playingAgain();

        if (restartGame) initializeGame();
        //otherwise the call stack will continue on and the program will end
    }

    private void initializeGame() {
//        //get the basic game info from players (number of players and turns)
//        int[] gameData = YahtzeeCLI.getGameData();
//
//        isDiceSelectionIndividual = YahtzeeCLI.chooseDiceSelectionRule();
//
//        numberOfPlayers = gameData[0];
//        numberOfTurns = gameData[1];
//        initializePlayers();
//
        AiTesting();

        playGame();

    }

    private void initializePlayers() {
        players = new YahtzeePlayer[numberOfPlayers];

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

            players[i] = isHuman
                    ? new HumanPlayer(playerName, isDiceSelectionIndividual)
                    : new AIPlayer(playerName);
        }
    }

    private void AiTesting() {


        isDiceSelectionIndividual = true;

        numberOfPlayers = 2;
        numberOfTurns = 3;

        players = new YahtzeePlayer[2];
        players[0] = new AIPlayer("player1");
        players[1] = new AIPlayer("player2");
    }

}
