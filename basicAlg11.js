//my original
function frankenSplice(arr2, arr1, n) {
    // It's alive. It's alive!
    let arr3 = arr1.slice(0, arr1.length);
    
    arr3.splice(n, 0, ...arr2);
    console.log(arr3);
    return(arr3);
  
    
  }
  
  frankenSplice([1, 2], ["a", "b"], 1);

function franken00(arr2, arr1, n) {
    // It's alive. It's alive!
    let arr3 = arr1.slice(0, arr1.length).splice(n, 0, ...arr2);
    console.log(arr3);
    return;
  }
  franken00([3, 1], ["1", "4"], 1);
