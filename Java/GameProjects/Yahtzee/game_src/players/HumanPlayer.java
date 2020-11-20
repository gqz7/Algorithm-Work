package com.yahtzee.game_src.players;

import com.yahtzee.game_src.gamelogic.YahtzeeCLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HumanPlayer extends YahtzeePlayer {

    public HumanPlayer(String name, boolean isDiceSelectionIndividual) {
        super(name, isDiceSelectionIndividual);
    }

    @Override
    public void takeTurn() {

        System.out.println("\n-----------------------------\n\tYour turn " + name + "!\n_____________________________\n");

        System.out.println("Current Score: " + score);

        //store which rolls the play wants to keep and which to re-roll;
        List<Integer> keepRolling = new ArrayList<>();

        for (int rolls = 1; rolls <= MAX_ROLLS; rolls++) {
            System.out.println("\n\nRoll #" + rolls + "\nRolling...\n");

            //roll all dice and pass indices of die/dice that should not be rolled
            hand.rollAllDice(keepRolling);

            int[] currentRollsValues = hand.getValues();

            YahtzeeCLI.displayCurrentRoll(name, currentRollsValues);

            //this will capture if the players turn is over, if rolls is not already at its limit, it will be set to it
            if (isTurnOver(rolls)) {
                rolls = MAX_ROLLS;
            } else {

                keepRolling.clear();

                if (isDiceSelectionIndividual) {
                    for (int i = 0; i < currentRollsValues.length; i++ )  {
                        int rolledNumber = currentRollsValues[i];
                        boolean holdDieNumber = YahtzeeCLI.keepRollingNumber(rolledNumber);
                        if (!holdDieNumber)
                            keepRolling.add(i);
                    }
                } else { //in this case the player will select the dice they want to re-roll as one input string
                    YahtzeeCLI.showDiceSelections(currentRollsValues);
                    String usersChoices =  YahtzeeCLI.getNumbersToKeepRolling();
                    List<Integer> keepers = parseMultipleDiceInput(usersChoices);
                    keepRolling.addAll(keepers);

                }
            }
        }

        System.out.println("Great job " + name + "! Your turn is now over.");
    }

    @Override
    public boolean pickTurnScore() {
        //use the current state of hand to determine this turns score and update the scorecard accordingly
        String[][] comboChoices = card.getPossibleCombosChoices( hand.getValues() );

        //if a player doesn't have any possible choices they get 0 points, ie the 'makeChoice' method doesn't need to run
        if (comboChoices.length == 0) {
            return false;
        }

        //this needs a minus one because the index will be minus one from their selection
        int comboIndex = YahtzeeCLI.chooseCombo(comboChoices) - 1;

        int turnPoints = card.makeChoice( comboChoices[comboIndex][0] );

        //add the points earned for this round
        score += turnPoints;

        return true;
    }

    private List<Integer> parseMultipleDiceInput(String usersChoices) {

        List<Integer> indices =
                Arrays.stream(
                        usersChoices
                                .replaceAll("\\D+", "") //regex to replace all the non number chars
                                .split(""))//split into the individual chars
                        .filter(str -> !str.equals(""))
                        .mapToInt(Integer::parseInt) //convert to numbers
//                    .forEach( System.out::println);
                        .filter(n -> n > 0 && n < 6) //filter out all number out of the possible range
                        .limit(5) //only allow the first 5 numbers input that were within the range
                        .map( n -> n-1) //set the values to their index equivalent
                        .boxed() //convert from regular list to List<Integer>
                        .collect(Collectors.toList()); //finally convert to a List

        return indices;
    }
}



