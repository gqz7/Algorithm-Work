package com.yahtzee.game_src.players;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ScoreCard {

    //used in possibleCombos method to associate upper-section combos with an int/index
    private static final String[] upperSectionKeys = {"aces", "twos", "threes", "fours", "fives", "sixes"};
    //this class is centered around this hash-map that is a record keeper for all the players turns and the choices they've made
    private final Map<String, Combo> combinations = new HashMap<>();

    //the combinations can keep track of how many times the Yahtzee has gotten selected so after the first one this int will increment
    //this is also helpful because the bonuses are worth more than the first one
    private int yahtzeeBonuses;

    public ScoreCard () {
        yahtzeeBonuses = 0;
        initializeComboMap();
    }

    //make protected after testing
    public String[] getPossibleCombosChoices(int[] numbers ) {

        //it can't be known from the start of this method how many combos will be possible so its best to use a List
        List<String> combos = new ArrayList<>();

        //CHECK POSSIBLE UPPER-SECTION COMBOS
        for (int num = 0; num < 6; num++) {
            int lookingFor = num+1;
            //create an array of just a single int (1-6) in the given hand
            int[] foundNumbers = IntStream.of(numbers).filter(x -> x == lookingFor).toArray();

            //get the Combo key from the static array in this class
            String comboKey = upperSectionKeys[num];

            //grab the combo associated to the number
            Combo possibleCombo = combinations.get(comboKey);

            //if there are any matches of a number 1-6 then allow the counting of that number as a score.
            if ( foundNumbers.length > 0 && !possibleCombo.getHasBeenUsed()) {
                //this value can be overwritten in the next turn if not selected
                possibleCombo.setPointsValue(
                    //this is a simpler version of 'IntStream' line below because all the numbers in the array should be the same because of th .filter
                    foundNumbers.length * lookingFor
                    //IntStream.of(foundNumbers).sum() //adds all numbers together found in the DiceRoller after the turn
                );
                //add the possible selection to the list of choices the player can then choose from after this method runs
                combos.add( comboKey );
            }

            if ( foundNumbers.length == 5 ) {
                //yahtzee!
            }
        }

        //CHECK POSSIBLE LOWER SECTION COMBOS

        //check small straight


        //check large straight


        //check 3 of a kind


        //check 4 of a kind

        //check full house

        //change can always be used as long as it hasn't been used already
        Combo chanceCombo = combinations.get("cnc");
        if ( !chanceCombo.hasBeenUsed ) {
            //calculate the sum of all numbers in roll
            int chanceTotal = IntStream.of(numbers).sum();
            //set the points value
            chanceCombo.setPointsValue(chanceTotal);
            //add to possible selections
            combos.add("cnc");
        }

        return combos.toArray(String[]::new);
    }

    //make protected after testing
    public void makeChoice (String key) {
        //by running this method the current pointsValue will be locked in for this Combo and cant be changed
        combinations.get(key).useCombo();
    }

    protected int getYahtzeeBonuses() {
        return yahtzeeBonuses;
    }

    protected Map<String, Combo> getCombinations () {
        return combinations;
    }

    protected class Combo {

        ////this boolean will be important when tallying up all the combo points for the UpperSection bonus
        private final boolean isUpper;
        //in Yahtzee a combo can only be used once per game, hence the boolean
        private boolean hasBeenUsed;
        //this many be redundant
        private final String key;
        //each combo has different points, some are determined by the roll, some are static
        private int pointsValue;

        protected Combo( boolean isUpper, String key) {
            this.isUpper = isUpper;
            this.pointsValue = 0;
            this.key = key;
            hasBeenUsed = false;
        }

        //OVERLOAD - this is for the combos that will have static pointValue
        protected Combo( boolean isUpper, String key, int pointsValue) {
            this.pointsValue = pointsValue;
            this.isUpper = isUpper;
            this.key = key;
            hasBeenUsed = false;
        }

        protected String getKey() {
            return key;
        }

        protected boolean getIsUpper() {
            return isUpper;
        }

        protected int getPointsValue() { return pointsValue; }

        protected void setPointsValue(int points) {
            pointsValue = points;
        }

        protected boolean getHasBeenUsed () { return hasBeenUsed; }

        protected void useCombo () { hasBeenUsed = true; }

    }

    //these are all the 13 possible Yahtzee combos,
    // there isn't any fancy algorithmic way of creating this as far as I know. So I've hard coded them here
    private void initializeComboMap() {
        //UPPER
        combinations.put("aces", new Combo(true, "aces"));
        combinations.put("twos", new Combo(true, "twos"));
        combinations.put("threes", new Combo(true, "threes"));
        combinations.put("fours", new Combo(true, "fours"));
        combinations.put("fives", new Combo(true, "fives"));
        combinations.put("sixes", new Combo(true, "sixes"));
        //LOWER (some combos in the lower section have static point values to those are set by the constructor)
        combinations.put("smS", new Combo(false, "smS", 30));
        combinations.put("lgS", new Combo(false, "lgS", 40));
        combinations.put("fh",  new Combo(false, "fh", 25));
        combinations.put("yah", new Combo(false, "yah", 50));
        combinations.put("cnc", new Combo(false, "cnc"));
        combinations.put("3ok", new Combo(false, "3ok"));
        combinations.put("4ok", new Combo(false, "4ok"));
    }
}
