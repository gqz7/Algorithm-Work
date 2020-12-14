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
     * Complete the 'closedPaths' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER number as parameter.
     */

    public static int closedPaths(int number) {
    
        int totalPaths = 0;
        
        char[] digits = Integer.toString(number).toCharArray();
        
        for (char numChar : digits) {
            
            // switch(numChar) {
            //     case '0':
            //     case '4':
            //     case '6':
            //     case '9':
            //         totalPaths += 1;
            //     break;
            //     case '8':
            //         totalPaths += 2;
            //     break;
            //     default:
            //     break;
            // }
            if (   
                numChar == '9' 
                || numChar == '6' 
                || numChar == '4' 
                || numChar == '0'
               )
                totalPaths += 1;
            else if (numChar == '8') 
                totalPaths += 2;
                
        }
        
    
        
        return totalPaths;

    }

}
