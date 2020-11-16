package com.yahtzee.game_src.players;

import com.yahtzee.game_src.ComboKeys;

import java.util.*;
import java.util.stream.IntStream;

public class ScoreCard {

    /*
        The ScoreCard is what keeps a record of the players game, the main piece of data here is the HashMap that scores Combos
        each Combo represents the 13 possible score combinations you can get in Yahtzee
        each as a key attached to them in the HashMap. At first I just entered the string literals,
        then I tried enums but didn't like how mess the code got.
        finally I settled with static constants which is much safer than string literals all over.
        my only problem with this approach is that it makes the top of this class look a bit messy
    */

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

    //used in possibleCombos method to associate upper-section combos with an int/index
    private static final String[] upperSectionKeys = {ACES, TWOS, THREES, FOURS, FIVES, SIXES};

    //this class is centered around this hash-map that is a record keeper for all the players turns and the choices they've made
    private final Map<String, Combo> combinations = new HashMap<>();

    //the combinations can keep track of how many times the Yahtzee has gotten selected so after the first one this int will increment
    //this is also helpful because the bonuses are worth more than the first one
    private int yahtzeeBonuses;

    //static point values for the combinations whose point values don't change
    private static final int yahtzeeBonusPoints = 100;
    private static final int yahtzeeRegularPoints = 50;
    private static final int fullHousePoints = 25;
    private static final int smallStraightPoints = 30;
    private static final int largeStraightPoints = 40;

    private static final int smallStraightThreshold = 4;
    private static final int largeStraightThreshold = 5;

    public ScoreCard () {
        yahtzeeBonuses = 0;
        initializeComboMap();
    }

    //make protected after testing
    public String[][] getPossibleCombosChoices(int[] numbers ) {

        //it can't be known from the start of this method how many combos will be possible so its best to use a List
        Set<String[]> combos = new HashSet<>();

        //this boolean get used to check for a Full-house (comments below explain further)
        boolean fourOfAKindPresent = false;

        //total sum of number gets used by Chance, 3-of-a-Kind, and 4-of-a-Kind.
        //that's why it makes sense to declare it here and not run the same code potentially 3 times
        int totalSum = IntStream.of(numbers).sum();

        //CHECK POSSIBLE UPPER-SECTION COMBOS (and any that revolve around repeat numbers)
        for (int num = 0; num < 6; num++) {

            int lookingFor = num+1;
            //create an array of just a single int (1-6) in the given hand
            int[] foundNumbers = IntStream.of(numbers).filter(x -> x == lookingFor).toArray();

            //get the Combo key from the static array in this class
            String comboKey = upperSectionKeys[num];

            //grab the combo associated to the number
            Combo upperSectionCombo = combinations.get(comboKey);

            //if there are any matches of a number 1-6 then allow the counting of that number as a score.
            if ( foundNumbers.length > 0 && !upperSectionCombo.getHasBeenUsed()) {
                //this value can be overwritten in the next turn if not selected
                upperSectionCombo.setPointsValue(
                        //this is a simpler version of 'IntStream' line below because all the numbers in the array will be the same because of th .filter
                        foundNumbers.length * lookingFor
                        //IntStream.of(foundNumbers).sum() //adds all unique numbers together
                );
                //add the possible selection to the list of choices the player can then choose from after this method runs
                combos.add( new String[] { comboKey, upperSectionCombo.getPointsString() });
            }

            //Check 3 of a Kind
            Combo threeOfAKindCombo = combinations.get(TOAK);
            if ( foundNumbers.length >= 3 && !threeOfAKindCombo.getHasBeenUsed()) {
                threeOfAKindCombo.setPointsValue(totalSum);
                combos.add( new String[] { TOAK, threeOfAKindCombo.getPointsString() });
            }

            //Check 4 of a Kind
            Combo fourOfAKindCombo = combinations.get(FOAK);
            if ( foundNumbers.length >= 4) {
                fourOfAKindPresent = true; //set this boolean to true so the Full-House check can utilize it
                if (!fourOfAKindCombo.getHasBeenUsed()) {
                    fourOfAKindCombo.setPointsValue(totalSum);
                    combos.add( new String[] { FOAK, fourOfAKindCombo.getPointsString() });
                }
            }

            //Check YAHTZEE
            //the length can only be 5 if all the numbers are the same, hence YAHTZEE
            //no need to check if this combo has been used because Yahtzee can be used more than once
            //the logic for handling more than one Yahtzee occurrence is in the 'makeChoice' method
            if ( foundNumbers.length == 5 ) {
                Combo yahtzeeCombo = combinations.get(YATZ);
                combos.add( new String[] { YATZ, yahtzeeCombo.getPointsString() }); //add the choice to choose Yahtzee
            }

        }

        //CHECK REMAINING POSSIBLE LOWER SECTION COMBOS

        //Calculate the max amount of consecutive numbers in the hand, this will be used for the 'straights'
        int[] sortedNumbers = Arrays.stream(numbers).sorted().toArray();
        int consecutiveNumbers = 1;
        int maxInARow = 1;
        for (int i = 1; i < sortedNumbers.length; i++) {
            if (sortedNumbers[i] -1 == sortedNumbers[i-1]) {
                consecutiveNumbers++;
                if (consecutiveNumbers > maxInARow ) maxInARow = consecutiveNumbers;
            } else {
                consecutiveNumbers = 1;
            }
        }

        //Check Small Straight
        //no points need to be set since 'straights' give a static number of points
        Combo smallStraightCombo = combinations.get(SMST);
        if (
            maxInARow >= smallStraightThreshold
            && !smallStraightCombo.getHasBeenUsed()
        ) combos.add( new String[] { SMST, smallStraightCombo.getPointsString() } );

        //Check Large Straight
        Combo largeStraightCombo = combinations.get(LGST);
        if (
            maxInARow == largeStraightThreshold
            && !largeStraightCombo.getHasBeenUsed()
        ) combos.add( new String[] { LGST, largeStraightCombo.getPointsString() } );


        /* Check Full House
            this one may be possible to check Full-House in the 'num' for-loop but I thought this way was clean and pretty clever
            essentially this uses a stream to reduces the numbers array to it unique values and count how many are present
            for a full-house there should only be two unique values. there should also not be a 4 of a Kind present,
            so the program just simply checks that 4 of a kind is not present
            finally this can only be used once so that also needs to be checked
        */
        Combo fullHouseCombo = combinations.get(FLHO);
        if (
             !fourOfAKindPresent
             && Arrays.stream(numbers).distinct().count() == 2
             && !fullHouseCombo.getHasBeenUsed()
        ) combos.add( new String[] { FLHO, fullHouseCombo.getPointsString() } ); //full house has a static pointsValues so it just needs to be added to the HashSet


        //change can always be used as long as it hasn't been used already
        Combo chanceCombo = combinations.get(CHNC);
        if ( !chanceCombo.getHasBeenUsed() ) { //if the combo has NOT been used
            //calculate the sum of all numbers in roll
            //set the points value
            chanceCombo.setPointsValue(totalSum);
            //add to possible selections
            combos.add( new String[] { CHNC, chanceCombo.getPointsString() } );
        }

        return combos.toArray(String[][]::new); //convert the combos from a HashSet to an Array
    }

    //make protected after testing
    public int makeChoice (String key) {
        //first checks if the choice was a YAHTZEE,
        // if they have already gotten a YAHTZEE the hash map should not be altered,
        // the yahtzeeBonus int should be incremented instead
        if (key.equals(YATZ) && combinations.get(YATZ).getHasBeenUsed()) {
            yahtzeeBonuses++;
            return yahtzeeBonusPoints;
        }
        //by running this method the current pointsValue will be locked in for this Combo and cant be changed
        Combo comboChoice = combinations.get(key);
        comboChoice.useCombo();
        //return the number of points for this combo choice so it can be added to the players temp total
        return comboChoice.getPointsValue();
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
        //each combo has different points, some are determined by the roll, some are static
        private int pointsValue;

        protected Combo( boolean isUpper) {
            this.isUpper = isUpper;
            this.pointsValue = 0;
            hasBeenUsed = false;
        }

        //OVERLOAD - this is for the combos that will have static pointValue
        protected Combo( boolean isUpper, int pointsValue) {
            this.pointsValue = pointsValue;
            this.isUpper = isUpper;
            hasBeenUsed = false;
        }

        protected boolean getIsUpper() {
            return isUpper;
        }

        protected int getPointsValue() { return pointsValue; }

        protected void setPointsValue(int points) {
            pointsValue = points;
        }

        protected String getPointsString() { return " - (" + pointsValue + ")"; }

        protected boolean getHasBeenUsed () { return hasBeenUsed; }

        protected void useCombo () { hasBeenUsed = true; }

    }

    //these are all the 13 possible Yahtzee combos,
    // there isn't any fancy algorithmic way of creating this as far as I know. So I've hard coded them here
    private void initializeComboMap() {
        //UPPER
        combinations.put(ACES, new Combo(true));
        combinations.put(TWOS, new Combo(true));
        combinations.put(THREES, new Combo(true));
        combinations.put(FOURS, new Combo(true));
        combinations.put(FIVES, new Combo(true));
        combinations.put(SIXES, new Combo(true));
        //LOWER (some combos in the lower section have static point values to those are set by the constructor)
        combinations.put(CHNC, new Combo(false));
        combinations.put(TOAK, new Combo(false));
        combinations.put(FOAK, new Combo(false));
        combinations.put(SMST, new Combo(false, smallStraightPoints));
        combinations.put(LGST, new Combo(false, largeStraightPoints));
        combinations.put(FLHO,  new Combo(false, fullHousePoints));
        combinations.put(YATZ, new Combo(false, yahtzeeRegularPoints));
    }
}
