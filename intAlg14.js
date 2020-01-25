function dropElements(arr, func) {

   for (let i = 0; i < arr.length; i++) {
       
        if (func(arr[i])) {
            
            arr.splice(arr.indexOf(arr[i]), 1);
            i--
        }
       
   }

    console.log(arr);

    return arr;
}
  
  dropElements([1, 2, 3], function(n) {return n < 3; });
  