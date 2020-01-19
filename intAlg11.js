//fibonacci numbers 113581321

//GLOBAL VARS
const readline  = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      }),

      lb = '_____________________________';

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
    

    rl.question('\n1. Filter out even\n2. Filter out odd\n3. Filter out primes\n4. Filter out non-primes\n5. No filter\nNumber Selection: ',
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
                    case 5:
                        break;
                
                }

                // console.log(fibArr);
                select_operation()
                
            } else {

                console.log('This is not a vaild number selection, try again...\n\n');
                select_filter()

            }

           

        })
}

function select_operation() {

    console.log(`Your fibonacci sequence:\n\n${fibArr}\n${lb.repeat(4)}`);

    console.log('What operation would you like to preform on the remaining numbers in your fibonacci sequence?');
    
    rl.question('\n1. Sum of all numbers\n2. Diffrence\n3. Product\n4. Quotent (starting from largest)\nNumber Selection: ',

    (num) => {

        num = parseInt(num);

        if (!isNaN(num)) {

            let finalAnswer, operationString = '', operation;

            switch (num) {
                case 1: //SUM
    
                    finalAnswer = fibArr.reduce((a,b) => {return a+b})

                    operation = '+'

                    break;
            
                case 2: //Diffrence 
    
                    finalAnswer = fibArr.reduce((a,b) => {return a-b})

                    operation = '-'
                                    
                    break;
    
                case 3: //Product

                    finalAnswer = fibArr.reduce((a,b) => {return a*b})

                    operation = 'x'
                                
                    break;
               
                case 4: //Quotent
                    let tmpfibArr = fibArr.reverse();

                    finalAnswer = tmpfibArr.reduce((a,b) => {return a/b})

                    operation = '/'
    
                    break;
            }

            for (let i = 0; i < fibArr.length; i++) {
                if (i < fibArr.length - 1) {

                    operationString += `${fibArr[i]} ${operation} `;
                } else {
                    operationString += `${fibArr[i]} = `;
                }
                
            }

            console.log(`\n\n${lb.repeat(4)}\nResult\n${operationString}${finalAnswer}`);
            

            console.log('\nYour final answer is', finalAnswer);

            nav()
            
            
        } else {

            console.log('That was not a vaild number entry, try again');
            
        }

    })
    
}

function nav() {

    rl.close()
    
}
