function sumAll(arr) {
    let sum = 0;
    if (arr[0]-arr[1] < 0 ) {
        var range = arr[1] - arr[0],
            min = arr[0];

    } else {
        var range = arr[0] - arr[1],
            min = arr[1];

    }
    for (let i = 0; i <= range; i++) {
       sum += min + i;
    }
    
    console.log("Sum", sum, "Range", range, "Min", min);
    return sum
    
  }
  
  sumAll([42, 9]);
  