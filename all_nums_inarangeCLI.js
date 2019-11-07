var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    })

rl.question("\nEnter two numbers and we will output the sum of all numbers in that range\nEx. input: 1,3 output: 6\nexcepted formating: [1 2], [1,2], 1 2, 1,2\n\nEnter Two Numbers:  ", (range) => {
    range = range.trim().replace(/\[|\]/g, "").replace(/ /g, ",");
    let sum = 0;

    if (range.includes(",")) {
        range = range.split(",")
    }
    for (let i = 0; i < range.length; i++) {
        if (range[i] == ""){
            range.splice(i, 1);
            i--
        }
        
    }
    
    console.log(range);
    range.sort((a,b) => {return a-b});

    for (let i = range[0]; i <= range[range.length-1]; i++) {
        sum += parseInt(i);
    }

    console.log(`----------------\nThe sum of all the numbers between ${range[0]} and ${range[range.length-1]} is ${sum}.`);
    rl.close();
})