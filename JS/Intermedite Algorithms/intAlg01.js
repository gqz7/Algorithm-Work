//sum of all numbers in a range

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

rl.question('Enter two numbers and the output will be the sum of all numbers in that range\nNumbers: ', (numbers) => {

    //this will leave the computer with only ints in the order they were given and put them into an array
    numbers = numbers.replace(/ /g, ",").split(',').filter(num => !isNaN(parseInt(num)));

    numbers[0] = parseInt(numbers[0]); //converting user input from string to ints
    numbers[1] = parseInt(numbers[1]);

    numbers = numbers.slice(0,2).sort((a,b) => {return a-b}); //taking the first two the user inputs and sorting in acceding order

    let sum = 0; //this will be the final answer

    for (let i = numbers[0]; i <= numbers[1]; i++) {

        // console.log(i, sum); //for testing
        sum += i;
        
    }
    
    console.log(`The sum of all numbers between ${numbers[0]} and ${numbers[1]} is ${sum}!`);
    
    rl.close()
})