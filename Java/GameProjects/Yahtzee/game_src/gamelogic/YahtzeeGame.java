package com.yahtzee.game_src.gamelogic;

import com.yahtzee.game_src.players.YahtzeePlayer;

import java.util.ArrayList;
import java.util.List;

public class YahtzeeGame {

    private YahtzeePlayer[] players;

    private int numberOfTurns;

    private int numberOfPlayers;

    public YahtzeeGame ( ) {

        printWelcomeMsg();

        initializeGame();
        
    }

    private void playGame() {

        for (int turn = 0; turn < numberOfTurns; turn++) {
            for (int playerNum = 0; playerNum < numberOfPlayers; playerNum++) {

                players[playerNum].takeTurn();
            }
        }

        YahtzeeScoring.endGameReport(players);

        //ask players if they would like to play again, if they do the program will re-initialize the game
        boolean restartGame = YahtzeeCLI.playingAgain();

        if (restartGame) initializeGame();
        //if the user gets here the program will end
        System.out.println("\nThank you for using this Yahtzee simulation, hope you enjoyed!!\n\nprogram ending...");
    }

    private void initializeGame() {
        //get the basic game info from players (number of players and turns)
        int[] gameData = YahtzeeCLI.getGameData();

        numberOfPlayers = gameData[0];
        numberOfTurns = gameData[1];
        initializePlayers();

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
            players[i] = new YahtzeePlayer(playerName);
        }
    }

    private void printWelcomeMsg() {

        System.out.println("\n\n----------------------------------\n|\t\t\tYAHTZEE\t\t\t\t |\n|________________________________|\n");
        System.out.println("Welcome to this Yahtzee Java simulation\n\n");
    }

}
