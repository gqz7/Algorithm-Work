function sumPrimes(num) {
    var allNums = [], primes = [],
        finalNum;

        //all numbers that are potentially prime and less than or equal to num
        allNums = Array.from({ length: num + 1 }, (v, k) => k).slice(2);


        //checks if there are factors of each number, if it has more than 0 i will not be prime (1 & itself not included)
        for (let i = 0; i  < allNums.length; i++) {;
            var factors = 0;

           for (let j = 2; j < num; j++) {
               //check if there is a potential factor, and it cant be itself
                if (j != allNums[i] && allNums[i] % j === 0) {
                    factors++;

                }        
           }
           //if there are no factors it will go in the prime array
           if (factors == 0) {
    
               primes.push(allNums[i]);

           }
           
        }
        if (primes.length < 1) {

            console.log("No prime numbers found");
            return 0 

        } else {

            finalNum = primes.reduce((a, b) => a + b);
            console.log(finalNum);
            return finalNum
        }
    

  }
  
  sumPrimes(100);
 