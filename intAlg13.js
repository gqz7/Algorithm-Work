//least common multiple

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let primeFactorArray;

console.log('enter two or more numbers seperated by spaces or commas. then the output will be the Least Common Multiple of thoes nubers');

find_lcm()

function find_lcm() {
    
    
    rl.question('Numbers: ', (numbers) => {
        factors = numbers.replace(/ /g, ',').split(',').filter(num => {return !isNaN(parseInt(num))});

        primeFactorArray = []

        for (let i = 0; i < factors.length; i++) {

            let num = factors[i];
            
           factorialize(num);
            
        }

        let lcm = primeFactorArray.reduce((a,b) => {return a*b});

        console.log(primeFactorArray);

        console.log(`The Least Common Factor of ${primeFactorArray} is ${lcm}`);
        
        
    })
}


function factorialize(num) {
    

    let primeFactor = 2,
        pFactorsArr = [];

    while (primeFactor <= num) {

        console.log(num,  primeFactor, primeFactorArray);

        if (num % primeFactor == 0) {
            primeFactorArray.push(primeFactor);

            if (num / primeFactor == 1) {

                primeFactor = num + 1;
                
            } else {

                num = num / primeFactor;
                
            }

        } else {
            primeFactor++
        }
        
    }

} 