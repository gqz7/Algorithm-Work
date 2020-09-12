function translatePigLatin(str) {
    let vowels = /[a,e,i,o,u]/;
    
    if  (vowels.test(str[0])){
      str += "way";
      console.log(str);
      return str;
    } else {
        let newStr;
        for (let i = 0; i < str.length; i++) {
           if (vowels.test(str[i])) {
                newStr = str.substring(i, str.length) + str.substring(0,i) + "ay";
               console.log(newStr);
               return newStr
           } else {
               newStr = str + "ay";
           }
            
        }
        console.log(newStr);
        return newStr
    }    
  }
  
  translatePigLatin("rythm");


//   If a word begins with a vowel you just add "way" to the end.

// If a word does not contain a vowel, just add "ay" to the 