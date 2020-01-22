//least common multiple

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

console.log('enter two or more numbers seperated by spaces or commas. then the output will be the Least Common Multiple of thoes nubers');

enter_factors()

function enter_factors() {
    
    
    rl.question('Numbers: ', (numbers) => {
        factors = numbers.replace(/ /g, ',').split(',').filter(num => {return !isNaN(parseInt(num))});

        console.log(factors);
        
    })
}