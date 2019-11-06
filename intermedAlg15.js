function dropElements(arr, func) {
    // Drop them elements. Simple solutions are often the best :)
    while(arr.length > 0 && func(arr[0])){
      arr.shift();
      
    }
    console.log(func(arr[0]), arr); 
    return arr;
  }
  
  dropElements([1, 2, 3, 4, 5, 6], function(n) {return n < 2; });
  