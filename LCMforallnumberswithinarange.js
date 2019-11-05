function smallestCommons(arr) {
  let primeArr = [], smallestCommonMultiple;

  //sets up the arrgument in order so that declaring a min and max number is not neccesarry
  arr.sort((a, b) => {return a-b}); 

   // creates an array of all number in between our range (that can be prime, so 0,1 and negitive integers are not included)
    for (let i = arr[0]; i <= arr[1]; i++) {
      if (i < 2) {
        i = 2;
      }
        primeArr.push(i);
    }
   
  
    //checks for every number to see if its prime, otherwise it is broken down into its prime multiples 
    for (let i = 0; i < primeArr.length; i++) {
          for (let j = 2; j < primeArr[i]; j++) {
            //check if there is a potential factor, and it cant be itself
            if (j != primeArr[i] && primeArr[i] % j === 0) {
                primeArr.splice(i, 1, j, primeArr[i]/j)

            }        
           }     
    }
   

    smallestCommonMultiple = primeArr.reduce((a, b) => a * b);
    console.log(primeArr, smallestCommonMultiple);
    
  }
  
  
  smallestCommons([23, 18]);
















  // multipleNum, lesserNum, greaterNum,
//     multipleNumFound = false;
//     if (num1 > num2) {
//         lesserNum = num2;
//         greaterNum = num1
//     } else {
//         lesserNum = num1;
//         greaterNum = num2
//     }
    


//     for (let testNum = (num2 * num1) + 1; !multipleNumFound; testNum++) {
//         for (let multiNum = lesserNum; multiNum <= greaterNum; multiNum++) {
//             if (testNum % multiNum === 0) {
//                 console.log(testNum, multiNum);
//                 multipleNumFound = true;
//                 multipleNum = testNum;
//             }
            
//         }
        // if (testNum % num1 === 0 && testNum % num2 === 0) {
        //     multipleNumFound = true;
        //     multipleNum = testNum;
        // } else {
        //     console.log(testNum);
            
        // }
    // }
