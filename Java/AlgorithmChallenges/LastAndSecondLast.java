//CHALLENGE: complete the algorithm method

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
     * Complete the 'lastLetters' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING word as parameter.
     */

    public static String lastLetters(String word) {
    // Write your code here
        int numberOfChars = 2;
        
        // truncate
        String endOfString = word.substring(word.length()-numberOfChars);
        
        //add spaces
        String spacedString = String.join(" ", endOfString.split(""));
        
        //reverse
        String finalResult = 
            new StringBuilder()
                .append(spacedString)
                .reverse()
                .toString();
        
        // String finalResult = String.join(" ", Arrays.asList(allChars));
        
        return finalResult;
        
        //easy soultion (not scalable)
        // return word.charAt(word.length()-1) + " " + word.charAt(word.length()-2); 

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String word = bufferedReader.readLine();

        String result = Result.lastLetters(word);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
