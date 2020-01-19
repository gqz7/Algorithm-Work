//fibonacci numbers 113581321

//GLOBAL VARS
const readline  = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      }),

      lb = '_____________________________';

let fibArr = [], filteredArray = [];

//first function call to start the program
select_range()

// this will set the max value that can be in our fibonacci sequence

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

//select a filter to apply to the original fibonacci sequence, called after a max number in the fib sequence is selected

function select_filter() {

    console.log('Would you like to filter out some of the fibonacci numbers?\nYour choices:');
    

    rl.question('\n1. Filter out even\n2. Filter out odd\n3. Filter out primes\n4. Filter out non-primes\n5. No filter\nNumber Selection: ',
        (num) => {

            num = parseInt(num);

            if (!isNaN(num)) {

                switch (num) {
                    case 1:

                        filteredArray = fibArr.filter(num => {return num % 2 != 0})
                        
                        break;
                    case 2:

                        filteredArray = fibArr.filter(num => {return num % 2 == 0})
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        break;
                
                }

                console.log(fibArr);
                select_operation()
                
            } else {

                console.log('This is not a vaild number selection, try again...\n\n');
                select_filter()

            }

           

        })
}

//select operation to do upon the filtered array, called after the filter is selected or from the nav menu

function select_operation() {

    console.log(`Your fibonacci sequence:\n\n${filteredArray}\n${lb.repeat(4)}`);

    console.log('What operation would you like to preform on the remaining numbers in your fibonacci sequence?');
    
    rl.question('\n1. Sum of all numbers\n2. Diffrence (starting from the last)\n3. Product\n4. Quotent (starting from the last)\n5. Reverse the sequence (and select again)\nNumber Selection: ',

    (num) => {

        num = parseInt(num);

        if (!isNaN(num)) {

            let finalAnswer, operationString = '', operation;

            switch (num) {
                case 1: //SUM
    
                    finalAnswer = filteredArray.reduce((a,b) => {return a+b})

                    operation = '+'

                    break;
            
                case 2: //Diffrence 
    
                    finalAnswer = filteredArray.reduce((a,b) => {return a-b})

                    operation = '-'
                                    
                    break;
    
                case 3: //Product

                    finalAnswer = filteredArray.reduce((a,b) => {return a*b});

                    operation = 'x';
                                
                    break;
               
                case 4: //Quotent

                    finalAnswer = filteredArray.reduce((a,b) => {return a/b});

                    operation = '/';
    
                    break;
                case 5:
                    filteredArray.reverse()
                    select_operation()
                    return

            }

            for (let i = 0; i < filteredArray.length; i++) {
                if (i < filteredArray.length - 1) {

                    operationString += `${filteredArray[i]} ${operation} `;
                } else {
                    operationString += `${filteredArray[i]} = `;
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

//Navigation function, called after operation is selected

function nav() {

    console.log('\n\nWould you like to...\n');
    
    rl.question('1. Create a new Fibonacci sequence\n2. Select a diffrent operation\n3. Select a diffrent filter\n4. Exit the program\nNumber Selection: ', (num) => {

        switch (num) {
            case '1':

                fibArr = [];
                select_range()

            break;

            case '2':

                select_operation()

            break;

            case '3':

                select_filter()

            break

            case '4':

                console.log('Thank you for using this program...');
                rl.close()

            break;

            default:
                console.log('That was not a vaild entry, try again...');
                nav()
                
        }

    })
    
}
