var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

function largest() {
    rl.question(`Enter numbers in a list of numbers (array like format) ie: (3,1,4,5,9), [3 2 7] then the largest one will be found.\nArray: `, (array) => {
        array = array.trim().replace(/\(|\)|\[|\]|[a-z]/gi, '').replace(/\,/g, ' ').split(' ');

        console.log(array);
        
    })
}
largest()