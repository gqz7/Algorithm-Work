//fibonacci numbers 113581321

//GLOBAL VARS
const readline  = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let fibArr = [];

select_range()

function select_range() {

    rl.question('\nEnter an endpoint for your fibonacci sequence.\nNumber: ', (num) => {

        num = parseInt(num.trim())

        if (!isNaN(num) && num < 1000000000000 && num > 1) {

            let fib0 = 0, fib1 = 1, fib2 = 1;

            while (fib2 <= num) {
                fibArr.push(fib2);

                fib2 = fib1 + fib0;

                fib0 = fib1;
                
                fib1 = fib2

                // console.log(fib2);
                
            }

            // console.log(fibArr);

            select_filter()
            
        } else {
            console.log('That was not a vaild number, try again');
            select_range()
            
        }
    })
    
}

function select_filter() {

    console.log('Would you like to filter out some of the fibonacci numbers?\nYour choices:');
    

    rl.question('\n1. Filter out even\n2. Filter out odd\n3. Filter out primes\n4. Filter out non-primes\nNumber Selection: ',
        (num) => {

            num = parseInt(num);

            if (!isNaN(num)) {

                switch (num) {
                    case 1:

                        fibArr = fibArr.filter(num => {return num % 2 != 0})
                        
                        break;
                    case 2:

                        fibArr = fibArr.filter(num => {return num % 2 == 0})
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                
                }

                console.log(fibArr);
                
                
            } else {

                console.log('This is not a vaild number selection, try again...\n\n');
                select_filter()

            }

            select_operation()

        })
}

function select_operation() {
    
}

function nav() {
    
}
