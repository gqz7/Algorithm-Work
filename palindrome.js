function palindrome(str) {
  // replaces special characters since they are not counted in palindromes and convert to lowercase(toUpperCase would also work) 
  //because this alg is not supposed to be case sensitive
  str = str.replace(/ |\_|\.|\,|\\|\/|\-|\(|\)|\:/g, '').toLowerCase();  
  let strRev = str.split('').reverse().join('');
  
  if(strRev == str){
      console.log('Your string is a palindrome');
      
    return true;
  } else {
      console.log('Your string is not a palindrome');
      
  return false;
  }
}



palindrome("0_0 (: /-\ :) 0-0");


