var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

rl.question('enter a number\nInput: ', (input) => {
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
        
        console.log(primeNums);
        rl.close()
        
        
    } else {
        console.log('try entering a number next time...');
        rl.close()
    }
      
})