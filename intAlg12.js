//sum of all primes

//GLOBAL VARS
const readline  = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let primes = [];

//Intro

prime_range()

//Functions

//get user input and create primes upto and including the number provided by the user
function prime_range() {

    rl.question('Enter a number\ninput: ', (num) => {
        num = parseInt(num);
    
        if (!isNaN(num)) {

            for (let i = 2; i <= num; i++) {

                let isPrime = true;
               
                for (let j = 2; j <= Math.ceil(Math.sqrt(i)); j++) {
                    
                    if (i % j == 0 && i != j) {
                        isPrime = false
                        j = i;
                    }
                    
                }

                if (isPrime) {
                    primes.push(i);
                }
                
            }

            console.log(primes);
            
            
        } else {
            console.log('That is not a vaild input, try again...');
            prime_sum()
        }
        
    })
    
}
