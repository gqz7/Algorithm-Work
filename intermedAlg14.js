function LCM(arr) {
  arr.sort((a, b) => {return a-b}); 
  for (let i = arr[0] + 1; i < arr[1]; i++) {
      arr.push(i)
      
  }
  arr.sort((a,b) => {return b-a})

  var lcmFound = false;

  for (var l = arr[0]; !lcmFound; l++) {
      var factors = 0;
     for (let i = 0; i < arr.length; i++) {
         if (l != arr[i] && l % arr[i] == 0) {
             factors++
         }   
      }
     if (factors == arr.length) {
        // console.log(arr);
         lcmFound = true;

     }
  }
  console.log(l);
  return l
}
LCM([1000, 18])