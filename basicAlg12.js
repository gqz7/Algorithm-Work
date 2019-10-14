/*
function falsebouncer(arr) {
    // Don't show a false ID to this falsebouncer.
   
   var arr1 = 0;
   arr1 = arr.filter(arr => false || NaN || 0 || "" || null);
    console.log(arr1);
    return arr1;
  }
  
  falsebouncer([7, "ate", "", false, 9, null, undefined, NaN, 0]);
*/

/*

var arr = [1, null, NaN, 2, undefined, "", NaN];

function falseComparison(arr) {
  var arr1 = [];
  for (var i = 0; i < arr.length; i++ ) {

      switch (arr[i]){
        case false:
          arr1.push(arr[i]);
        break;
        
        case null:
            arr1.push(arr[i]);
        break;

        case 0:
            arr1.push(arr[i]);
        break;

        case "":
            arr1.push(arr[i]);
        break;

        case isNaN(arr[i]):
            arr1.push(arr[i]);
        break;

        case undefined:
            arr1.push(arr[i]);
        break;

        default:
          console.log("there were no falslys detected in " + arr[i]);
          
      }

  }
  console.log(arr1);
}
falseComparison(arr);
*/

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