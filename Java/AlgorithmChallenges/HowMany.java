//counts how many valid words in a string (numbers dont count)

public static int howMany(String sentence) {
  // Write your code here
      
      String[] str = sentence.split(" ");  
      int numver = str.length;   
      for (String word : str) {
          String [] characters = word.split(""); 
          boolean foundNumber = false;
          for ( int i = 0; i < characters.length; i++) {
              // System.out.println();
          // String letter = characters;
          if (foundNumber == true) break;
          if (characters[i].matches("[0-9]") || characters[i].matches("") 
             || ( characters[i].matches("[!@#$%^&*(),.?\"\\:{}|<>\\[\\]]") && i !=characters.length-1)
              
              ) {
              System.out.println(word);
              foundNumber = true;
              numver--;
          }
          }
          
      }
      
      return numver;
  }