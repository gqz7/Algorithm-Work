  function steamrollArray(arr) {
    for (let i = 0; i < arr.length; i++) {
      if (arr[i].length > 0) {
          arr.splice(i, 1, ...arr[i])
          i--
      }   
    }
    console.log(arr);
    return arr;
  }
  
  steamrollArray([1, [2], [3, [[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[4]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]);