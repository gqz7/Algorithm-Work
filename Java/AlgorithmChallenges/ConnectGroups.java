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
    
    public static int countGroups(List<String> related) {
    
    //first attempt: solves 5/10
    // // Write your code here
        int groups = 1;
        for (int i = 0; i < related.size()-1; i++) {
            String curRel = related.get(i);
            String nxtRel = related.get(i+1);
            boolean isRelated = false;
            System.out.println(curRel);
            for (int j = 0; j < curRel.length(); j++) {
                
                char c1 = curRel.charAt(j);
                char c2 = nxtRel.charAt(j);
                if (c1 != '0' && c1 == c2) isRelated = true;
            }
            if (!isRelated) groups++;
        }
        return groups;

    }

}
