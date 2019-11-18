var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

rl.question('enter a number, the output will be the sum of all prime numbers upto and including your input\nInput: ', (input) => {
    let number = parseInt(input);
    
    if (!isNaN(number)) {
        allNums = Array.from({ length: number + 1 }, (a, b) => b).slice(2);
        var primeNums = allNums.filter((num) => {
            for (let i = 2 ; i <= Math.ceil(Math.sqrt(number)); i++) {
                if (num % i === 0 && num !== i) {
                    return false
                } 
            }
            
            return true

        })
        
        rl.question(`What opperation would you like to preform on the prime numbers between 0 and ${number}?\nAddition + (add), Subtraction - (sub), Multiplication x (mult), or Division / (div) ?\nInput: `, 
        (input) => {  input = input.trim().toLowerCase().substring(0,1);

            let answer;

            switch (input) {
                case 'a':

                    answer = primeNums.reduce((a,b) => a + b);
                    
                    break;
                case 's':

                    answer = primeNums.reduce((a,b) => a - b);
                    
                    break;
                case 'm':

                    answer = primeNums.reduce((a,b) => a * b);
                    
                    break;
                case 'd':

                    answer = primeNums.reduce((a,b) => a / b);
                    
                    break;
            
                default:
                    console.log('not a vaild input, sorry program will close');
                    rl.close()
                    break;
            }
            console.log(answer);
            rl.close()
            
        })

        

        
        
    } else {
        console.log('try entering a number next time...');
        rl.close()
    }
      
})