'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the getMinimumCost function below.
function getMinimumCost(k, c) {


  console.log(k,c);
}

function main() {
    // const text = fs.readFileSync("./florist.txt");
    // const ws = fs.createWriteStream(text);

    const nk = readLine().split(' ');

    const k = parseInt(nk[1], 10);

    const c = readLine().split(' ').map(cTemp => parseInt(cTemp, 10));

    const minimumCost = getMinimumCost(k, c);

    console.log("The minimum cost is: " + minimumCost);
}
