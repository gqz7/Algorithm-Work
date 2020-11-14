package com.yahtzee.game_src.gamelogic;

import com.yahtzee.game_src.players.YahtzeePlayer;

public class YahtzeeGame {

    private YahtzeePlayer[] players;

    private int numberOfTurns;

    private int numberOfPlayers;

    public YahtzeeGame ( ) {

        printWelcomMsg();

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
        boolean restartGame = YahtzeeCLI.isPlayingAgain();

        if (restartGame) initializeGame();
        //if the user gets here the program will end
        System.out.println("\nThank you for using this Yahtzee simulation, hope you enjoyed!!\n\nprogram ending...");
    }

    private void initializeGame() {
        //get the basic game info from players (number of players and turns)
        int[] gameData = YahtzeeCLI.getGameData();

        numberOfPlayers = gameData[0];
        numberOfTurns = gameData[1];
        players = new YahtzeePlayer[numberOfPlayers];

        //setup the players array and allow the players to enter their name
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("\nPlayer #" + (i+1) + " enter your name...");
            String playersName = YahtzeeCLI.getPlayerName();
            players[i] = new YahtzeePlayer(playersName);
        }

        playGame();

    }


    private void printWelcomMsg() {

        System.out.println("\n\n----------------------------------\n|\t\t\tYAHTZEE\t\t\t\t |\n|________________________________|\n");
        System.out.println("Welcome to this Yahtzee Java simulation\n\n");

    }

}
