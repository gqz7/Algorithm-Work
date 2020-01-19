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

                console.log(fib2);
                
            }

            console.log(fibArr);
            
                
        
            
        } else {
            console.log('That was not a vaild number, try again');
            select_range()
            
        }
    })
    
}

function select_operation() {
    
}

function nav() {
    
}
