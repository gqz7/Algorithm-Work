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
     * Complete the 'countGroups' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY related as parameter.
     */
    
    public static int countGroups(List<String> related) {
    
    //first attempt: solves 5/10
    // // Write your code here
    //     int groups = 1;
    //     for (int i = 0; i < related.size()-1; i++) {
    //         String curRel = related.get(i);
    //         String nxtRel = related.get(i+1);
    //         boolean isRelated = false;
    //         System.out.println(curRel);
    //         for (int j = 0; j < curRel.length(); j++) {
                
    //             char c1 = curRel.charAt(j);
    //             char c2 = nxtRel.charAt(j);
    //             if (c1 != '0' && c1 == c2) isRelated = true;
    //         }
    //         if (!isRelated) groups++;
    //     }
    //     return groups;
    // }
        Map<Integer, Integer> groupMap = new HashMap<>();
        int groupNum = 0;
        groupMap.put( 0, 0);
        for (int i = 0; i < related.size()-1; i++) {
            String curRel = related.get(i);
            boolean foundRel = false;
            for (int j = i+1; j < related.size()-1; j++) {
                String checkRel = related.get(j);
                if (isRelated(curRel, checkRel)) {
                    foundRel = true;
                    System.out.println("1: " +curRel);
                    System.out.println("2: " +checkRel);
                    if (groupMap.get(i) != null) {
                        groupMap.put(j, groupMap.get(i));
                    } else {
                        groupNum++;
                        groupMap.put(i, groupNum);
                        groupMap.put(j, groupNum);
                    }
                }
            }
            if (!foundRel) groupMap.put(i, groupNum++);
            
            
        }
        return groupNum+1;
    }
    
    private static boolean isRelated(String sq1, String sq2) {
        boolean isRelated = false;
        if (sq1.length() != sq2.length()) return false;
            for (int j = 0; j < sq1.length(); j++) {
                
                char c1 = sq1.charAt(j);
                char c2 = sq2.charAt(j);
                if (c1 == '1' && c1 == c2) isRelated = true;
            }
        return isRelated;
    }

}
