
//returns longest word in given string

function findLongestWordLength(str) {
    var strWords = str.split(" ");
    var longWord = 0;
    var longestWord = "";
    for(i = 0; i < strWords.length; i++){
        
        if(strWords[i].length > longWord){
            longestWord = strWords[i];
            longWord = strWords[i].length;
            console.log(longestWord);
        }else if(longestWord.length == longWord){
            longestWord += longWord;
            console.log(longestWord);
        }else{
            return "err";
        }
  }
  return longestWord;
    
}
  
  findLongestWordLength("The asodfhaisdfh brown fox jumped over zzodfhaisdfh the lazy dog");

  //returns length of longest word
  function findLongestWordLength(str) {
    var words = str.split(' ');
    var maxLength = 0;
  
    for (var i = 0; i < words.length; i++) {
      if (words[i].length > maxLength) {
        maxLength = words[i].length;
      }
    }
  
    return maxLength;
  }