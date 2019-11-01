function chunkArrayInGroups(arr, size) {
    let newArr = []
    for(let i=0; i< (arr.length/size); i++){
      newArr.push([])
    }
    
    for(let i=0; i<newArr.length; i++) {
      for(let j=0; j<arr.length; j++){
        if(newArr[i].length < size){
          newArr[i].push(arr[j]);
          arr.splice(j,1);
          j--
          }
      }
    }
    console.log(newArr);
    return newArr;
  }
  chunkArrayInGroups([0, 1, 2, 3, 4, 5, 6, 7, 8], 2)