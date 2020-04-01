//1. reverse a string


function reverseString(str) {
  str = str.split("");
  str = str.reverse();
  var newStr = '';
  for (let i = 0; i < str.length; i++){
    newStr += str[i];
  }
    return newStr;
  }
  
  //reverseString("hello");
  
  //2. Factorialize a Number

  function factorialize(num) {
    var sum = 1;
    if (num <= 0) {
      for (let i = -num; i > 0; i--) {
        sum *= -i;
        console.log(sum);
      }} else {
        for (let i = 1; i < num+1; i++) {
          sum *= i;
          console.log(sum);
        }
     
    }
    
   
  }
  factorialize(7);