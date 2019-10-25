//this algorithm creates a new array, taking the parameter of an array, and only pushes values that are not falsies
function falseBouncer(arr) {
  var trueArr = [];
    for (var i = 0; i < arr.length; i++) {
      
      if( typeof arr[i] === "string" && arr[i].length > 0){
       
        trueArr.push(arr[i]);
      }
      else if(arr[i] == 0 || arr[i] === null || isNaN(arr[i]) ){
        
      } else {
     
        trueArr.push(arr[i]);
      }
    }
  
    console.log(trueArr);
    return trueArr;
  
}

falseBouncer([ undefined, 7, "ate", "", "", NaN, false, 9, 0, NaN, undefined, null, 1 , 0, 2, 3]);
