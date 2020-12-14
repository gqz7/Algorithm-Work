import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        
        for (int i = 1; i<=n; i++) {
            boolean multOf3 = i % 3 == 0;
            boolean multOf5 = i % 5 == 0;
        
            if (multOf3 && multOf5 )
                System.out.println("FizzBuzz");        
            else if (multOf3)
                System.out.println("Fizz");        
            else if (multOf5)
                System.out.println("Buzz");        
            else
                System.out.println(i);
            }
            
        
    }

}
public class Solution {