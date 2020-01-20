//sum of all primes

//GLOBAL VARS
const readline  = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      }),

      lb = '_____________________________';

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

            //go to next function
            select_operation()
            
        } else {
            console.log('That is not a vaild input, try again...');
            prime_sum()
        }
        
    })
    
}

function select_operation() {

    console.log(`\nYour current list of primes...\n${lb.repeat(3)}\n${primes}\n${lb.repeat(3)}\n\n Select an operation to preform on the list of primes`);
    
    
    rl.question('1. Addition\n2. Subtraction(smallest 1st)\n3. Subtraction(largest 1st)\n4. Multiplication\n5. Division(smallest 1st)\n6. Division(largest 1st)\n\nNumber Selection: ', 
    (num) => {

        let finalAnswer, operation;

        switch (num) {
            case '1':

                operation = '+';

                finalAnswer = primes.reduce((a,b) => {return a+b})

                
                break;
            case '2':

                operation = '-';

                finalAnswer = primes.reduce((a,b) => {return a-b})
            
                break;
            case '3':

                operation = '-';

                finalAnswer = primes.reverse().reduce((a,b) => {return a-b})
        
                break;
            case '4':

                operation = 'x';

                finalAnswer = primes.reduce((a,b) => {return a*b})
    
                break;
            case '5':

                operation = '/';

                finalAnswer = primes.reduce((a,b) => {return a/b})
            
                break;
            case '6':

                operation = '/';

                finalAnswer = primes.reverse().reduce((a,b) => {return a/b})
        
                break;
                                           
            default:
                break;
        }

        let operationString = '';

        for (let i = 0; i < primes.length; i++) {
            if (i < primes.length - 1) {

                operationString += `${primes[i]} ${operation} `;

            } else {
                operationString += `${primes[i]} = `;
            }
            
        }

        console.log(`\n\n${lb.repeat(4)}\nResult\n${operationString}${finalAnswer}`);

        console.log('\nYour final answer is', finalAnswer);

        console.log('Thank you for using this program, it will now close...');
        
        rl.close()

    })
}
