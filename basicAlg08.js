//my
function findElement(arr, func) {
    for(var i = 0; i < arr.length; i++){
      let num = arr[i];
       if( num % 2 === 0){
       return num;
       }else{
    }
 }}
  
findElement([1, 2, 3, 4], num => num % 2 === 0);
//other
function findElement(arr, func) {
    let num = 0;
    
    for(var i = 0; i < arr.length; i++) {
      num = arr[i];
      if (func(num)) {
        return num;
      }
    }
    
    return undefined;
  }

