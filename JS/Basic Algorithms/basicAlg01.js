//REVERSING A STRING
///

var strArr,
 str = "hello",
 revStr = "";
function reverseString(str) {
 strArr = str;
 strArr = strArr.split("");
for(i= strArr.length - 1; i >= 0; i--){
   revStr += strArr[i];
}
  
};
reverseString("gabriel sherman");
console.log(revStr);

//others code, does the exact same thing

function reverseString(str) {
  return str.split('').reverse().join('');
}