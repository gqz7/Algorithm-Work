function fearNotLetter(str) {
    str = str.split("");
    var alpha = ("abcdefghijklmnopqrstuvwxyz").split(""),
        start,end,
        bool = true;
   
    //finding start and end values
    for (let j = 0; j < str.length; j++) {
        for (let i = 0; i < alpha.length; i++) {
            //once the start is found. it no longer makes changes to the start variable
            if (bool) {
                if (alpha[i] === str[j]) {
                    start = i;
                    bool = false;
                }
            }
            //finds the end
            if (alpha[i] === str[str.length -1]) {
                end = i;
            }
        }  
        
    }
    //changes alpha to only be an array of only the range of letters
    alpha = alpha.join("").substring(start,end+1).split("");

    //finds the similar values in alpha(which only contains the range of str)
   //so the remaining values are the ones missing from str
   for (let i = 0; i < alpha.length; i++) {
       for (let j = 0; j < str.length; j++) {
           if (str[j] === alpha[i]) {
            alpha.splice(i,1);
            str.splice(j,1);
            i--;
            j--
           }
           
       }
       
   }
   if (alpha.length < 1) {
       alpha = undefined;
   } else {
    alpha = alpha.join("");
    }

    
   console.log(alpha);
   return alpha;
  }
  
  fearNotLetter("abcdefghijklmno");
  