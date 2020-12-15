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
    //second attempt: solves 3/10
        // Map<Integer, Integer> groupMap = new HashMap<>();
        // int groupNum = 0;
        // groupMap.put( 0, 0);
        // for (int i = 0; i < related.size()-1; i++) {
        //     String curRel = related.get(i);
        //     boolean foundRel = false;
        //     for (int j = i+1; j < related.size()-1; j++) {
        //         String checkRel = related.get(j);
        //         if (isRelated(curRel, checkRel)) {
        //             foundRel = true;
        //             System.out.println("1: " +curRel);
        //             System.out.println("2: " +checkRel);
        //             if (groupMap.get(i) != null) {
        //                 groupMap.put(j, groupMap.get(i));
        //             } else {
        //                 groupNum++;
        //                 groupMap.put(i, groupNum);
        //                 groupMap.put(j, groupNum);
        //             }
        //         }
        //     }
        //     if (!foundRel) groupMap.put(i, groupNum++);
            
            
        // }
        // return groupNum+1;

        //third attemps solves ALL 10 test cases!!!
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        Map<Integer, Integer> personsGroup = new HashMap<>();
        int groupNum = 0;
        groupMap.put(groupNum, new ArrayList<>());
        groupMap.get(groupNum).add(0);
        
        // for (int i = 0; i < related.size(); i++) {
        //     System.out.println(i + ": " + related.get(i));
        // }
        
        for (int i = 0; i < related.size(); i++) {
            String curRel = related.get(i);
            boolean foundRel = false;
            for (int j = i+1; j < related.size(); j++) {
                String checkRel = related.get(j);
                if (isRelated(curRel, checkRel)) {
                    foundRel = true;
                    // System.out.println("1: " +curRel);
                    // System.out.println("2: " +checkRel);
                    
                    Integer curPersonGroup = personsGroup.get(i);
                    Integer foundPersonGroup = personsGroup.get(j);
                    
                    //check if both persons dont have relations (creates a new group)
                    if (curPersonGroup == null && foundPersonGroup == null) { 
                        
                        //add personGroup relations
                        personsGroup.put(j, groupNum);
                        personsGroup.put(i, groupNum);
                        //add groupMap relations
                        List<Integer> newGroup = new ArrayList<>();
                        newGroup.add(i);
                        newGroup.add(j);
                        groupMap.put(groupNum, newGroup);
                        
                        //itterate groupNum
                        groupNum++;
                    } else if (curPersonGroup == null && foundPersonGroup != null ) {//check if 'check' has no relation (but other does)
                        
                        //add personGroup relations
                        personsGroup.put(i, foundPersonGroup);
                        //add groupMap relations
                        List<Integer> newGroup = groupMap.get(foundPersonGroup);
                        newGroup.add(i);
                        groupMap.put(foundPersonGroup, newGroup);
                        
                    } else if (curPersonGroup != null && foundPersonGroup == null ) { //check if 'cur' has no relation (but other does)
                    
                        //add personGroup relations
                        personsGroup.put(j, curPersonGroup);
                        //add groupMap relations
                        List<Integer> newGroup = groupMap.get(curPersonGroup);
                        newGroup.add(j);
                        groupMap.put(curPersonGroup, newGroup);
                         
                    } else if (foundPersonGroup != curPersonGroup) { //they must both have relations but only run if they are not the same group
                        
                        int newGroupNum = foundPersonGroup;
                        int transGroupNum = curPersonGroup;
                        List<Integer> transferingList = groupMap.get(transGroupNum);
                        
                        for (int personIdx : transferingList) {
                            personsGroup.put(personIdx, newGroupNum);
                        }
                        
                        List<Integer> newGroup = groupMap.get(newGroupNum);
                        newGroup.addAll(transferingList);
                        groupMap.put(newGroupNum, newGroup);
                        
                        groupMap.remove(transGroupNum);
                    }
                }
            }
            
            // System.out.println(i + ": " +groupMap);
            
            //the person has no relations, create their own group
            if (!foundRel && personsGroup.get(i) == null) {
                List<Integer> newGroup = new ArrayList<>();
                newGroup.add(i);
                personsGroup.put(i, groupNum);
                groupMap.put(groupNum, newGroup);
                groupNum++;
            } 
            
        }
        // System.out.println(groupMap);
        
        return groupMap.size();
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
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int relatedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> related = IntStream.range(0, relatedCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result.countGroups(related);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
