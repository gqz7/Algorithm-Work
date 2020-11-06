package com.company.AlgorithmLogic;
import java.util.*;

public class NewYearChaos implements Algorithm {
    static void minimumBribes(int[] q) {
        //filter out the impossible inputs
        for (int i = 0; i < q.length; i++) {
            int personNum = q[i];
            if (i+3 < personNum) {
                System.out.println("Too chaotic");
                return;
            }
        }
        //once the 'too chaotic' ones have been filtered out the possible ones can be calculated
        System.out.println("This can be done");
        int bribes = 0;

        int[] startQ = new int[q.length];
        //build a queue of the same length with values ascending 1,2,3...
        for (int i = 0; i < startQ.length; i++) {
            startQ[i] = i+1;
        }
        //make a clone to test with
        int[] testQ = startQ.clone();
        System.out.println(Arrays.toString(testQ));
        System.out.println(Arrays.toString(q));
//        while ( !Arrays.equals(testQ, q) ) {
//
//        }
        for (int i = 0; i < testQ.length; i++) {
            int tempInt = testQ[i];
            int indexOfFinalPlace = Arrays.asList(q).indexOf(tempInt);
            System.out.println(indexOfFinalPlace);
            if (indexOfFinalPlace != i && i != 0) {
                int prevInt = testQ[i-1];
                testQ[i-1] = tempInt;
                testQ[i] = prevInt;
                bribes++;
                System.out.println(i);

            }
        }

    }
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        printWelcomeMsg();
        printRules();
        String finalLine = "1 2 5 3 7 8 6 4";//CLI.stringQuestion("Enter in a final line to calculate");

        String[] lineStrArr = finalLine.replaceAll("[^0-9 ]", "").split(" ");
        int[] lineNumArr = new int[lineStrArr.length];

        for (int i = 0; i < lineStrArr.length; i++)
            lineNumArr[i] = Integer.parseInt( lineStrArr[i] );

        minimumBribes(lineNumArr);
    }

    public void printWelcomeMsg(){
        System.out.println("\n\n-----------------------------\nLINE WAITING CHAOS\n_____________________________\n\n");
    }

    public void printRules(){
        System.out.println("The rules are that anyone can make a maximum of 2 bribes to get ahead in line.");
        System.out.println("Enter the way the line should be at the end and this program will output how many bribes their would have to be total, or if its too chaotic");
        System.out.println("An example input:\n1 2 4 5 3\nThis would take two bribes total since both 4 and 5 would have to bribe once\n");
        System.out.println("Enter spaces between numbers to allow for them to be counted as separate\n\n");
    }

}

