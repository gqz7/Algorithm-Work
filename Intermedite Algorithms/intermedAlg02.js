function diffArray(arr1, arr2) {
    var newArr = [];

    for(var i = 0; i < arr1.length; i++){
      for (let j = 0; j < arr2.length; j++) {
          if (arr1[i] == arr2[j]){
              arr1.splice(i,1);
              arr2.splice(j,1);
              i--;
              j--
          }
          
      }
    }
    
    newArr = arr1.concat(arr2)
    console.log(newArr);
    
    return newArr;
  }
  
  diffArray([1, 2, 42, 3, 5,], [1, 2, 33, 3, 4, 5]);
  