package com.yahtzee.game_src.scorelogic.player;

import com.yahtzee.game_src.gamelogic.YahtzeeCLI;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AIPlayer extends YahtzeePlayer {

    private String aiComboChoice;

    public AIPlayer (String name) {
        super(name, true);
    }

    @Override
    public void turnSequence(List<Integer> keepRolling) {

        boolean endTurnEarly = false;
        for (int rolls = 1; rolls <= MAX_ROLLS && !endTurnEarly; rolls++) {
            hand.rollAllDice(keepRolling);

            int[] currentRollsValues = hand.getValues();
            System.out.println(name + " rolled: " + Arrays.toString(currentRollsValues));

            String[][] comboChoices = card.getPossibleCombosChoices( currentRollsValues );

            String[] bestCombo = getHighestCombo(comboChoices);
            int maxPoints = Integer.parseInt(bestCombo[1]);

            if (maxPoints >= 20 || rolls == 3 && maxPoints != 0) {
                //The AI has a choice that can end the turn
                String comboPhrase = YahtzeeCLI.getComboPhrase(bestCombo[0]);
                System.out.println(MessageFormat.format("\n{0} chose {1} for {2} points!", name, comboPhrase, maxPoints));

                endTurnEarly = true;
                aiComboChoice = bestCombo[0];
                pickTurnScore();

            } else if (rolls == 3) {
                System.out.println( name + " got 0 points this round");
            }

        }
    }


    private String[] getHighestCombo(String[][] comboChoices) {
            //calculate the highest score one can get with the current rollm
            //        int highestPointsCombo =
            //        OptionalInt max = Arrays
            //                .stream(comboChoices)
            //                .map(str -> str[1].replaceAll("\\D+", ""))
            //                .mapToInt(Integer::parseInt)
            //                .max();

        List<String[]>
            comboList =
                Arrays
                    .stream(comboChoices)
                    .map(str -> new String[] { str[0], str[1].replaceAll("\\D+", "") })
                    .sorted(Comparator.comparing((String[] e) -> Integer.parseInt(e[1])))
                    .collect(Collectors.toList());
        Collections.reverse(comboList);

        return comboList.size() > 0 ? comboList.get(0) : new String[] {"", "0"};
    }


    @Override
    public boolean pickTurnScore() {
        int rollPoints = card.makeChoice(aiComboChoice);
        score += rollPoints;
        return true;
    }

}
