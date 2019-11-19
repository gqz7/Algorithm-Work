function palindrome(str) {
  // Good luck!
  str = str.replace(/ |\_|\.|\,/g, '').toLowerCase();
  let strRev = str.split('').reverse().join('');
  console.log(strRev, str);
  
  if(strRev == str){
    return true;
  } else {
  return false;
  }
}



palindrome("0_0 (: /-\ :) 0-0");


