/*
function mutation(arr) {
    let lettersArray = []
    lettersArray.push(...arr[1]);
    for (var i = 0; i < lettersArray.length; i++) {


    }

    console.log(lettersArray)


}
mutation(["hello", "hey"]);
*/
function mutation(arr) {
    let myString = arr[0]
    let myLetters = [];
    myLetters.push(...arr[1]);
    for (let i = 0; i < myLetters.length; i++) {
        myRegExp = RegExp(myLetters[i], 'gi');
        let result =  myRegExp.test(myString);
    }
    
    
    
    console.log(myRegExp);
    
  }
  
  mutation(["hello", "hell"]);