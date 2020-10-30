package com.company;

import java.text.MessageFormat;
import java.util.*;

public class ApplesOranges implements Algorithm {

    static void countApplesAndOranges(int houseStart, int houseEnd, int appleTreePos, int orangeTreePos, int[] apples, int[] oranges) {

        String allVars = MessageFormat.format(
                "StartHouse: {0}\nEndHouse: {1}\nAT: {2}\nOT: {3}\nApples: {4}\nOranges: {5}",
                houseStart, houseEnd, appleTreePos, orangeTreePos, Arrays.toString(apples), Arrays.toString(oranges) );
//        System.out.println( allVars );

        int appleTotal = 0;
        int orangeTotal = 0;

        for (int i = 0; i < apples.length; i++) {
            int distanceFromTree = apples[i];
            int appleAbsPos = appleTreePos + distanceFromTree;

            if ( appleAbsPos >= houseStart && appleAbsPos <= houseEnd) {
                appleTotal++;
            }
        }

        for (int distanceFromTree : oranges) {
            int orangeAbsPos = orangeTreePos + distanceFromTree;

            if ( orangeAbsPos >= houseStart && orangeAbsPos <= houseEnd ) {
                orangeTotal++;
            }

        }

        System.out.println("Number of apples that fell on the house: " + appleTotal + "\nNumber of oranges that fell on the house: " + orangeTotal);

    }

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {

        System.out.println("Paste data below:");

        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }

}