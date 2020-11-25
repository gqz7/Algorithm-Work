package com.yahtzee.game_src.scorelogic.player;

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
    private final Map<String, Combo> combinations;

    //this set is used to temporarily store the possible score combinations during a turn, after every turn
    private final Set<String[]> possibleScoreCombos;

    //currentRoll holds the players current roll to pass around to the different 'check' methods
    private int[] currentRoll;

    //the combinations can keep track of how many times the Yahtzee has gotten selected so after the first one this int will increment
    //this is also helpful because the bonuses are worth more than the first one
    private int yahtzeeBonuses;

    //this will keep track of the total sum of all dice on a give turn,
    // this value gets used in three of the combos, (3/4oaK & Chance) so it makes sense to only evaluate it once per turn
    private int totalSumOfTurn;

    //this will keep track of if there are 4 of a kind in a given turn, this then gets used in the Full-House check logic
    private boolean fourOfAKindPresentInHand;

    //static point values for the combinations whose point values don't change
    private static final int yahtzeeBonusPoints = 100;
    private static final int YAHTZEE_REGULAR_POINTS = 50;
    private static final int FULL_HOUSE_POINTS = 25;
    private static final int SMALL_STRAIGHT_POINTS = 30;
    private static final int LARGE_STRAIGHT_POINTS = 40;

    private static final int smallStraightThreshold = 4;
    private static final int largeStraightThreshold = 5;


    public ScoreCard () {
        yahtzeeBonuses = 0;
        combinations = new HashMap<>();
        possibleScoreCombos = new HashSet<>();
        fourOfAKindPresentInHand = false;

        initializeComboMap();
    }

    //make protected after testing
    public String[][] getPossibleCombosChoices(int[] rollNumbers ) {

        currentRoll = rollNumbers;

        //it can't be known from the start of this method how many combos will be possible so its best to use a List
        //reset this set before the combos are calculated since this field is stored by the ScoreCard instead of locally
        possibleScoreCombos.clear();

        calculatePossibleCombos();

        return possibleScoreCombos.toArray(String[][]::new); //convert the combos from a HashSet to an Array
    }

    private void calculatePossibleCombos () {

        totalSumOfTurn = Arrays.stream(currentRoll).sum();

        //CHECKS UPPER-SECTION COMBOS AND COMBOS THAT INVOLVE REPEATS (YAHTZEE, four/three-of-a-kind)
        checkRepeatCombos();

        //CHECK REMAINING POSSIBLE LOWER SECTION COMBOS
        checkFullHouseCombo();

        checkConsecutiveCombos();

        checkChanceCombo();

        //reset this value for the next turn
        fourOfAKindPresentInHand = false;
    }

    private void checkChanceCombo() {

        //change can always be used as long as it hasn't been used already
        Combo chanceCombo = combinations.get(CHNC);
        if ( !chanceCombo.getHasBeenUsed() ) { //if the combo has NOT been used
            //calculate the sum of all numbers in roll
            //set the points value
            chanceCombo.setPointsValue(totalSumOfTurn);
            //add to possible selections
            possibleScoreCombos.add( new String[] { CHNC, chanceCombo.getPointsString() } );
        }

    }

    private void checkFullHouseCombo() {
            /* Check Full House
            this one may be possible to check Full-House in the 'num' for-loop but I thought this way was clean and pretty clever
            essentially this uses a stream to reduces the numbers array to it unique values and count how many are present
            for a full-house there should only be two unique values. there should also not be a 4 of a Kind present,
            so the program just simply checks that 4 of a kind is not present
            finally this can only be used once so that also needs to be checked
        */
        Combo fullHouseCombo = combinations.get(FLHO);
        if (
                !fourOfAKindPresentInHand
                        && Arrays.stream(currentRoll).distinct().count() == 2
                        && !fullHouseCombo.getHasBeenUsed()
        ) possibleScoreCombos.add( new String[] { FLHO, fullHouseCombo.getPointsString() } );
        //full house has a static pointsValues so it just needs to be added to the HashSet


    }

    private void checkConsecutiveCombos() {

        //Calculate the max amount of consecutive numbers in the hand, this will be used for the 'straights'
        int[] sortedNumbers = Arrays.stream(currentRoll).sorted().distinct().toArray();
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
        ) possibleScoreCombos.add( new String[] { SMST, smallStraightCombo.getPointsString() } );

        //Check Large Straight
        Combo largeStraightCombo = combinations.get(LGST);
        if (
                maxInARow == largeStraightThreshold
                        && !largeStraightCombo.getHasBeenUsed()
        ) possibleScoreCombos.add( new String[] { LGST, largeStraightCombo.getPointsString() } );

    }

    private void checkRepeatCombos () {

        int maxRepeats = 1; //this keeps track of the maximum number of a repeated number in the roll

        //CHECK POSSIBLE UPPER-SECTION COMBOS (and any that revolve around repeat numbers)
        for (int num = 0; num < 6; num++) {

            int lookingFor = num+1;
            //create an array of just a single int (1-6) in the given hand
            int[] foundNumbers = IntStream.of(currentRoll).filter(x -> x == lookingFor).toArray();

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
                possibleScoreCombos.add( new String[] { comboKey, upperSectionCombo.getPointsString() });
            }

            if (foundNumbers.length > maxRepeats) maxRepeats = foundNumbers.length;

        }

        //Check 3 of a Kind
        if ( maxRepeats >= 3 ) {
            checkThreeOfAKindCombo();
        }

        //Check 4 of a Kind
        if ( maxRepeats >= 4) {
            checkFourOfAKindCombo();
        }

        //Check YAHTZEE
        //the length can only be 5 if all the numbers are the same, hence YAHTZEE
        //no need to check if this combo has been used because Yahtzee can be used more than once
        //the logic for handling more than one Yahtzee occurrence is in the 'makeChoice' method
        if ( maxRepeats == 5 ) {
            addYahtzeeCombo();
        }

    }

    private void checkThreeOfAKindCombo() {

        Combo threeOfAKindCombo = combinations.get(TOAK);
        if (!threeOfAKindCombo.getHasBeenUsed()) {
            threeOfAKindCombo.setPointsValue(totalSumOfTurn);
            possibleScoreCombos.add( new String[] { TOAK, threeOfAKindCombo.getPointsString() });
        }
    }

    private void checkFourOfAKindCombo() {
        Combo fourOfAKindCombo = combinations.get(FOAK);
        fourOfAKindPresentInHand = true; //set this boolean to true so the Full-House check can utilize it
        if (!fourOfAKindCombo.getHasBeenUsed()) {
            fourOfAKindCombo.setPointsValue(totalSumOfTurn);
            possibleScoreCombos.add( new String[] { FOAK, fourOfAKindCombo.getPointsString() });
        }
    }

    private void addYahtzeeCombo() {
        Combo yahtzeeCombo = combinations.get(YATZ);
        boolean hasBeenUsed = yahtzeeCombo.getHasBeenUsed();
        possibleScoreCombos.add( new String[] {
                YATZ,
                hasBeenUsed //if yahtzee has already been used then the bonus points will be greater
                        ? Combo.createPointsString(yahtzeeBonusPoints)
                        : Combo.createPointsString(YAHTZEE_REGULAR_POINTS)
        }); //add the choice to choose Yahtzee
    }

    protected int makeChoice (String key) {
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

    protected static class Combo {

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

        protected String getPointsString() { return createPointsString(pointsValue); }

        protected boolean getHasBeenUsed () { return hasBeenUsed; }

        protected void useCombo () { hasBeenUsed = true; }

        protected static String createPointsString ( int points ) { return " - (" + points + ")"; }

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
        combinations.put(SMST, new Combo(false, SMALL_STRAIGHT_POINTS));
        combinations.put(LGST, new Combo(false, LARGE_STRAIGHT_POINTS));
        combinations.put(FLHO,  new Combo(false, FULL_HOUSE_POINTS));
        combinations.put(YATZ, new Combo(false, YAHTZEE_REGULAR_POINTS));
    }

    public int tallyScore() {

        int upScore = 0;
        int lwScore = 0;

        //convert the Combo HashMap into something iterable
        for ( Map.Entry comboEntry : getCombinations().entrySet() ) {

            //get the value of the HM, the Combo object
            ScoreCard.Combo combo = (ScoreCard.Combo) comboEntry.getValue();

            //if the combo has been used it was at once point a selection by that player in the game
            if (combo.getHasBeenUsed()) {
                //get the points and add to the right section
                int comboScore = combo.getPointsValue();
                if (combo.getIsUpper())
                    upScore += comboScore;
                else
                    lwScore += comboScore;

            }

        }
        //add up the Yahtzee bonuses
        lwScore += getYahtzeeBonuses() * 100;
        //add the upper section bonus if they got it
        if ( upScore >= 63 ) upScore += 35;

        return lwScore + upScore;
    }
}
