function sumFibs(num) {
    if (num < 0) return -1;
    if (num === 0 || num === 1) return 1;
   var fibNums = [1,1],
        finalNum = 0,
        maxReached = false,
        max = num;
  
    for (let i = 1; i < num; i++) {
       
        if (fibNums[fibNums.length - 1] < max && !maxReached) {
         fibNums.push(fibNums[i - 1] + fibNums[i]);
        } else if (fibNums[fibNums.length - 1] > max ) {
         fibNums = fibNums.slice(0,fibNums.length - 1);
          maxReached = true;
 
        }
   }
   for (let i = 0; i < fibNums.length; i++) {
     if (fibNums[i] % 2 != 0) {
        finalNum += fibNums[i];
     }
     
       
   }
   console.log(finalNum , fibNums);
   return finalNum
   
   
}
sumFibs(1000);