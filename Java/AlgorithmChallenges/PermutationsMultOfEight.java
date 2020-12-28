public List<String> multofeight () {
    List<String> results = new ArrayList<>();        
    
    for (String testInt : arr) {            
      
      boolean allNumsOdd = true;            //replace with regex
      // boolean hasEven = testInt.matches(".*[02468].*");            for (int i = 0; i < testInt.length() && allNumsOdd; i++) {
          char testChar = testInt.charAt(i);
          if (Integer.parseInt(testChar+"") % 2 == 0 ) {
              allNumsOdd = false;
          }
    }            
      
    if (allNumsOdd) {
        results.add("NO");
        System.out.println(testInt);
        continue;
    }            
    
    results.add("YES");
    // results.add("YES") || results.add("NO")  

  return results;
}