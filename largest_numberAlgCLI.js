var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    }),
    largeNum = 0,
    numRegEX = /\d/g;

rl.question(`Hello, please enter numbers in a list ie: 3,1,4,5,9, then the largest one will be your output on the next line\n`, (numArr) => {

    numArr = numArr.split(',');
   
    for (let i = 0; i < numArr.length; i++) {
        if ( numArr[i].match(numRegEX) && numArr[i] > largeNum ) {
            numArr[i] = parseInt(numArr[i]);
             largeNum = numArr[i];
            
        }
        
    }
    console.log(`---------------------\nThe largest number that you gave us was ${largeNum}.`);
    rl.close();

})