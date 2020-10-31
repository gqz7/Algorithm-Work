package com.company;

public class StringCaseConverter implements Algorithm  {
    @Override
    public void run () {
        printWelcomeMsg();
    }

    public static String titleCaseString (String inStr ) {
        StringBuilder titleCased = new StringBuilder();
        String[] originalStr= inStr.split(" ");

        for ( int i = 0; i < originalStr.length; i++) {
            String word = originalStr[i];
            String titleCasedWord = Character.toUpperCase( word.charAt(0) ) + word.substring(1).toLowerCase();
            // System.out.println(titleCasedWord);
            if (i != 0) {
                titleCased.append(" ");
            }
            titleCased.append(titleCasedWord);
        }
        return titleCased.toString();
    }

    @Override
    public void printWelcomeMsg() {
        System.out.println("\n\n-----------------------------\nSTRING CASING\n_____________________________\n\n");
    }
}
