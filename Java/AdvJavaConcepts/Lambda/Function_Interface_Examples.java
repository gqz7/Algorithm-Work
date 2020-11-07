package com.company;

import java.util.function.Function;
import java.util.function.Supplier;

public class Function_Interface_Examples {
    public static void show () {

        System.out.println("\nFunction Interface Basics Examples Output\n".toUpperCase());

        Function<String, String> replaceColon = s -> s.replace(":", "=");
        Function<String, String> addBraces = s -> "{" + s + "}";

        String inputString = "firstname: John, lastname: Smith";

        String objectFormattedStr =
                replaceColon
                .andThen(addBraces)
                .apply(inputString );

        //another way to do this is with the 'compose' method, it would look like...
        //String objectFormattedStr = addBraces.compose(replaceColon).apply(inputString);

        System.out.println("Composing Functions, using apply/compose/andThen methods\n" + objectFormattedStr);


        System.out.println("-------------------------------------");

    }
}
